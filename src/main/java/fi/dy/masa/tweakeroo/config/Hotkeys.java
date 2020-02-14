package fi.dy.masa.tweakeroo.config;

import java.util.List;
import com.google.common.collect.ImmutableList;
import fi.dy.masa.malilib.config.options.ConfigHotkey;
import fi.dy.masa.malilib.hotkeys.KeybindSettings;

public class Hotkeys
{
    public static final ConfigHotkey ACCURATE_BLOCK_PLACEMENT_IN        = new ConfigHotkey("accurateBlockPlacementInto",        "",     KeybindSettings.PRESS_ALLOWEXTRA, "开关精确方块放置模式的热键");
    public static final ConfigHotkey ACCURATE_BLOCK_PLACEMENT_REVERSE   = new ConfigHotkey("accurateBlockPlacementReverse",     "",     KeybindSettings.PRESS_ALLOWEXTRA, "用于激活精确块放置模式/覆盖的热键，用于使块面向与通常相反的方向");
    public static final ConfigHotkey BREAKING_RESTRICTION_MODE_COLUMN   = new ConfigHotkey("breakingRestrictionModeColumn",     "",     "切换破坏限制模式至列模式(只能破坏一列的方块)");
    public static final ConfigHotkey BREAKING_RESTRICTION_MODE_DIAGONAL = new ConfigHotkey("breakingRestrictionModeDiagonal",   "",     "切换破坏限制模式至对角线模式");
    public static final ConfigHotkey BREAKING_RESTRICTION_MODE_FACE     = new ConfigHotkey("breakingRestrictionModeFace",       "",     "切换破坏限制模式至面对模式");
    public static final ConfigHotkey BREAKING_RESTRICTION_MODE_LAYER    = new ConfigHotkey("breakingRestrictionModeLayer",      "",     "切换破坏限制模式至层模式");
    public static final ConfigHotkey BREAKING_RESTRICTION_MODE_LINE     = new ConfigHotkey("breakingRestrictionModeLine",       "",     "切换破坏限制模式至线模式");
    public static final ConfigHotkey BREAKING_RESTRICTION_MODE_PLANE    = new ConfigHotkey("breakingRestrictionModePlane",      "",     "切换破坏限制模式至平面模式");
    public static final ConfigHotkey COPY_SIGN_TEXT                     = new ConfigHotkey("copySignText",                      "",     "从已经放置的告示牌复制文本\nThat text can be used with the tweakSignCopy tweak.");
    public static final ConfigHotkey ELYTRA_CAMERA                      = new ConfigHotkey("elytraCamera",                      "",     "开启飞行视角模式\nThe key to lock the current real player rotations, only allowing the\ninputs (mouse) to affect separate \"camera rotations\" used only for the rendering\nwhile this key is active.\nMeant for freely looking down/around while elytra flying straight.");
    public static final ConfigHotkey FLEXIBLE_BLOCK_PLACEMENT_ADJACENT  = new ConfigHotkey("flexibleBlockPlacementAdjacent",    "",     KeybindSettings.PRESS_ALLOWEXTRA, "用于将方块放置在合适位置");
    public static final ConfigHotkey FLEXIBLE_BLOCK_PLACEMENT_OFFSET    = new ConfigHotkey("flexibleBlockPlacementOffset",      "LEFT_CONTROL", KeybindSettings.PRESS_ALLOWEXTRA, "用于将方块放置在偏移或对角线位置");
    public static final ConfigHotkey FLEXIBLE_BLOCK_PLACEMENT_ROTATION  = new ConfigHotkey("flexibleBlockPlacementRotation",    "LEFT_ALT", KeybindSettings.PRESS_ALLOWEXTRA, "用于放置具有旋转/面向的方块");
    public static final ConfigHotkey FLY_PRESET_1                       = new ConfigHotkey("flyPreset1",                        "",     "切换至飞行预设 1");
    public static final ConfigHotkey FLY_PRESET_2                       = new ConfigHotkey("flyPreset2",                        "",     "切换至飞行预设 2");
    public static final ConfigHotkey FLY_PRESET_3                       = new ConfigHotkey("flyPreset3",                        "",     "切换至飞行预设 3");
    public static final ConfigHotkey FLY_PRESET_4                       = new ConfigHotkey("flyPreset4",                        "",     "切换至飞行预设 4");
    public static final ConfigHotkey HOTBAR_SCROLL                      = new ConfigHotkey("hotbarScroll",                      "",     KeybindSettings.RELEASE_ALLOW_EXTRA, "按住以允许物品栏滚动选择");
    public static final ConfigHotkey HOTBAR_SWAP_BASE                   = new ConfigHotkey("hotbarSwapBase",                    "",     KeybindSettings.PRESS_ALLOWEXTRA, "显示快捷栏/库存覆盖的基本键");
    public static final ConfigHotkey HOTBAR_SWAP_1                      = new ConfigHotkey("hotbarSwap1",                       "",     "将快捷栏交换为背包最上面一行");
    public static final ConfigHotkey HOTBAR_SWAP_2                      = new ConfigHotkey("hotbarSwap2",                       "",     "将快捷栏交换为背包中间一行");
    public static final ConfigHotkey HOTBAR_SWAP_3                      = new ConfigHotkey("hotbarSwap3",                       "",     "将快捷栏交换为背包最下面一行");
    public static final ConfigHotkey INVENTORY_PREVIEW                  = new ConfigHotkey("inventoryPreview",                  "LEFT_ALT", KeybindSettings.PRESS_ALLOWEXTRA, "激活内容预览的按键");
    public static final ConfigHotkey OPEN_CONFIG_GUI                    = new ConfigHotkey("openConfigGui",                     "X,C",  "用于打开Tweakeroo设置界面的热键");
    public static final ConfigHotkey PLACEMENT_Y_MIRROR                 = new ConfigHotkey("placementYMirror",                  "",     KeybindSettings.PRESS_ALLOWEXTRA, "反转指向目标方块y轴的按键");
    public static final ConfigHotkey PLAYER_INVENTORY_PEEK              = new ConfigHotkey("playerInventoryPeek",               "",     KeybindSettings.PRESS_ALLOWEXTRA, "激活玩家库存查看/预览功能的键");
    public static final ConfigHotkey PLACEMENT_RESTRICTION_MODE_COLUMN  = new ConfigHotkey("placementRestrictionModeColumn",    "Z,3",  "切换放置限制模式至列模式(只能在一列放置方块)");
    public static final ConfigHotkey PLACEMENT_RESTRICTION_MODE_DIAGONAL= new ConfigHotkey("placementRestrictionModeDiagonal",  "Z,5",  "切换放置限制模式至对角线模式");
    public static final ConfigHotkey PLACEMENT_RESTRICTION_MODE_FACE    = new ConfigHotkey("placementRestrictionModeFace",      "Z,2",  "切换放置限制模式至面模式");
    public static final ConfigHotkey PLACEMENT_RESTRICTION_MODE_LAYER   = new ConfigHotkey("placementRestrictionModeLayer",     "Z,6",  "切换放置限制模式至层模式");
    public static final ConfigHotkey PLACEMENT_RESTRICTION_MODE_LINE    = new ConfigHotkey("placementRestrictionModeLine",      "Z,4",  "切换放置限制模式至线模式");
    public static final ConfigHotkey PLACEMENT_RESTRICTION_MODE_PLANE   = new ConfigHotkey("placementRestrictionModePlane",     "Z,1",  "切换放置限制模式至平面模式");
    public static final ConfigHotkey SKIP_ALL_RENDERING                 = new ConfigHotkey("skipAllRendering",                  "",     "跳过全部渲染");
    public static final ConfigHotkey SKIP_WORLD_RENDERING               = new ConfigHotkey("skipWorldRendering",                "",     "跳过世界渲染");
    public static final ConfigHotkey TOOL_PICK                          = new ConfigHotkey("toolPick",                          "",     "切换到对目标方块的有效工具");
    public static final ConfigHotkey ZOOM_ACTIVATE                      = new ConfigHotkey("zoomActivate",                      "",     "激活缩放热键");

