package fi.dy.masa.tweakeroo.mixin;

import javax.annotation.Nullable;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.At.Shift;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.ModifyVariable;
import org.spongepowered.asm.mixin.injection.Redirect;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import fi.dy.masa.tweakeroo.config.Callbacks;
import fi.dy.masa.tweakeroo.config.Configs;
import fi.dy.masa.tweakeroo.config.FeatureToggle;
import fi.dy.masa.tweakeroo.config.Hotkeys;
import fi.dy.masa.tweakeroo.renderer.RenderUtils;
import fi.dy.masa.tweakeroo.util.CameraUtils;
import fi.dy.masa.tweakeroo.util.MiscUtils;

@Mixin(net.minecraft.client.renderer.EntityRenderer.class)
public abstract class MixinEntityRenderer
{
    @Shadow @Final private net.minecraft.client.Minecraft mc;

    @Nullable private net.minecraft.entity.Entity renderViewEntityOriginal;
    private float realYaw;
    private float realPitch;

    @Redirect(method = "getMouseOver", at = @At(value = "INVOKE",
              target = "Lnet/minecraft/client/Minecraft;getRenderViewEntity()Lnet/minecraft/entity/Entity;"))
    private net.minecraft.entity.Entity returnRealPlayer(net.minecraft.client.Minecraft mc)
    {
        // Return the real player for the hit target ray tracing if the
        // player motion option is enabled in Free Camera mode.
        // Normally in Free Camera mode the Tweakeroo CameraEntity is set as the
        // render view/camera entity, which would then also ray trace from the camera point of view.
        if (FeatureToggle.TWEAK_FREE_CAMERA.getBooleanValue() &&
            Configs.Generic.FREE_CAMERA_PLAYER_MOVEMENT.getBooleanValue() &&
            this.mc.player != null)
        {
            return this.mc.player;
        }

        return mc.getRenderViewEntity();
    }

    @Inject(method = "renderWorld(FJ)V", at = @At("HEAD"), cancellable = true)
    private void onRenderWorld(CallbackInfo ci)
    {
        if (Callbacks.skipWorldRendering)
        {
            ci.cancel();
        }
    }

    @ModifyVariable(method = "renderWorld(FJ)V", at = @At("HEAD"), argsOnly = true)
    private long overrideRenderTimeout(long finishTime)
    {
        if (FeatureToggle.TWEAK_CHUNK_RENDER_TIMEOUT.getBooleanValue())
        {
            return System.nanoTime() + Configs.Generic.CHUNK_RENDER_TIMEOUT.getIntegerValue();
        }

        return finishTime;
    }

    @Inject(method = "setupFog(IF)V", at = @At(
            value = "INVOKE",
            target = "Lnet/minecraft/client/renderer/GlStateManager;setFogDensity(F)V",
            shift = Shift.AFTER,
            ordinal = 4))
    private void onSetupLavaFog(int startCoords, float partialTicks, CallbackInfo ci)
    {
        if (FeatureToggle.TWEAK_LAVA_VISIBILITY.getBooleanValue() && Configs.Generic.LAVA_VISIBILITY_OPTIFINE.getBooleanValue() == false)
        {
            RenderUtils.overrideLavaFog(net.minecraft.client.Minecraft.getMinecraft().getRenderViewEntity());
        }
    }

    @Inject(method = "getFOVModifier", at = @At("HEAD"), cancellable = true)
    private void zoom(float partialTicks, boolean useFOVSetting, CallbackInfoReturnable<Float> cir)
    {
        if (FeatureToggle.TWEAK_ZOOM.getBooleanValue() && Hotkeys.ZOOM_ACTIVATE.getKeybind().isKeybindHeld())
        {
            cir.setReturnValue((float) Configs.Generic.ZOOM_FOV.getDoubleValue());
        }
        // Don't change the FoV when "sprinting" in Free Camera mode, or with the static FoV tweak active 
        else if (FeatureToggle.TWEAK_FREE_CAMERA.getBooleanValue() || FeatureToggle.TWEAK_STATIC_FOV.getBooleanValue())
        {
            cir.setReturnValue(this.mc.gameSettings.fovSetting);
        }
    }

    @Inject(method = "renderRainSnow", at = @At("HEAD"), cancellable = true)
    private void cancelRainRender(float partialTicks, CallbackInfo ci)
    {
        if (Configs.Disable.DISABLE_RAIN_EFFECTS.getBooleanValue())
        {
            ci.cancel();
        }
    }

    @Inject(method = "addRainParticles", at = @At("HEAD"), cancellable = true)
    private void cancelRainRender(CallbackInfo ci)
    {
        if (Configs.Disable.DISABLE_RAIN_EFFECTS.getBooleanValue())
        {
            ci.cancel();
        }
    }

    @Inject(method = "renderWorld(FJ)V", at = @At(
                value = "INVOKE", shift = Shift.AFTER,
                target = "Lnet/minecraft/client/renderer/EntityRenderer;getMouseOver(F)V"))
    private void overrideRenderViewEntityPre(CallbackInfo ci)
    {
        if (FeatureToggle.TWEAK_ELYTRA_CAMERA.getBooleanValue() && Hotkeys.ELYTRA_CAMERA.getKeybind().isKeybindHeld())
        {
            net.minecraft.entity.Entity entity = this.mc.getRenderViewEntity();

            if (entity != null)
            {
                this.realYaw = entity.rotationYaw;
                this.realPitch = entity.rotationPitch;
                MiscUtils.setEntityRotations(entity, CameraUtils.getCameraYaw(), CameraUtils.getCameraPitch());
            }
        }
    }

    @Inject(method = "renderWorld(FJ)V", at = @At("RETURN"))
    private void overrideRenderViewEntityPost(CallbackInfo ci)
    {
        if (FeatureToggle.TWEAK_ELYTRA_CAMERA.getBooleanValue() && Hotkeys.ELYTRA_CAMERA.getKeybind().isKeybindHeld())
        {
            net.minecraft.entity.Entity entity = this.mc.getRenderViewEntity();

            if (entity != null)
            {
                MiscUtils.setEntityRotations(entity, this.realYaw, this.realPitch);
            }
        }
    }

    @Inject(method = "renderHand", at = @At("HEAD"), cancellable = true)
    private void removeHandRendering(CallbackInfo ci)
    {
        if (FeatureToggle.TWEAK_FREE_CAMERA.getBooleanValue())
        {
            ci.cancel();
        }
    }

    @Inject(method = "renderWorldPass", at = @At(
                value = "INVOKE",
                target = "Lnet/minecraft/client/entity/EntityPlayerSP;isSpectator()Z"))
    private void preSetupTerrain(int pass, float partialTicks, long finishTimeNano, CallbackInfo ci)
    {
        CameraUtils.setFreeCameraSpectator(true);
    }

    @Inject(method = "renderWorldPass", at = @At(
                value = "INVOKE", shift = At.Shift.AFTER,
                target = "Lnet/minecraft/client/renderer/RenderGlobal;setupTerrain(" +
                         "Lnet/minecraft/entity/Entity;" +
                         "DLnet/minecraft/client/renderer/culling/ICamera;IZ)V"))
    private void postSetupTerrain(int pass, float partialTicks, long finishTimeNano, CallbackInfo ci)
    {
        CameraUtils.setFreeCameraSpectator(false);
    }
}
