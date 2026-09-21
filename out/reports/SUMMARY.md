# Void deobfuscation report

- mod: Void Modification 1.1.1 1.1.1
- minecraft: ~1.21.4
- mixin classes in refmap: 127

## Mixin → Minecraft (from refmap + yarn)

### `CLASSESS/Gr`
- `renderWidget` → `Lnet/minecraft/SliderWidget;method_48579(Lnet/minecraft/DrawContext;IIF)V`
- `setValueFromMouse` → `Lnet/minecraft/SliderWidget;method_25345(D)V`

### `CLASSESS/ItvQE`
- `drawCenteredTextWithShadow(Lnet/minecraft/client/font/TextRenderer;Ljava/lang/String;III)V` → `Lnet/minecraft/DrawContext;method_25300(Lnet/minecraft/TextRenderer;Ljava/lang/String;III)V`
- `drawCenteredTextWithShadow(Lnet/minecraft/client/font/TextRenderer;Lnet/minecraft/text/OrderedText;III)V` → `Lnet/minecraft/DrawContext;method_35719(Lnet/minecraft/TextRenderer;Lnet/minecraft/OrderedText;III)V`
- `drawCenteredTextWithShadow(Lnet/minecraft/client/font/TextRenderer;Lnet/minecraft/text/Text;III)V` → `Lnet/minecraft/DrawContext;method_27534(Lnet/minecraft/TextRenderer;Lnet/minecraft/Text;III)V`
- `drawText(Lnet/minecraft/client/font/TextRenderer;Ljava/lang/String;IIIZ)I` → `Lnet/minecraft/DrawContext;method_51433(Lnet/minecraft/TextRenderer;Ljava/lang/String;IIIZ)I`
- `drawText(Lnet/minecraft/client/font/TextRenderer;Lnet/minecraft/text/OrderedText;IIIZ)I` → `Lnet/minecraft/DrawContext;method_51430(Lnet/minecraft/TextRenderer;Lnet/minecraft/OrderedText;IIIZ)I`
- `drawText(Lnet/minecraft/client/font/TextRenderer;Lnet/minecraft/text/Text;IIIZ)I` → `Lnet/minecraft/DrawContext;method_51439(Lnet/minecraft/TextRenderer;Lnet/minecraft/Text;IIIZ)I`
- `drawTextWithShadow(Lnet/minecraft/client/font/TextRenderer;Ljava/lang/String;III)I` → `Lnet/minecraft/DrawContext;method_25303(Lnet/minecraft/TextRenderer;Ljava/lang/String;III)I`
- `drawTextWithShadow(Lnet/minecraft/client/font/TextRenderer;Lnet/minecraft/text/OrderedText;III)I` → `Lnet/minecraft/DrawContext;method_35720(Lnet/minecraft/TextRenderer;Lnet/minecraft/OrderedText;III)I`
- `drawTextWithShadow(Lnet/minecraft/client/font/TextRenderer;Lnet/minecraft/text/Text;III)I` → `Lnet/minecraft/DrawContext;method_27535(Lnet/minecraft/TextRenderer;Lnet/minecraft/Text;III)I`

### `CLASSESS/Lc`
- `renderWidget` → `Lnet/minecraft/TabButtonWidget;method_48579(Lnet/minecraft/DrawContext;IIF)V`

### `CLASSESS/M/CJYYzN`
- `mouseClicked` → `Lnet/minecraft/ChatScreen;method_25402(DDI)Z`
- `render` → `Lnet/minecraft/ChatScreen;method_25394(Lnet/minecraft/DrawContext;IIF)V`
- `sendMessage` → `Lnet/minecraft/ChatScreen;method_44056(Ljava/lang/String;Z)V`

### `CLASSESS/M/CNFw`
- `applyFog` → `Lnet/minecraft/BackgroundRenderer;method_3211(Lnet/minecraft/Camera;Lnet/minecraft/BackgroundRenderer$FogType;Lorg/joml/Vector4f;FZF)Lnet/minecraft/Fog;`
- `getFogColor` → `Lnet/minecraft/BackgroundRenderer;method_62185(Lnet/minecraft/Camera;FLnet/minecraft/ClientWorld;IF)Lorg/joml/Vector4f;`

