package fi.dy.masa.tweakeroo.config;

import com.google.gson.JsonElement;
import com.google.gson.JsonPrimitive;
import fi.dy.masa.malilib.config.ConfigType;
import fi.dy.masa.malilib.config.IConfigBoolean;
import fi.dy.masa.malilib.config.IConfigNotifiable;
import fi.dy.masa.malilib.config.IHotkeyTogglable;
import fi.dy.masa.malilib.gui.GuiBase;
import fi.dy.masa.malilib.hotkeys.IKeybind;
import fi.dy.masa.malilib.hotkeys.KeyCallbackToggleBooleanConfigWithMessage;
import fi.dy.masa.malilib.hotkeys.KeybindMulti;
import fi.dy.masa.malilib.hotkeys.KeybindSettings;
import fi.dy.masa.malilib.interfaces.IValueChangeCallback;
import fi.dy.masa.malilib.util.StringUtils;
import fi.dy.masa.tweakeroo.Tweakeroo;

public enum FeatureToggle implements IHotkeyTogglable, IConfigNotifiable<IConfigBoolean>
{
    CARPET_ACCURATE_PLACEMENT_PROTOCOL ("carpetAccuratePlacementProtocol",  false, "",    "If enabled, then the Flexible Block Placement and the\nAccurate Block Placement use the protocol implemented\nin the recent carpet mod versions", "Carpet protocol Accurate Placement"),
    FAST_PLACEMENT_REMEMBER_ALWAYS  ("fastPlacementRememberOrientation",    true, "",     "启用该选项后，快速建造模式将始终记住您放置的第一个方块的方向，\n否则将仅在启用并激活灵活放置功能的情况下记住方块方向", "Fast Placement Remember Orientation"),
    REMEMBER_FLEXIBLE               ("rememberFlexibleFromClick",           true, "",     "启用该选项后，只要按住使用键，就会从第一个放置的方块中记住灵活方块的放置状态。", "Remember Flexible Orientation From First Click"),
    TWEAK_ACCURATE_BLOCK_PLACEMENT  ("tweakAccurateBlockPlacement",         false, "",    "启用更简单的“灵活放置”，类似于Carpet mod，因此基本可以使所单击的方块朝向内或向外。"),
    TWEAK_AFTER_CLICKER             ("tweakAfterClicker",                   false, "",    KeybindSettings.INGAME_BOTH, "启用自动调整功能，该功能会自动在刚放置的方块上单击鼠标右键。\n对于设置中继器延迟来说很有用。\n要快速调整单击次数，请在按住绑定按键的同时滚动滚轮"),
    TWEAK_AIM_LOCK                  ("tweakAimLock",                        false, "",    "！！！！！！！启用瞄准锁定，将偏航和俯仰旋转锁定为当前值。这与捕捉锁定不同，后者将锁定锁定为捕捉值，从而可以将锁定自由锁定为当前值"),
    TWEAK_ANGEL_BLOCK               ("tweakAngelBlock",                     false, "",    "启用“天使方块”选项，从而允许在半空中放置方块（仅限创造模式）"),
    TWEAK_BLOCK_REACH_OVERRIDE      ("tweakBlockReachOverride",             false, "",    "使用在 Generic -> blockReachDistance 中设置的距离覆盖默认的玩家可触碰到的方块距离"),
    TWEAK_BREAKING_GRID             ("tweakBreakingGrid",                   false, "",    KeybindSettings.INGAME_BOTH, "启用后，您只能在可配置的间隔中破坏方块。\n要快速调整间隔，请在按住绑定按键的同时滚动滚轮"),
    TWEAK_BREAKING_RESTRICTION      ("tweakBreakingRestriction",            false, "",    "启用“突破限制”模式（平面，图层，面，列，直线，对角线）。\n简单来说按住左键不能连续破坏方块，需要多次点击"),
    TWEAK_CHAT_BACKGROUND_COLOR     ("tweakChatBackgroundColor",            false, "",    "使用在 Generics->chat BackgroundColor 中设置的颜色覆盖默认的聊天背景颜色"),
    TWEAK_CHAT_PERSISTENT_TEXT      ("tweakChatPersistentText",             false, "",    "存储聊天框中的文本，并在再次打开聊天框时将其还原"),
    TWEAK_CHAT_TIMESTAMP            ("tweakChatTimestamp",                  false, "",    "在聊天消息上添加时间戳"),
    TWEAK_COMMAND_BLOCK_EXTRA_FIELDS("tweakCommandBlockExtraFields",        false, "",    "向命令方块的 GUI 添加额外的字段，用于设置命令块的名称并查看统计信息结果"),
    TWEAK_CUSTOM_FLAT_PRESETS       ("tweakCustomFlatPresets",              false, "",    "允许将自定义超平坦世界预设添加到列表中。预设需要在 Lists -> flatWorldPresets 中定义"),
    TWEAK_ELYTRA_CAMERA             ("tweakElytraCamera",                   false, "",    "允许在按住 \"elytraCamera\" 激活键的同时锁定玩家的真实旋转，\n然后控件将仅影响单独的'视角旋转'。\n推荐仅在良好而笔直地飞行时向下/环顾四周"),
    TWEAK_SHULKERBOX_STACKING       ("tweakEmptyShulkerBoxesStack",         false, true, "",    "启用该选项后，最多可堆叠64个空的潜影盒。\n注意：它们将堆叠在一起！在服务器上，这将导致故障，除非服务器具有与之相同的 mod。\n在单人游戏中，这会更改基于潜影盒的系统行为"),
    TWEAK_SHULKERBOX_STACK_GROUND   ("tweakEmptyShulkerBoxesStackOnGround", false, true, "",    "当作为地面上的物品时，最多可堆叠64个空的潜影盒"),
    TWEAK_EXPLOSION_REDUCED_PARTICLES ("tweakExplosionReducedParticles",    false, "",    "启用该选项后，所有爆炸粒子都将使用 EXPLOSION_NORMAL 粒子，\n而不是 EXPLOSION LARGE 或 EXPLOSION HUGE 粒子"),
    TWEAK_F3_CURSOR                 ("tweakF3Cursor",                       false, "",    "启用该选项后，将始终显示与F3屏幕中样式相同的光标"),
    TWEAK_FAKE_SNEAKING             ("tweakFakeSneaking",                   false, "",    "启用虚假潜行，即防止您从边缘跌落，且不降低移动速度"),
    TWEAK_FAST_BLOCK_PLACEMENT      ("tweakFastBlockPlacement",             false, "",    "将光标移到新方块上时，快速地放置方块"),
    TWEAK_FAST_LEFT_CLICK           ("tweakFastLeftClick",                  false, "",    "在按住攻击按钮的时候自动快速单击左键。\n在 Generic -> fastLeftClickCount 中可以设置每个 tick 的点击次数"),
    TWEAK_FAST_RIGHT_CLICK          ("tweakFastRightClick",                 false, "",    "在按住攻击按钮的时候自动快速单击右键。\n在 Generic -> fastRightClickCount 中可以设置每个 tick 的点击次数"),
    TWEAK_FILL_CLONE_LIMIT          ("tweakFillCloneLimit",                 false, true, "",    "允许在单人游戏中自定义/fill和/clone命令的方块上限,\n可以在通用 -> fillCloneLimit中调整"),
    TWEAK_FLY_SPEED                 ("tweakFlySpeed",                       false, "",    KeybindSettings.INGAME_BOTH, "允许在创造或旁观者模式自定义飞行速度并为其使用一些预设"),
    TWEAK_FLEXIBLE_BLOCK_PLACEMENT  ("tweakFlexibleBlockPlacement",         false, "",    "按住热键来以不同状态放置方块"),
    TWEAK_FREE_CAMERA               ("tweakFreeCamera",                     false, "",    "开启自由视角模式(观察者模式!),但玩家将保留在首次激活该模式的位置"),
    TWEAK_FREE_CAMERA_MOTION        ("tweakFreeCameraMotion",               false, "",    "启用后，在自由视角模式模式下的WASD将不会输入给玩家本体\nThis option is provided so that it's also possible to control\nthe actual player while in Free Camera mode, by disabling this option.\nNormally, if you just want to control the camera entity while in Free camera mode,\nthen just set the same hotkey for both features."),
    TWEAK_GAMMA_OVERRIDE            ("tweakGammaOverride",                  false, "",    "无 限 夜 视"),
    TWEAK_HAND_RESTOCK              ("tweakHandRestock",                    false, "",    "自 动 补 货"),
    TWEAK_HOLD_ATTACK               ("tweakHoldAttack",                     false, "",    "模拟按住左键"),
    TWEAK_HOLD_USE                  ("tweakHoldUse",                        false, "",    "模拟按住右键"),
    TWEAK_HOTBAR_SCROLL             ("tweakHotbarScroll",                   false, "",    "启用物品栏滚动选择"),
    TWEAK_HOTBAR_SLOT_CYCLE         ("tweakHotbarSlotCycle",                false, "",    KeybindSettings.INGAME_BOTH, "允许在放置方块后循环选定的快捷栏栏位,直到设置的最大栏位"),
    TWEAK_HOTBAR_SLOT_RANDOMIZER    ("tweakHotbarSlotRandomizer",           false, "",    KeybindSettings.INGAME_BOTH, "允许在放置方块后随机选定的快捷栏栏位,直到设置的最大栏位"),
    TWEAK_HOTBAR_SWAP               ("tweakHotbarSwap",                     false, "",    "通过热键启用物品栏滚动选择功能"),
    TWEAK_INVENTORY_PREVIEW         ("tweakInventoryPreview",               false, true, "",    "内容物预览(箱子、潜影盒)"),
    TWEAK_ITEM_UNSTACKING_PROTECTION("tweakItemUnstackingProtection",       false, "",    "防止在舀岩浆时因为背包满了而把岩浆桶扔进岩浆,\n可以在列表 -> unstackingItems中自定义适用的物品(水瓶之类的)"),
    TWEAK_LAVA_VISIBILITY           ("tweakLavaVisibility",                 false, "",    "岩 浆 夜 视(戴着水下呼吸的帽子进岩浆可以看得更清楚)"),
    TWEAK_MAP_PREVIEW               ("tweakMapPreview",                     false, "",    "如果启用，则在按住shift指向地图将呈现地图预览"),
    TWEAK_MOVEMENT_KEYS             ("tweakMovementKeysLast",               false, "",    "启用后按下相反的移动键不会停下来，而是以最后按的方向键的方向进行移动"),
    TWEAK_PERIODIC_ATTACK           ("tweakPeriodicAttack",                 false, "",    "长按左键自动攻击\nConfigure the interval in Generic -> periodicAttackInterval"),
    TWEAK_PERIODIC_USE              ("tweakPeriodicUse",                    false, "",    "长按右键自动使用\nConfigure the interval in Generic -> periodicUseInterval"),
    TWEAK_PERMANENT_SNEAK           ("tweakPermanentSneak",                 false, "",    "启用后会一直潜行"),
    TWEAK_PERMANENT_SPRINT          ("tweakPermanentSprint",                false, "",    "启用后在前进时会自动进入疾跑"),
    TWEAK_PLACEMENT_GRID            ("tweakPlacementGrid",                  false, "",    KeybindSettings.INGAME_BOTH, "启用后，只能以网格模式放置方块，间隔可自定义"),
    TWEAK_PLACEMENT_LIMIT           ("tweakPlacementLimit",                 false, "",    KeybindSettings.INGAME_BOTH, "启用后每次右键最多只能放置一定数量的方块,可自定义上限"),
    TWEAK_PLACEMENT_RESTRICTION     ("tweakPlacementRestriction",           false, "",    "启用放置限制模式(Plane, Layer, Face, Column, Line, Diagonal)"),
    TWEAK_PLACEMENT_REST_FIRST      ("tweakPlacementRestrictionFirst",      false, "",    "启用后只放置在与首次放置的方块类型相同的方块上"),
    TWEAK_PLACEMENT_REST_HAND       ("tweakPlacementRestrictionHand",       false, "",    "启用后只放置在与手中的方块类型相同的方块上"),
    TWEAK_PLAYER_INVENTORY_PEEK     ("tweakPlayerInventoryPeek",            false, "",    "按住热键以查看/预览玩家清单"),
    TWEAK_POTION_WARNING            ("tweakPotionWarning",                  false, "",    "当药水效果快要结束时发出警告"),
    TWEAK_PRINT_DEATH_COORDINATES   ("tweakPrintDeathCoordinates",          false, "",    "启用后在死亡时将会将死亡坐标发送到聊天栏\nThis feature is originally from usefulmod by nessie."),
    TWEAK_PICK_BEFORE_PLACE         ("tweakPickBeforePlace",                false, "",    "如果启用，则在每个块放置之前，将切换到要放置的同一个块"),
    TWEAK_PLAYER_LIST_ALWAYS_ON     ("tweakPlayerListAlwaysVisible",        false, "",    "使玩家列表一直出现(相当于按住Tab)"),
    TWEAK_REMOVE_OWN_POTION_EFFECTS ("tweakRemoveOwnPotionEffects",         false, "",    "移除药水的粒子效果(仅对于自己)"),
    TWEAK_RENDER_INVISIBLE_ENTITIES ("tweakRenderInvisibleEntities",        false, "",    "启用后，不可见实体的呈现方式与在旁观者模式下的呈现方式相同"),
    TWEAK_RENDER_LIMIT_ENTITIES     ("tweakRenderLimitEntities",            false, "",    "允许限制每帧渲染的实体数和经验球数,在通用设置中自定义数量上限"),
    TWEAK_REPAIR_MODE               ("tweakRepairMode",                     false, "",    "经验修复模式(耐久修复满了会自动切换装备)"),
    TWEAK_SHULKERBOX_DISPLAY        ("tweakShulkerBoxDisplay",              false, "",    "按住shift来预览潜影盒内容物"),
    TWEAK_SIGN_COPY                 ("tweakSignCopy",                       false, "",    "告示牌内容复制(开启后放的牌子会预先写好上一个牌子的内容)"),
    TWEAK_SNAP_AIM                  ("tweakSnapAim",                        false, "",    KeybindSettings.INGAME_BOTH, "启用快速瞄准，使玩家面对预先设定的精确偏航角旋转"),
    TWEAK_SNAP_AIM_LOCK             ("tweakSnapAimLock",                    false, "",    "启用快速瞄准锁定，将偏航角和/或俯仰角旋转锁定到当前捕捉的值"),
    TWEAK_SPECTATOR_TELEPORT        ("tweakSpectatorTeleport",              false, "",    "允许观察者传送到其他观察者的位置\nThis is originally from usefulmod by nessie."),
    TWEAK_STRUCTURE_BLOCK_LIMIT     ("tweakStructureBlockLimit",            false, true, "",    "自定义结构方块的范围上限,在通用 -> structureBlockMaxSize中调整"),
    TWEAK_SWAP_ALMOST_BROKEN_TOOLS  ("tweakSwapAlmostBrokenTools",          false, "",    "自动替换快坏掉的工具"),
    TWEAK_TAB_COMPLETE_COORDINATE   ("tweakTabCompleteCoordinate",          false, "",    "启用后,在用Tab补全坐标时如果不看方块,会使用玩家当前坐标(而不是~ ~ ~)"),
    TWEAK_TOOL_SWITCH               ("tweakToolSwitch",                     false, "",    "能够自动切换到合适的工具"),
    TWEAK_Y_MIRROR                  ("tweakYMirror",                        false, "",    "镜像放方块(比如反向放楼梯)"),
    TWEAK_ZOOM                      ("tweakZoom",                           false, "",    KeybindSettings.INGAME_BOTH, "允许使用缩放热键");