    public static final List<ConfigHotkey> HOTKEY_LIST = ImmutableList.of(
            ACCURATE_BLOCK_PLACEMENT_IN,
            ACCURATE_BLOCK_PLACEMENT_REVERSE,
            BREAKING_RESTRICTION_MODE_COLUMN,
            BREAKING_RESTRICTION_MODE_DIAGONAL,
            BREAKING_RESTRICTION_MODE_FACE,
            BREAKING_RESTRICTION_MODE_LAYER,
            BREAKING_RESTRICTION_MODE_LINE,
            BREAKING_RESTRICTION_MODE_PLANE,
            COPY_SIGN_TEXT,
            ELYTRA_CAMERA,
            FLEXIBLE_BLOCK_PLACEMENT_ADJACENT,
            FLEXIBLE_BLOCK_PLACEMENT_OFFSET,
            FLEXIBLE_BLOCK_PLACEMENT_ROTATION,
            FLY_PRESET_1,
            FLY_PRESET_2,
            FLY_PRESET_3,
            FLY_PRESET_4,
            HOTBAR_SCROLL,
            HOTBAR_SWAP_BASE,
            HOTBAR_SWAP_1,
            HOTBAR_SWAP_2,
            HOTBAR_SWAP_3,
            INVENTORY_PREVIEW,
            OPEN_CONFIG_GUI,
            PLACEMENT_Y_MIRROR,
            PLAYER_INVENTORY_PEEK,
            PLACEMENT_RESTRICTION_MODE_COLUMN,
            PLACEMENT_RESTRICTION_MODE_DIAGONAL,
            PLACEMENT_RESTRICTION_MODE_FACE,
            PLACEMENT_RESTRICTION_MODE_LAYER,
            PLACEMENT_RESTRICTION_MODE_LINE,
            PLACEMENT_RESTRICTION_MODE_PLANE,
            SKIP_ALL_RENDERING,
            SKIP_WORLD_RENDERING,
            TOOL_PICK,
            ZOOM_ACTIVATE
    );
}