### `CLASSESS/M/HuWVq`
- `Lnet/minecraft/client/render/item/HeldItemRenderer;renderItem(Lnet/minecraft/entity/LivingEntity;Lnet/minecraft/item/ItemStack;Lnet/minecraft/item/ModelTransformationMode;ZLnet/minecraft/client/util/math/MatrixStack;Lnet/minecraft/client/render/VertexConsumerProvider;I)V` → `Lnet/minecraft/HeldItemRenderer;method_3233(Lnet/minecraft/LivingEntity;Lnet/minecraft/ItemStack;Lnet/minecraft/ModelTransformationMode;ZLnet/minecraft/MatrixStack;Lnet/minecraft/VertexConsumerProvider;I)V`
- `Lnet/minecraft/client/render/item/HeldItemRenderer;swingArm(FFLnet/minecraft/client/util/math/MatrixStack;ILnet/minecraft/util/Arm;)V` → `Lnet/minecraft/HeldItemRenderer;method_65816(FFLnet/minecraft/MatrixStack;ILnet/minecraft/Arm;)V`
- `Lnet/minecraft/client/util/math/MatrixStack;push()V` → `Lnet/minecraft/MatrixStack;method_22903()V`
- `renderFirstPersonItem` → `Lnet/minecraft/HeldItemRenderer;method_3228(Lnet/minecraft/AbstractClientPlayerEntity;FFLnet/minecraft/Hand;FLnet/minecraft/ItemStack;FLnet/minecraft/MatrixStack;Lnet/minecraft/VertexConsumerProvider;I)V`

### `CLASSESS/M/I`
- `render` → `Lnet/minecraft/HandledScreen;method_25394(Lnet/minecraft/DrawContext;IIF)V`

### `CLASSESS/M/Jt`
- `onGameJoin` → `Lnet/minecraft/ClientPlayNetworkHandler;method_11120(Lnet/minecraft/GameJoinS2CPacket;)V`
- `onPlaySound` → `Lnet/minecraft/ClientPlayNetworkHandler;method_11146(Lnet/minecraft/PlaySoundS2CPacket;)V`
- `onPlaySoundFromEntity` → `Lnet/minecraft/ClientPlayNetworkHandler;method_11125(Lnet/minecraft/PlaySoundFromEntityS2CPacket;)V`
- `sendChatCommand` → `Lnet/minecraft/ClientPlayNetworkHandler;method_45730(Ljava/lang/String;)V`
- `sendChatMessage` → `Lnet/minecraft/ClientPlayNetworkHandler;method_45729(Ljava/lang/String;)V`
- `sendCommand` → `Lnet/minecraft/ClientPlayNetworkHandler;method_45731(Ljava/lang/String;)Z`

### `CLASSESS/M/Kz`
- `render(Lnet/minecraft/entity/Entity;DDDFLnet/minecraft/client/util/math/MatrixStack;Lnet/minecraft/client/render/VertexConsumerProvider;I)V` → `Lnet/minecraft/EntityRenderDispatcher;method_62424(Lnet/minecraft/Entity;DDDFLnet/minecraft/MatrixStack;Lnet/minecraft/VertexConsumerProvider;I)V`
- `shouldRender` → `Lnet/minecraft/EntityRenderDispatcher;method_3950(Lnet/minecraft/Entity;Lnet/minecraft/Frustum;DDD)Z`

### `CLASSESS/M/La`
- `messages` → `field_2061:Ljava/util/List;`
- `refresh` → `method_44813()V`

### `CLASSESS/M/Pd`
- `onKey` → `Lnet/minecraft/Keyboard;method_1466(JIIII)V`

### `CLASSESS/M/QCYBan`
- `<init>` → `Lnet/minecraft/MinecraftClient;<init>(Lnet/minecraft/RunArgs;)V`
- `setScreen` → `Lnet/minecraft/MinecraftClient;method_1507(Lnet/minecraft/Screen;)V`
- `stop` → `Lnet/minecraft/MinecraftClient;method_1490()V`
- `tick` → `Lnet/minecraft/MinecraftClient;method_1574()V`