    private final String name;
    private final String comment;
    private final String prettyName;
    private final IKeybind keybind;
    private final boolean defaultValueBoolean;
    private final boolean singlePlayer;
    private boolean valueBoolean;
    private IValueChangeCallback<IConfigBoolean> callback;

    private FeatureToggle(String name, boolean defaultValue, String defaultHotkey, String comment)
    {
        this(name, defaultValue, false, defaultHotkey, KeybindSettings.DEFAULT, comment);
    }

    private FeatureToggle(String name, boolean defaultValue, boolean singlePlayer, String defaultHotkey, String comment)
    {
        this(name, defaultValue, singlePlayer, defaultHotkey, KeybindSettings.DEFAULT, comment);
    }

    private FeatureToggle(String name, boolean defaultValue, String defaultHotkey, KeybindSettings settings, String comment)
    {
        this(name, defaultValue, false, defaultHotkey, settings, comment);
    }

    private FeatureToggle(String name, boolean defaultValue, boolean singlePlayer, String defaultHotkey, KeybindSettings settings, String comment)
    {
        this(name, defaultValue, singlePlayer, defaultHotkey, settings, comment, StringUtils.splitCamelCase(name.substring(5)));
    }

    private FeatureToggle(String name, boolean defaultValue, String defaultHotkey, String comment, String prettyName)
    {
        this(name, defaultValue, false, defaultHotkey, comment, prettyName);
    }