### `CLASSESS/M/RH`
- `Lnet/minecraft/entity/Entity;isControlledByPlayer()Z` → `Lnet/minecraft/Entity;method_65038()Z`
- `move` → `Lnet/minecraft/Entity;method_5784(Lnet/minecraft/MovementType;Lnet/minecraft/Vec3d;)V`

### `CLASSESS/M/UMZytA`
- `addWeatherParticlesAndSound` → `Lnet/minecraft/WorldRenderer;method_62209(Lnet/minecraft/Camera;)V`
- `method_62205` → `Lnet/minecraft/WorldRenderer;method_62205(Lnet/minecraft/Handle;ILnet/minecraft/CloudRenderMode;FLorg/joml/Matrix4f;Lorg/joml/Matrix4f;Lnet/minecraft/Vec3d;F)V`
- `method_62215` → `Lnet/minecraft/WorldRenderer;method_62215(Lnet/minecraft/Fog;Lnet/minecraft/DimensionEffects$SkyType;FLnet/minecraft/DimensionEffects;)V`
- `renderClouds` → `Lnet/minecraft/WorldRenderer;method_62204(Lnet/minecraft/FrameGraphBuilder;Lorg/joml/Matrix4f;Lorg/joml/Matrix4f;Lnet/minecraft/CloudRenderMode;Lnet/minecraft/Vec3d;FIF)V`
- `renderWeather` → `Lnet/minecraft/WorldRenderer;method_62203(Lnet/minecraft/FrameGraphBuilder;Lnet/minecraft/Vec3d;FLnet/minecraft/Fog;)V`

### `CLASSESS/M/UWzDe`
- `hasLabel` → `Lnet/minecraft/EntityRenderer;method_3921(Lnet/minecraft/Entity;D)Z`

### `CLASSESS/M/WeuFmN`
- `renderFireOverlay` → `Lnet/minecraft/InGameOverlayRenderer;method_23070(Lnet/minecraft/MatrixStack;Lnet/minecraft/VertexConsumerProvider;)V`
- `renderUnderwaterOverlay` → `Lnet/minecraft/InGameOverlayRenderer;method_23069(Lnet/minecraft/MinecraftClient;Lnet/minecraft/MatrixStack;Lnet/minecraft/VertexConsumerProvider;)V`

### `CLASSESS/M/YHhBPN`
- `Lnet/minecraft/client/gui/DrawContext;drawTextWithShadow(Lnet/minecraft/client/font/TextRenderer;Lnet/minecraft/text/Text;III)I` → `Lnet/minecraft/DrawContext;method_27535(Lnet/minecraft/TextRenderer;Lnet/minecraft/Text;III)I`
- `Lnet/minecraft/client/gui/DrawContext;fill(IIIII)V` → `Lnet/minecraft/DrawContext;method_25294(IIIII)V`
- `collectPlayerEntries` → `method_48213()Ljava/util/List;`
- `render(Lnet/minecraft/client/gui/DrawContext;ILnet/minecraft/scoreboard/Scoreboard;Lnet/minecraft/scoreboard/ScoreboardObjective;)V` → `Lnet/minecraft/PlayerListHud;method_1919(Lnet/minecraft/DrawContext;ILnet/minecraft/Scoreboard;Lnet/minecraft/ScoreboardObjective;)V`

### `CLASSESS/M/al`
- `update` → `Lnet/minecraft/Camera;method_19321(Lnet/minecraft/BlockView;Lnet/minecraft/Entity;ZZF)V`

### `CLASSESS/M/hjmKN`
- `Lnet/minecraft/client/gui/screen/Screen;renderBackground(Lnet/minecraft/client/gui/DrawContext;IIF)V` → `Lnet/minecraft/Screen;method_25420(Lnet/minecraft/DrawContext;IIF)V`
- `render` → `Lnet/minecraft/Screen;method_25394(Lnet/minecraft/DrawContext;IIF)V`

### `CLASSESS/M/jC`
- `update` → `Lnet/minecraft/InactivityFpsLimiter;method_61937()I`

### `CLASSESS/M/jEn`
- `render` → `Lnet/minecraft/BossBarHud;method_1796(Lnet/minecraft/DrawContext;)V`

### `CLASSESS/M/kOLGsi`
- `Lnet/minecraft/client/render/WorldRenderer;renderMain(Lnet/minecraft/client/render/FrameGraphBuilder;Lnet/minecraft/client/render/Frustum;Lnet/minecraft/client/render/Camera;Lorg/joml/Matrix4f;Lorg/joml/Matrix4f;Lnet/minecraft/client/render/Fog;ZZLnet/minecraft/client/render/RenderTickCounter;Lnet/minecraft/util/profiler/Profiler;)V` → `Lnet/minecraft/WorldRenderer;method_62202(Lnet/minecraft/FrameGraphBuilder;Lnet/minecraft/Frustum;Lnet/minecraft/Camera;Lorg/joml/Matrix4f;Lorg/joml/Matrix4f;Lnet/minecraft/Fog;ZZLnet/minecraft/RenderTickCounter;Lnet/minecraft/Profiler;)V`
- `render` → `Lnet/minecraft/WorldRenderer;method_22710(Lnet/minecraft/ObjectAllocator;Lnet/minecraft/RenderTickCounter;ZLnet/minecraft/Camera;Lnet/minecraft/GameRenderer;Lorg/joml/Matrix4f;Lorg/joml/Matrix4f;)V`

### `CLASSESS/M/llQpvq`
- `Lnet/minecraft/client/gui/DrawContext;fill(IIIII)V` → `Lnet/minecraft/DrawContext;method_25294(IIIII)V`
- `render` → `Lnet/minecraft/InGameHud;method_1753(Lnet/minecraft/DrawContext;Lnet/minecraft/RenderTickCounter;)V`
- `renderChat` → `Lnet/minecraft/InGameHud;method_55802(Lnet/minecraft/DrawContext;Lnet/minecraft/RenderTickCounter;)V`
- `renderCrosshair` → `Lnet/minecraft/InGameHud;method_1736(Lnet/minecraft/DrawContext;Lnet/minecraft/RenderTickCounter;)V`
- `renderExperienceLevel` → `Lnet/minecraft/InGameHud;method_56136(Lnet/minecraft/DrawContext;Lnet/minecraft/RenderTickCounter;)V`
- `renderHotbar` → `Lnet/minecraft/InGameHud;method_1759(Lnet/minecraft/DrawContext;Lnet/minecraft/RenderTickCounter;)V`
- `renderMainHud` → `Lnet/minecraft/InGameHud;method_55805(Lnet/minecraft/DrawContext;Lnet/minecraft/RenderTickCounter;)V`
- `renderNauseaOverlay` → `Lnet/minecraft/InGameHud;method_61980(Lnet/minecraft/DrawContext;F)V`
- `renderOverlayMessage` → `Lnet/minecraft/InGameHud;method_55800(Lnet/minecraft/DrawContext;Lnet/minecraft/RenderTickCounter;)V`
- `renderPlayerList` → `Lnet/minecraft/InGameHud;method_55804(Lnet/minecraft/DrawContext;Lnet/minecraft/RenderTickCounter;)V`
- `renderPortalOverlay` → `Lnet/minecraft/InGameHud;method_1746(Lnet/minecraft/DrawContext;F)V`
- `renderScoreboardSidebar` → `method_55803(Lnet/minecraft/DrawContext;Lnet/minecraft/RenderTickCounter;)V`
- `renderScoreboardSidebar(Lnet/minecraft/client/gui/DrawContext;Lnet/minecraft/client/render/RenderTickCounter;)V` → `Lnet/minecraft/InGameHud;method_55803(Lnet/minecraft/DrawContext;Lnet/minecraft/RenderTickCounter;)V`
- `renderScoreboardSidebar(Lnet/minecraft/client/gui/DrawContext;Lnet/minecraft/scoreboard/ScoreboardObjective;)V` → `Lnet/minecraft/InGameHud;method_1757(Lnet/minecraft/DrawContext;Lnet/minecraft/ScoreboardObjective;)V`
- `renderSpyglassOverlay` → `Lnet/minecraft/InGameHud;method_32598(Lnet/minecraft/DrawContext;F)V`
- `renderStatusEffectOverlay` → `Lnet/minecraft/InGameHud;method_1765(Lnet/minecraft/DrawContext;Lnet/minecraft/RenderTickCounter;)V`
- `renderTitleAndSubtitle` → `Lnet/minecraft/InGameHud;method_55801(Lnet/minecraft/DrawContext;Lnet/minecraft/RenderTickCounter;)V`
- `renderVignetteOverlay` → `Lnet/minecraft/InGameHud;method_1735(Lnet/minecraft/DrawContext;Lnet/minecraft/Entity;)V`