    private FeatureToggle(String name, boolean defaultValue, boolean singlePlayer, String defaultHotkey, String comment, String prettyName)
    {
        this(name, defaultValue, singlePlayer, defaultHotkey, KeybindSettings.DEFAULT, comment, prettyName);
    }

    private FeatureToggle(String name, boolean defaultValue, boolean singlePlayer, String defaultHotkey, KeybindSettings settings, String comment, String prettyName)
    {
        this.name = name;
        this.valueBoolean = defaultValue;
        this.defaultValueBoolean = defaultValue;
        this.singlePlayer = singlePlayer;
        this.comment = comment;
        this.prettyName = prettyName;
        this.keybind = KeybindMulti.fromStorageString(defaultHotkey, settings);
        this.keybind.setCallback(new KeyCallbackToggleBooleanConfigWithMessage(this));
    }

    @Override
    public ConfigType getType()
    {
        return ConfigType.HOTKEY;
    }

    @Override
    public String getName()
    {
        return this.name;
    }

    @Override
    public String getConfigGuiDisplayName()
    {
        if (this.singlePlayer)
        {
            return GuiBase.TXT_GOLD + this.getName() + GuiBase.TXT_RST;
        }

        return this.getName();
    }

    @Override
    public String getPrettyName()
    {
        return this.prettyName;
    }