### `CLASSESS/M/mCm`
- `profile` → `field_3741:Lcom/mojang/authlib/GameProfile;`

### `CLASSESS/M/oHvpd`
- `Lnet/minecraft/client/input/Input;tick()V` → `Lnet/minecraft/Input;method_3129()V`
- `closeHandledScreen` → `Lnet/minecraft/ClientPlayerEntity;method_7346()V`
- `tick` → `Lnet/minecraft/ClientPlayerEntity;method_5773()V`
- `tickMovement` → `Lnet/minecraft/ClientPlayerEntity;method_6007()V`

### `CLASSESS/M/oq`
- `getHandSwingDuration` → `Lnet/minecraft/LivingEntity;method_6028()I`
- `jump` → `Lnet/minecraft/LivingEntity;method_6043()V`

### `CLASSESS/M/pA`
- `renderLabelIfPresent` → `Lnet/minecraft/PlayerEntityRenderer;method_4213(Lnet/minecraft/PlayerEntityRenderState;Lnet/minecraft/Text;Lnet/minecraft/MatrixStack;Lnet/minecraft/VertexConsumerProvider;I)V`

### `CLASSESS/M/pXrkwq`
- `renderClouds` → `Lnet/minecraft/CloudRenderer;method_62168(ILnet/minecraft/CloudRenderMode;FLorg/joml/Matrix4f;Lorg/joml/Matrix4f;Lnet/minecraft/Vec3d;F)V`

### `CLASSESS/M/qMcD`
- `connect(Lnet/minecraft/client/network/ServerInfo;)V` → `Lnet/minecraft/MultiplayerScreen;method_2548(Lnet/minecraft/ServerInfo;)V`

### `CLASSESS/M/qe`
- `Lnet/minecraft/client/render/GameRenderer;renderHand:Z` → `Lnet/minecraft/GameRenderer;field_3992:Z`
- `getBasicProjectionMatrix` → `Lnet/minecraft/GameRenderer;method_22973(F)Lorg/joml/Matrix4f;`
- `getFov` → `Lnet/minecraft/GameRenderer;method_3196(Lnet/minecraft/Camera;FZ)F`
- `renderWorld` → `Lnet/minecraft/GameRenderer;method_3188(Lnet/minecraft/RenderTickCounter;)V`
- `tiltViewWhenHurt` → `Lnet/minecraft/GameRenderer;method_3198(Lnet/minecraft/MatrixStack;F)V`

### `CLASSESS/M/qo`
- `addParticle(Lnet/minecraft/particle/ParticleEffect;DDDDDD)Lnet/minecraft/client/particle/Particle;` → `Lnet/minecraft/ParticleManager;method_3056(Lnet/minecraft/ParticleEffect;DDDDDD)Lnet/minecraft/Particle;`
- `tick` → `Lnet/minecraft/ParticleManager;method_3057()V`

### `CLASSESS/M/rF`
- `Lnet/minecraft/text/TextVisitFactory;visitFormatted(Ljava/lang/String;ILnet/minecraft/text/Style;Lnet/minecraft/text/Style;Lnet/minecraft/text/CharacterVisitor;)Z` → `Lnet/minecraft/TextVisitFactory;method_27473(Ljava/lang/String;ILnet/minecraft/Style;Lnet/minecraft/Style;Lnet/minecraft/CharacterVisitor;)Z`
- `visitFormatted(Ljava/lang/String;ILnet/minecraft/text/Style;Lnet/minecraft/text/CharacterVisitor;)Z` → `Lnet/minecraft/TextVisitFactory;method_27472(Ljava/lang/String;ILnet/minecraft/Style;Lnet/minecraft/CharacterVisitor;)Z`

### `CLASSESS/M/rq`
- `attackEntity` → `Lnet/minecraft/ClientPlayerInteractionManager;method_2918(Lnet/minecraft/PlayerEntity;Lnet/minecraft/Entity;)V`
- `clickSlot` → `Lnet/minecraft/ClientPlayerInteractionManager;method_2906(IIILnet/minecraft/SlotActionType;Lnet/minecraft/PlayerEntity;)V`

### `CLASSESS/M/tTeuAC`
- `Lnet/minecraft/client/option/SimpleOption;getValue()Ljava/lang/Object;` → `Lnet/minecraft/SimpleOption;method_41753()Ljava/lang/Object;`
- `update` → `Lnet/minecraft/LightmapTextureManager;method_3313(F)V`
- `update(F)V` → `Lnet/minecraft/LightmapTextureManager;method_3313(F)V`

### `CLASSESS/M/vP`
- `removeScoreHolderFromTeam` → `Lnet/minecraft/Scoreboard;method_1157(Ljava/lang/String;Lnet/minecraft/Team;)V`

### `CLASSESS/M/vg`
- `Lnet/minecraft/client/network/ClientPlayerEntity;changeLookDirection(DD)V` → `Lnet/minecraft/ClientPlayerEntity;method_5872(DD)V`
- `Lnet/minecraft/client/network/ClientPlayerEntity;getInventory()Lnet/minecraft/entity/player/PlayerInventory;` → `Lnet/minecraft/ClientPlayerEntity;method_31548()Lnet/minecraft/PlayerInventory;`
- `onMouseButton` → `Lnet/minecraft/Mouse;method_1601(JIII)V`
- `onMouseScroll` → `Lnet/minecraft/Mouse;method_1598(JDD)V`
- `updateMouse` → `Lnet/minecraft/Mouse;method_1606(D)V`

### `CLASSESS/M/wnSRjH`
- `Lnet/minecraft/client/gui/DrawContext;fill(IIIII)V` → `Lnet/minecraft/DrawContext;method_25294(IIIII)V`
- `Lnet/minecraft/client/gui/DrawContext;fill(IIIIII)V` → `Lnet/minecraft/DrawContext;method_51737(IIIIII)V`
- `addMessage(Lnet/minecraft/text/Text;)V` → `Lnet/minecraft/ChatHud;method_1812(Lnet/minecraft/Text;)V`
- `addMessage(Lnet/minecraft/text/Text;Lnet/minecraft/network/message/MessageSignatureData;Lnet/minecraft/client/gui/hud/MessageIndicator;)V` → `Lnet/minecraft/ChatHud;method_44811(Lnet/minecraft/Text;Lnet/minecraft/MessageSignatureData;Lnet/minecraft/MessageIndicator;)V`
- `render(Lnet/minecraft/client/gui/DrawContext;IIIZ)V` → `Lnet/minecraft/ChatHud;method_1805(Lnet/minecraft/DrawContext;IIIZ)V`

### `CLASSESS/M/wxkbm`
- `setTimeOfDay` → `Lnet/minecraft/ClientWorld$Properties;method_165(J)V`

### `CLASSESS/M/yE`
- `getBoundKeyLocalizedText` → `Lnet/minecraft/KeyBinding;method_16007()Lnet/minecraft/Text;`