    @Override
    public String getStringValue()
    {
        return String.valueOf(this.valueBoolean);
    }

    @Override
    public String getDefaultStringValue()
    {
        return String.valueOf(this.defaultValueBoolean);
    }

    @Override
    public void setValueFromString(String value)
    {
    }

    @Override
    public void onValueChanged()
    {
        if (this.callback != null)
        {
            this.callback.onValueChanged(this);
        }
    }

    @Override
    public void setValueChangeCallback(IValueChangeCallback<IConfigBoolean> callback)
    {
        this.callback = callback;
    }

    @Override
    public String getComment()
    {
        if (this.comment == null)
        {
            return "";
        }

        if (this.singlePlayer)
        {
            return this.comment + "\n" + StringUtils.translate("tweakeroo.label.config_comment.single_player_only");
        }
        else
        {
            return this.comment;
        }
    }

    @Override
    public IKeybind getKeybind()
    {
        return this.keybind;
    }

    @Override
    public boolean getBooleanValue()
    {
        return this.valueBoolean;
    }

    @Override
    public boolean getDefaultBooleanValue()
    {
        return this.defaultValueBoolean;
    }

    @Override
    public void setBooleanValue(boolean value)
    {
        boolean oldValue = this.valueBoolean;
        this.valueBoolean = value;

        if (oldValue != this.valueBoolean)
        {
            this.onValueChanged();
        }
    }

    @Override
    public boolean isModified()
    {
        return this.valueBoolean != this.defaultValueBoolean;
    }

    @Override
    public boolean isModified(String newValue)
    {
        return Boolean.parseBoolean(newValue) != this.defaultValueBoolean;
    }

    @Override
    public void resetToDefault()
    {
        this.valueBoolean = this.defaultValueBoolean;
    }

    @Override
    public JsonElement getAsJsonElement()
    {
        return new JsonPrimitive(this.valueBoolean);
    }

    @Override
    public void setValueFromJsonElement(JsonElement element)
    {
        try
        {
            if (element.isJsonPrimitive())
            {
                this.valueBoolean = element.getAsBoolean();
            }
            else
            {
                Tweakeroo.logger.warn("Failed to set config value for '{}' from the JSON element '{}'", this.getName(), element);
            }
        }
        catch (Exception e)
        {
            Tweakeroo.logger.warn("Failed to set config value for '{}' from the JSON element '{}'", this.getName(), element, e);
        }
    }
}