### `CLASSESS/M/zJgmx`
- `base` → `field_52899:Lnet/minecraft/ModelPart;`
- `cube` → `field_52902:Lnet/minecraft/ModelPart;`
- `innerGlass` → `field_52901:Lnet/minecraft/ModelPart;`
- `outerGlass` → `field_52900:Lnet/minecraft/ModelPart;`

### `CLASSESS/SO`
- `renderWidget` → `Lnet/minecraft/PressableWidget;method_48579(Lnet/minecraft/DrawContext;IIF)V`

### `CLASSESS/fNgJWV`
- `getHeight` → `Lnet/minecraft/OrderedTextTooltipComponent;method_32661(Lnet/minecraft/TextRenderer;)I`

### `CLASSESS/oKX`
- `renderWidget` → `Lnet/minecraft/TextFieldWidget;method_48579(Lnet/minecraft/DrawContext;IIF)V`

### `CLASSESS/sX`
- `draw(Ljava/lang/String;FFIZLorg/joml/Matrix4f;Lnet/minecraft/client/render/VertexConsumerProvider;Lnet/minecraft/client/font/TextRenderer$TextLayerType;II)I` → `Lnet/minecraft/TextRenderer;method_27521(Ljava/lang/String;FFIZLorg/joml/Matrix4f;Lnet/minecraft/VertexConsumerProvider;Lnet/minecraft/TextRenderer$TextLayerType;II)I`
- `draw(Lnet/minecraft/text/OrderedText;FFIZLorg/joml/Matrix4f;Lnet/minecraft/client/render/VertexConsumerProvider;Lnet/minecraft/client/font/TextRenderer$TextLayerType;II)I` → `Lnet/minecraft/TextRenderer;method_22942(Lnet/minecraft/OrderedText;FFIZLorg/joml/Matrix4f;Lnet/minecraft/VertexConsumerProvider;Lnet/minecraft/TextRenderer$TextLayerType;II)I`
- `draw(Lnet/minecraft/text/Text;FFIZLorg/joml/Matrix4f;Lnet/minecraft/client/render/VertexConsumerProvider;Lnet/minecraft/client/font/TextRenderer$TextLayerType;II)I` → `Lnet/minecraft/TextRenderer;method_27522(Lnet/minecraft/Text;FFIZLorg/joml/Matrix4f;Lnet/minecraft/VertexConsumerProvider;Lnet/minecraft/TextRenderer$TextLayerType;II)I`
- `draw(Lnet/minecraft/text/Text;FFIZLorg/joml/Matrix4f;Lnet/minecraft/client/render/VertexConsumerProvider;Lnet/minecraft/client/font/TextRenderer$TextLayerType;IIZ)I` → `Lnet/minecraft/TextRenderer;method_30882(Lnet/minecraft/Text;FFIZLorg/joml/Matrix4f;Lnet/minecraft/VertexConsumerProvider;Lnet/minecraft/TextRenderer$TextLayerType;IIZ)I`
- `getWidth(Ljava/lang/String;)I` → `Lnet/minecraft/TextRenderer;method_1727(Ljava/lang/String;)I`
- `getWidth(Lnet/minecraft/text/OrderedText;)I` → `Lnet/minecraft/TextRenderer;method_30880(Lnet/minecraft/OrderedText;)I`
- `getWidth(Lnet/minecraft/text/StringVisitable;)I` → `Lnet/minecraft/TextRenderer;method_27525(Lnet/minecraft/StringVisitable;)I`

## Client mixin class names (obfuscated)

`CNFw`, `jEn`, `wnSRjH`, `CJYYzN`, `al`, `oHvpd`, `rq`, `Jt`, `lMyZFo`, `wxkbm`, `pXrkwq`, `jdMZO`, `Kz`, `UWzDe`, `qe`, `I`, `HuWVq`, `llQpvq`, `WeuFmN`, `jC`, `yE`, `Pd`, `tTeuAC`, `QCYBan`, `vg`, `qMcD`, `iZtxSe`, `pA`, `qo`, `YHhBPN`, `hjmKN`, `kOLGsi`, `UMZytA`, `La`, `zJgmx`, `mCm`
