/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.mojang.blaze3d.systems.RenderSystem
 *  net.minecraft.Window
 *  net.minecraft.Entity
 *  net.minecraft.ScoreboardObjective
 *  net.minecraft.Scoreboard
 *  net.minecraft.MinecraftClient
 *  net.minecraft.InGameHud
 *  net.minecraft.DrawContext
 *  net.minecraft.ChatHud
 *  net.minecraft.MathHelper
 *  net.minecraft.PlayerListHud
 *  net.minecraft.ScoreboardDisplaySlot
 *  net.minecraft.RenderTickCounter
 *  org.spongepowered.asm.mixin.Final
 *  org.spongepowered.asm.mixin.Mixin
 *  org.spongepowered.asm.mixin.Shadow
 *  org.spongepowered.asm.mixin.Unique
 *  org.spongepowered.asm.mixin.gen.Invoker
 *  org.spongepowered.asm.mixin.injection.At
 *  org.spongepowered.asm.mixin.injection.Inject
 *  org.spongepowered.asm.mixin.injection.Redirect
 *  org.spongepowered.asm.mixin.injection.callback.CallbackInfo
 */
package CLASSESS.M;

import CLASSESS.EDCde;
import CLASSESS.LAx;
import CLASSESS.NS;
import CLASSESS.QHMTVh;
import CLASSESS.SyBEH;
import CLASSESS.TUagLH;
import CLASSESS.TpNfP;
import CLASSESS.Up;
import CLASSESS.VL;
import CLASSESS.Yj;
import CLASSESS.f;
import CLASSESS.feG;
import CLASSESS.lnURa;
import CLASSESS.lw;
import CLASSESS.rNWiQ;
import CLASSESS.rV;
import CLASSESS.vHkhb;
import com.mojang.blaze3d.systems.RenderSystem;
import java.lang.invoke.MethodHandles;
import java.util.ConcurrentModificationException;
import java.util.List;
import net.minecraft.Window;
import net.minecraft.Entity;
import net.minecraft.ScoreboardObjective;
import net.minecraft.Scoreboard;
import net.minecraft.MinecraftClient;
import net.minecraft.InGameHud;
import net.minecraft.DrawContext;
import net.minecraft.ChatHud;
import net.minecraft.MathHelper;
import net.minecraft.PlayerListHud;
import net.minecraft.ScoreboardDisplaySlot;
import net.minecraft.RenderTickCounter;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.gen.Invoker;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.Redirect;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

/*
 * Uses jvm11+ dynamic constants - pseudocode provided - see https://www.benf.org/other/cfr/dynamic-constants.html
 */
@Mixin(value={InGameHud.class})
public abstract class llQpvq
implements lnURa {
    @Final
    @Shadow
    private MinecraftClient field_2035;
    @Unique
    private float displayedHealth = (float)( /* dynamic constant */ (Object)feG.Rz("nV", MethodHandles.lookup(), "Rz", llQpvq.class, -1675298657, -615921110, -1072276245, 31));
    @Unique
    private float displayedArmor = (float)( /* dynamic constant */ (Object)feG.Rz("sO", MethodHandles.lookup(), "Rz", llQpvq.class, 1281253710, -338601411, -2110514107, 30));
    @Unique
    private float displayedFood = (float)( /* dynamic constant */ (Object)feG.Rz("nV", MethodHandles.lookup(), "Rz", llQpvq.class, -1675298657, -615921110, -1072276245, 31));
    @Unique
    private float displayedAir = (float)( /* dynamic constant */ (Object)feG.Rz("HY", MethodHandles.lookup(), "Rz", llQpvq.class, -2047541218, 681258958, 2040269739, 19));
    @Unique
    private float displayedAbsorption = (float)( /* dynamic constant */ (Object)feG.Rz("sO", MethodHandles.lookup(), "Rz", llQpvq.class, 1281253710, -338601411, -2110514107, 30));
    @Unique
    private Yj void$gridDrag;
    @Unique
    private float void$gridAlpha;
    @Unique
    private long void$gridFrameNanos = System.nanoTime();
    @Unique
    private boolean void$deferredChat;
    @Unique
    private boolean void$deferredScoreboard;
    @Unique
    private boolean void$deferredPlayerList;
    @Unique
    private boolean void$replayingVanillaHud;
    @Unique
    private boolean void$scoreboardGlassActive;
    @Unique
    private boolean void$scoreboardBodyCaptured;
    @Unique
    private int void$scoreboardBodyX1;
    @Unique
    private int void$scoreboardBodyY1;
    @Unique
    private int void$scoreboardBodyX2;
    @Unique
    private int void$scoreboardBodyY2;
    @Unique
    private int void$scoreboardBodyColor;

    @Shadow
    protected abstract void method_1760(DrawContext var1);

    @Shadow
    protected abstract void method_1741(DrawContext var1);

    @Invoker
    protected abstract void invokeRenderScoreboardSidebar(DrawContext var1, RenderTickCounter var2);

    @Inject(method={"render"}, at={@At(value="HEAD")})
    private void void$captureGlassBackdrop(DrawContext class_3322, RenderTickCounter class_97792, CallbackInfo callbackInfo) {
        this.void$deferredChat =  /* dynamic constant */ (Object)feG.ZQ("LydWrT", MethodHandles.lookup(), "ZQ", llQpvq.class, 352285113, -2082119208, -31911520, 12);
        this.void$deferredScoreboard =  /* dynamic constant */ (Object)feG.ZQ("LydWrT", MethodHandles.lookup(), "ZQ", llQpvq.class, 352285113, -2082119208, -31911520, 12);
        this.void$deferredPlayerList =  /* dynamic constant */ (Object)feG.ZQ("LydWrT", MethodHandles.lookup(), "ZQ", llQpvq.class, 352285113, -2082119208, -31911520, 12);
        lw.CCx();
        if (lw.HpIR()) {
            try {
                class_3322.method_51452();
                lw.widYH();
            }
            catch (Throwable throwable) {
                // empty catch block
            }
        }
    }

    @Inject(method={"renderCrosshair"}, at={@At(value="HEAD")}, cancellable=true)
    private void lPXYw(DrawContext class_3322, RenderTickCounter class_97792, CallbackInfo callbackInfo) {
        if (TUagLH.tIFgxB()) {
            callbackInfo.cancel();
        }
    }

    @Inject(method={"renderHotbar"}, at={@At(value="HEAD")}, cancellable=true)
    private void tLRO(DrawContext class_3322, RenderTickCounter class_97792, CallbackInfo callbackInfo) {
        if (TUagLH.tIFgxB()) {
            callbackInfo.cancel();
        }
    }

    /*
     * WARNING - void declaration
     */
    @Inject(method={"render"}, at={@At(value="RETURN")})
    public void onRender(DrawContext class_3322, RenderTickCounter class_97792, CallbackInfo callbackInfo) {
        void var14_23;
        void l;
        List<Yj> list;
        blur.setup();
        NS nS2 = new NS(class_3322, drawEngine, class_97792.method_60637((boolean)( /* dynamic constant */ (Object)feG.ZQ("LydWrT", MethodHandles.lookup(), "ZQ", llQpvq.class, 352285113, -2082119208, -31911520, 12))));
        Up.vh((SyBEH)((Object)nS2));
        rNWiQ.render(class_3322);
        f.gC(class_3322);
        if (this.field_2035.field_1690.field_1842) {
            this.void$renderDeferredVanillaHud(class_3322, class_97792);
            return;
        }
        TpNfP.render(class_3322);
        try {
            list = LAx.Gh().getDraggableRepository().draggable();
        }
        catch (Throwable throwable) {
            this.void$renderDeferredVanillaHud(class_3322, class_97792);
            return;
        }
        if (list == null || list.isEmpty()) {
            this.void$renderDeferredVanillaHud(class_3322, class_97792);
            return;
        }
        List<Yj> list2 = TUagLH.tIFgxB() ? list.stream().filter(llQpvq::lambda$onRender$0).toList() : list;
        Yj yj = null;
        Object object =  /* dynamic constant */ (Object)feG.ZQ("LydWrT", MethodHandles.lookup(), "ZQ", llQpvq.class, 352285113, -2082119208, -31911520, 12);
        int n = list2.size();
        while (l < n) {
            Yj object2 = list2.get((int)l);
            try {
                if (object2.canDraw(object2) && object2.isDragging()) {
                    yj = object2;
                    break;
                }
            }
            catch (Throwable object22) {
                // empty catch block
            }
            l += ( /* dynamic constant */ (Object)feG.ZQ("IhR", MethodHandles.lookup(), "ZQ", llQpvq.class, -1206820069, -1078725207, 1555961690, 10));
        }
        long l2 = System.nanoTime();
        Object object3 = Math.min((float)( /* dynamic constant */ (Object)feG.ZQ("rIvOr", MethodHandles.lookup(), "ZQ", llQpvq.class, -1293473608, 12042996, 1986935441, 4)), Math.max((float)( /* dynamic constant */ (Object)feG.ZQ("IDY", MethodHandles.lookup(), "ZQ", llQpvq.class, -684106003, 1734677759, -147330524, 9)), (float)(l2 - this.void$gridFrameNanos) / ( /* dynamic constant */ (Object)feG.ZQ("Ab", MethodHandles.lookup(), "ZQ", llQpvq.class, 781384486, -126601935, -1776976644, 30))));
        this.void$gridFrameNanos = l2;
        if (yj != null) {
            if (this.void$gridDrag == null) {
                object3 =  /* dynamic constant */ (Object)feG.ZQ("IDY", MethodHandles.lookup(), "ZQ", llQpvq.class, -684106003, 1734677759, -147330524, 9);
            }
            this.void$gridDrag = yj;
        }
        Object object4 = yj == null ? ( /* dynamic constant */ (Object)feG.ZQ("IDY", MethodHandles.lookup(), "ZQ", llQpvq.class, -684106003, 1734677759, -147330524, 9)) : ( /* dynamic constant */ (Object)feG.ZQ("PnkoR", MethodHandles.lookup(), "ZQ", llQpvq.class, -1992816930, -718842757, 79760166, 4));
        Object object5 = object4 > this.void$gridAlpha ? ( /* dynamic constant */ (Object)feG.ZQ("Hq", MethodHandles.lookup(), "ZQ", llQpvq.class, 448789066, -115484039, -1077342960, 13)) : ( /* dynamic constant */ (Object)feG.ZQ("uqdJP", MethodHandles.lookup(), "ZQ", llQpvq.class, 526744183, -126482887, 1577285562, 9));
        reference var13_18 = ( /* dynamic constant */ (Object)feG.ZQ("PnkoR", MethodHandles.lookup(), "ZQ", llQpvq.class, -1992816930, -718842757, 79760166, 4)) - (float)Math.exp((double)(-object5 * object3));
        this.void$gridAlpha += (object4 - this.void$gridAlpha) * var13_18;
        if (this.void$gridDrag != null && this.void$gridAlpha > ( /* dynamic constant */ (Object)feG.ZQ("cmPXs", MethodHandles.lookup(), "ZQ", llQpvq.class, 1573388065, 1583525920, -898160875, 28))) {
            Yj throwable = this.void$gridDrag;
            Yj.Jl((DrawContext)class_3322, (int)this.field_2035.method_22683().method_4486(), (int)this.field_2035.method_22683().method_4502(), (int)throwable.getX(), (int)throwable.getY(), (int)throwable.getWidth(), (int)throwable.getHeight(), (float)this.void$gridAlpha);
        } else if (yj == null) {
            this.void$gridAlpha = (float)( /* dynamic constant */ (Object)feG.ZQ("IDY", MethodHandles.lookup(), "ZQ", llQpvq.class, -684106003, 1734677759, -147330524, 9));
            this.void$gridDrag = null;
        }
        try {
            lw.ZAubV(class_3322, list2);
        }
        catch (Throwable throwable) {
            // empty catch block
        }
        Object object6 =  /* dynamic constant */ (Object)feG.ZQ("LydWrT", MethodHandles.lookup(), "ZQ", llQpvq.class, 352285113, -2082119208, -31911520, 12);
        int n2 = list2.size();
        while (var14_23 < n2) {
            block29: {
                Yj yj2 = list2.get((int)var14_23);
                try {
                    yj2.applyPendingLayout();
                    yj2.handleWindowResize();
                }
                catch (Throwable throwable) {
                    // empty catch block
                }
                try {
                    if (yj2.canDraw(yj2)) {
                        yj2.startAnimation();
                    } else {
                        yj2.stopAnimation();
                    }
                    float f2 = yj2.getScaleAnimation().getOutput().floatValue();
                    if (f2 <= ( /* dynamic constant */ (Object)feG.ZQ("cmPXs", MethodHandles.lookup(), "ZQ", llQpvq.class, 1573388065, 1583525920, -898160875, 28))) break block29;
                    yj2.validPosition();
                    float f3 = yj2.getScale();
                    float f4 = f2 * yj2.getOpacity();
                    try {
                        RenderSystem.setShaderColor((float)( /* dynamic constant */ (Object)feG.ZQ("PnkoR", MethodHandles.lookup(), "ZQ", llQpvq.class, -1992816930, -718842757, 79760166, 4)), (float)( /* dynamic constant */ (Object)feG.ZQ("PnkoR", MethodHandles.lookup(), "ZQ", llQpvq.class, -1992816930, -718842757, 79760166, 4)), (float)( /* dynamic constant */ (Object)feG.ZQ("PnkoR", MethodHandles.lookup(), "ZQ", llQpvq.class, -1992816930, -718842757, 79760166, 4)), (float)( /* dynamic constant */ (Object)feG.ZQ("PnkoR", MethodHandles.lookup(), "ZQ", llQpvq.class, -1992816930, -718842757, 79760166, 4)));
                    }
                    catch (Throwable throwable) {
                        // empty catch block
                    }
                    if (f3 != ( /* dynamic constant */ (Object)feG.ZQ("PnkoR", MethodHandles.lookup(), "ZQ", llQpvq.class, -1992816930, -718842757, 79760166, 4))) {
                        float f5 = (float)yj2.getX() + (float)yj2.getWidth() / ( /* dynamic constant */ (Object)feG.ZQ("BwU", MethodHandles.lookup(), "ZQ", llQpvq.class, -1084188585, 1351534217, -1848521106, 24));
                        float f6 = (float)yj2.getY() + (float)yj2.getHeight() / ( /* dynamic constant */ (Object)feG.ZQ("BwU", MethodHandles.lookup(), "ZQ", llQpvq.class, -1084188585, 1351534217, -1848521106, 24));
                        class_3322.method_51448().method_22903();
                        class_3322.method_51448().method_46416(f5, f6, (float)( /* dynamic constant */ (Object)feG.ZQ("IDY", MethodHandles.lookup(), "ZQ", llQpvq.class, -684106003, 1734677759, -147330524, 9)));
                        class_3322.method_51448().method_22905(f3, f3, (float)( /* dynamic constant */ (Object)feG.ZQ("PnkoR", MethodHandles.lookup(), "ZQ", llQpvq.class, -1992816930, -718842757, 79760166, 4)));
                        class_3322.method_51448().method_46416(-f5, -f6, (float)( /* dynamic constant */ (Object)feG.ZQ("IDY", MethodHandles.lookup(), "ZQ", llQpvq.class, -684106003, 1734677759, -147330524, 9)));
                        EDCde.RQ(f4, () -> llQpvq.lambda$onRender$1(yj2, class_3322));
                        class_3322.method_51448().method_22909();
                    } else {
                        EDCde.RQ(f4, () -> llQpvq.lambda$onRender$2(yj2, class_3322));
                    }
                    try {
                        RenderSystem.setShaderColor((float)( /* dynamic constant */ (Object)feG.ZQ("PnkoR", MethodHandles.lookup(), "ZQ", llQpvq.class, -1992816930, -718842757, 79760166, 4)), (float)( /* dynamic constant */ (Object)feG.ZQ("PnkoR", MethodHandles.lookup(), "ZQ", llQpvq.class, -1992816930, -718842757, 79760166, 4)), (float)( /* dynamic constant */ (Object)feG.ZQ("PnkoR", MethodHandles.lookup(), "ZQ", llQpvq.class, -1992816930, -718842757, 79760166, 4)), (float)( /* dynamic constant */ (Object)feG.ZQ("PnkoR", MethodHandles.lookup(), "ZQ", llQpvq.class, -1992816930, -718842757, 79760166, 4)));
                    }
                    catch (Throwable throwable) {}
                }
                catch (ConcurrentModificationException concurrentModificationException) {
                }
                catch (Throwable throwable) {
                    // empty catch block
                }
            }
            var14_23 += ( /* dynamic constant */ (Object)feG.ZQ("IhR", MethodHandles.lookup(), "ZQ", llQpvq.class, -1206820069, -1078725207, 1555961690, 10));
        }
        this.void$renderDeferredVanillaHud(class_3322, class_97792);
    }

    @Inject(method={"renderChat"}, at={@At(value="HEAD")}, cancellable=true)
    private void gV(DrawContext class_3322, RenderTickCounter class_97792, CallbackInfo callbackInfo) {
        if (this.void$replayingVanillaHud) {
            return;
        }
        this.void$deferredChat = true;
        callbackInfo.cancel();
    }

    @Inject(method={"renderPlayerList"}, at={@At(value="HEAD")}, cancellable=true)
    private void MW(DrawContext class_3322, RenderTickCounter class_97792, CallbackInfo callbackInfo) {
        if (this.void$replayingVanillaHud) {
            return;
        }
        this.void$deferredPlayerList = true;
        callbackInfo.cancel();
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Unique
    private void void$renderDeferredVanillaHud(DrawContext class_3322, RenderTickCounter class_97792) {
        if (this.void$replayingVanillaHud) {
            return;
        }
        this.void$replayingVanillaHud =  /* dynamic constant */ (Object)feG.ZQ("IhR", MethodHandles.lookup(), "ZQ", llQpvq.class, -1206820069, -1078725207, 1555961690, 10);
        try {
            if (this.void$deferredScoreboard) {
                this.invokeRenderScoreboardSidebar(class_3322, class_97792);
            }
        }
        catch (Throwable throwable) {
            // empty catch block
        }
        try {
            if (this.void$deferredChat) {
                this.void$renderChatDirect(class_3322);
            }
        }
        catch (Throwable throwable) {
            // empty catch block
        }
        try {
            if (this.void$deferredPlayerList) {
                this.void$renderPlayerListDirect(class_3322);
            }
        }
        catch (Throwable throwable) {
        }
        finally {
            this.void$replayingVanillaHud =  /* dynamic constant */ (Object)feG.ZQ("LydWrT", MethodHandles.lookup(), "ZQ", llQpvq.class, 352285113, -2082119208, -31911520, 12);
            this.void$deferredChat =  /* dynamic constant */ (Object)feG.ZQ("LydWrT", MethodHandles.lookup(), "ZQ", llQpvq.class, 352285113, -2082119208, -31911520, 12);
            this.void$deferredScoreboard =  /* dynamic constant */ (Object)feG.ZQ("LydWrT", MethodHandles.lookup(), "ZQ", llQpvq.class, 352285113, -2082119208, -31911520, 12);
            this.void$deferredPlayerList =  /* dynamic constant */ (Object)feG.ZQ("LydWrT", MethodHandles.lookup(), "ZQ", llQpvq.class, 352285113, -2082119208, -31911520, 12);
        }
    }

    @Unique
    private void void$renderChatDirect(DrawContext class_3322) {
        ChatHud class_3382 = this.field_2035.field_1705.method_1743();
        if (class_3382 == null || class_3382.method_1819()) {
            return;
        }
        Window PackageInfo10412 = this.field_2035.method_22683();
        int n = MathHelper.method_15357((double)(this.field_2035.field_1729.method_1603() * (double)PackageInfo10412.method_4486() / (double)PackageInfo10412.method_4480()));
        int n2 = MathHelper.method_15357((double)(this.field_2035.field_1729.method_1604() * (double)PackageInfo10412.method_4502() / (double)PackageInfo10412.method_4507()));
        class_3382.method_1805(class_3322, this.field_2035.field_1705.method_1738(), n, n2, (boolean)( /* dynamic constant */ (Object)feG.ZQ("LydWrT", MethodHandles.lookup(), "ZQ", llQpvq.class, 352285113, -2082119208, -31911520, 12)));
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Unique
    private void void$renderPlayerListDirect(DrawContext class_3322) {
        if (this.field_2035.field_1687 == null || this.field_2035.field_1724 == null) {
            return;
        }
        Scoreboard VehicleMoveS2CPacket = this.field_2035.field_1687.method_8428();
        ScoreboardObjective class_2662 = VehicleMoveS2CPacket.method_1189(ScoreboardDisplaySlot.field_45156);
        PlayerListHud ChunkBlockLightProvider = this.field_2035.field_1705.method_1750();
        Object object = this.field_2035.field_1690.field_1907.method_1434() && (!this.field_2035.method_1542() || this.field_2035.field_1724.field_3944.method_45732().size() > ( /* dynamic constant */ (Object)feG.ZQ("IhR", MethodHandles.lookup(), "ZQ", llQpvq.class, -1206820069, -1078725207, 1555961690, 10)) || class_2662 != null) ? ( /* dynamic constant */ (Object)feG.ZQ("IhR", MethodHandles.lookup(), "ZQ", llQpvq.class, -1206820069, -1078725207, 1555961690, 10)) : ( /* dynamic constant */ (Object)feG.ZQ("LydWrT", MethodHandles.lookup(), "ZQ", llQpvq.class, 352285113, -2082119208, -31911520, 12));
        ChunkBlockLightProvider.method_1921((boolean)object);
        if (object == false) {
            return;
        }
        try {
            class_3322.method_51452();
        }
        catch (Throwable throwable) {
            // empty catch block
        }
        class_3322.method_51448().method_22903();
        class_3322.method_51448().method_46416((float)( /* dynamic constant */ (Object)feG.ZQ("IDY", MethodHandles.lookup(), "ZQ", llQpvq.class, -684106003, 1734677759, -147330524, 9)), (float)( /* dynamic constant */ (Object)feG.ZQ("IDY", MethodHandles.lookup(), "ZQ", llQpvq.class, -684106003, 1734677759, -147330524, 9)), (float)( /* dynamic constant */ (Object)feG.ZQ("WaNyE", MethodHandles.lookup(), "ZQ", llQpvq.class, 707147630, -1989463183, -2096797650, 18)));
        try {
            ChunkBlockLightProvider.method_1919(class_3322, class_3322.method_51421(), VehicleMoveS2CPacket, class_2662);
            try {
                class_3322.method_51452();
            }
            catch (Throwable throwable) {
                // empty catch block
            }
        }
        finally {
            class_3322.method_51448().method_22909();
        }
    }

    @Inject(method={"renderOverlayMessage"}, at={@At(value="HEAD")}, cancellable=true)
    private void renderOverlayMessage(DrawContext class_3322, RenderTickCounter class_97792, CallbackInfo callbackInfo) {
    }

    @Inject(method={"renderExperienceLevel"}, at={@At(value="HEAD")}, cancellable=true)
    private void renderExperienceLevel(DrawContext class_3322, RenderTickCounter class_97792, CallbackInfo callbackInfo) {
    }

    @Inject(method={"renderMainHud"}, at={@At(value="HEAD")}, cancellable=true)
    private void renderMainHud(DrawContext class_3322, RenderTickCounter class_97792, CallbackInfo callbackInfo) {
    }

    @Inject(method={"renderVignetteOverlay"}, at={@At(value="HEAD")}, cancellable=true)
    private void fbLI(DrawContext class_3322, Entity class_12972, CallbackInfo callbackInfo) {
        if (llQpvq.void$noRender((String)( /* dynamic constant */ (Object)feG.fL("dYq", MethodHandles.lookup(), "fL", llQpvq.class, "\u00b53\u00f6\u00a6b\n\u00c1\u0089", -456922098, 1054392290, 1425681050, 2)))) {
            callbackInfo.cancel();
        }
    }

    @Inject(method={"renderPortalOverlay"}, at={@At(value="HEAD")}, cancellable=true)
    private void uyNcLL(DrawContext class_3322, float f2, CallbackInfo callbackInfo) {
        if (llQpvq.void$noRender((String)( /* dynamic constant */ (Object)feG.fL("oDchaU", MethodHandles.lookup(), "fL", llQpvq.class, "\u0089\u000f\u00d9\u0086\\(", -665072468, 2026590154, 1266785737, 2)))) {
            callbackInfo.cancel();
        }
    }

    @Inject(method={"renderNauseaOverlay"}, at={@At(value="HEAD")}, cancellable=true)
    private void gI(DrawContext class_3322, float f2, CallbackInfo callbackInfo) {
        if (llQpvq.void$noRender((String)( /* dynamic constant */ (Object)feG.fL("ImDKH", MethodHandles.lookup(), "fL", llQpvq.class, "\u0016\u00cc-\u00dd\u00bc\u008e", 42514701, -1347096423, 1610357580, 1)))) {
            callbackInfo.cancel();
        }
    }

    @Inject(method={"renderSpyglassOverlay"}, at={@At(value="HEAD")}, cancellable=true)
    private void bd(DrawContext class_3322, float f2, CallbackInfo callbackInfo) {
        if (llQpvq.void$noRender((String)( /* dynamic constant */ (Object)feG.fL("pxcBm", MethodHandles.lookup(), "fL", llQpvq.class, "H\u00d2\u0010W\u0093\u00e7>g", 378313335, 1451999544, -992287904, 2)))) {
            callbackInfo.cancel();
        }
    }

    @Inject(method={"renderTitleAndSubtitle"}, at={@At(value="HEAD")}, cancellable=true)
    private void ng(DrawContext class_3322, RenderTickCounter class_97792, CallbackInfo callbackInfo) {
        if (llQpvq.void$noRender((String)( /* dynamic constant */ (Object)feG.fL("CDnml", MethodHandles.lookup(), "fL", llQpvq.class, "\u000f\u008b]\u001c\u00da", 1498664156, 175108823, 547056656, 2)))) {
            callbackInfo.cancel();
        }
    }

    @Inject(method={"renderScoreboardSidebar(Lnet/minecraft/client/gui/DrawContext;Lnet/minecraft/client/render/RenderTickCounter;)V"}, at={@At(value="HEAD")}, cancellable=true)
    private void NY(DrawContext class_3322, RenderTickCounter class_97792, CallbackInfo callbackInfo) {
        if (llQpvq.void$noRender((String)( /* dynamic constant */ (Object)feG.fL("GiYcN", MethodHandles.lookup(), "fL", llQpvq.class, "s\u00fa=y\u00a1\u00df\u0019N\u009a\u00c5", 696157573, -492850504, -698341492, 2)))) {
            callbackInfo.cancel();
            return;
        }
        if (!this.void$replayingVanillaHud) {
            this.void$deferredScoreboard = true;
            callbackInfo.cancel();
        }
    }

    @Inject(method={"renderScoreboardSidebar(Lnet/minecraft/client/gui/DrawContext;Lnet/minecraft/scoreboard/ScoreboardObjective;)V"}, at={@At(value="HEAD")}, cancellable=true)
    private void Bf(DrawContext class_3322, ScoreboardObjective class_2662, CallbackInfo callbackInfo) {
        VL vL = VL.Mps();
        this.void$scoreboardGlassActive = vL != null && vL.isEnabled() && (vL.isLiquidGlassEnabled() || vL.isMergeEnabled()) && vL.appliesTo((String)( /* dynamic constant */ (Object)feG.fL("Ag", MethodHandles.lookup(), "fL", llQpvq.class, ".\u00dc\u000e\u00c0\u00be\u0012T@\u00e7\u00ab", -938265133, 986465188, 108016309, 1)));
        this.void$scoreboardBodyCaptured = false;
        if (llQpvq.void$noRender((String)( /* dynamic constant */ (Object)feG.fL("LL", MethodHandles.lookup(), "fL", llQpvq.class, "\u0097\u0080mS%=\u0011\u00fc\u00ce\u00bf", -401473846, 2120819977, -1861056335, 0)))) {
            callbackInfo.cancel();
        }
    }

    @Redirect(method={"renderScoreboardSidebar(Lnet/minecraft/client/gui/DrawContext;Lnet/minecraft/scoreboard/ScoreboardObjective;)V"}, at=@At(value="INVOKE", target="Lnet/minecraft/client/gui/DrawContext;fill(IIIII)V", ordinal=0))
    private void void$captureScoreboardBody(DrawContext class_3322, int n, int n2, int n3, int n4, int n5) {
        if (!this.void$scoreboardGlassActive) {
            class_3322.method_25294(n, n2, n3, n4, n5);
            return;
        }
        this.void$scoreboardBodyCaptured =  /* dynamic constant */ (Object)feG.ZQ("IhR", MethodHandles.lookup(), "ZQ", llQpvq.class, -1206820069, -1078725207, 1555961690, 10);
        this.void$scoreboardBodyX1 = n;
        this.void$scoreboardBodyY1 = n2;
        this.void$scoreboardBodyX2 = n3;
        this.void$scoreboardBodyY2 = n4;
        this.void$scoreboardBodyColor = n5;
    }

    @Redirect(method={"renderScoreboardSidebar(Lnet/minecraft/client/gui/DrawContext;Lnet/minecraft/scoreboard/ScoreboardObjective;)V"}, at=@At(value="INVOKE", target="Lnet/minecraft/client/gui/DrawContext;fill(IIIII)V", ordinal=1))
    private void void$renderScoreboardGlass(DrawContext class_3322, int n, int n2, int n3, int n4, int n5) {
        if (!this.void$scoreboardGlassActive || !this.void$scoreboardBodyCaptured) {
            class_3322.method_25294(n, n2, n3, n4, n5);
            return;
        }
        int n6 = Math.min(this.void$scoreboardBodyX1, n);
        int n7 = Math.min(this.void$scoreboardBodyY1, n2);
        int n8 = Math.max(this.void$scoreboardBodyX2, n3);
        int n9 = Math.max(this.void$scoreboardBodyY2, n4);
        lw.SL((String)( /* dynamic constant */ (Object)feG.fL("rNrLr", MethodHandles.lookup(), "fL", llQpvq.class, "\u00f70\u00c4\u00a5\u000b\u00d8\u008f\u0095\f\u00a0", -1727119189, 1999089139, -1585593425, 1)), class_3322.method_51448(), n6, n7, n8 - n6, n9 - n7, (float)( /* dynamic constant */ (Object)feG.ZQ("PnkoR", MethodHandles.lookup(), "ZQ", llQpvq.class, -1992816930, -718842757, 79760166, 4)));
        boolean bl = lw.vKAtz((String)( /* dynamic constant */ (Object)feG.fL("Xk", MethodHandles.lookup(), "fL", llQpvq.class, "\f\u001d\u00f2\u00ce\u00be\u0098vY%\u0012", 1890522659, 833633297, -1657023417, 0)), class_3322.method_51448(), n6, n7, n8 - n6, n9 - n7, (float)( /* dynamic constant */ (Object)feG.ZQ("kQIgt", MethodHandles.lookup(), "ZQ", llQpvq.class, -523121469, 368402047, 787948133, 25)), (float)( /* dynamic constant */ (Object)feG.ZQ("PnkoR", MethodHandles.lookup(), "ZQ", llQpvq.class, -1992816930, -718842757, 79760166, 4)));
        if (!bl) {
            class_3322.method_25294(this.void$scoreboardBodyX1, this.void$scoreboardBodyY1, this.void$scoreboardBodyX2, this.void$scoreboardBodyY2, this.void$scoreboardBodyColor);
            class_3322.method_25294(n, n2, n3, n4, n5);
        }
    }

    @Inject(method={"renderStatusEffectOverlay"}, at={@At(value="HEAD")}, cancellable=true)
    private void JgGXEs(DrawContext class_3322, RenderTickCounter class_97792, CallbackInfo callbackInfo) {
        if (llQpvq.void$noRender((String)( /* dynamic constant */ (Object)feG.fL("ju", MethodHandles.lookup(), "fL", llQpvq.class, "S\u00c9\u0002X\u0091\u00ff3", 664173905, -2007256590, -197950138, 2)))) {
            callbackInfo.cancel();
        }
    }

    @Unique
    private static boolean void$noRender(String string) {
        try {
            QHMTVh qHMTVh = QHMTVh.rrLUn();
            return (boolean)(qHMTVh != null && qHMTVh.shouldHide(string) ? ( /* dynamic constant */ (Object)feG.ZQ("IhR", MethodHandles.lookup(), "ZQ", llQpvq.class, -1206820069, -1078725207, 1555961690, 10)) : ( /* dynamic constant */ (Object)feG.ZQ("LydWrT", MethodHandles.lookup(), "ZQ", llQpvq.class, 352285113, -2082119208, -31911520, 12)));
        }
        catch (Throwable throwable) {
            return (boolean)( /* dynamic constant */ (Object)feG.ZQ("LydWrT", MethodHandles.lookup(), "ZQ", llQpvq.class, 352285113, -2082119208, -31911520, 12));
        }
    }

    @Unique
    private void renderCustomStatusBars(DrawContext class_3322) {
    }

    private static void lambda$onRender$2(Yj yj, DrawContext class_3322) {
        yj.drawDraggable(class_3322);
    }

    private static void lambda$onRender$1(Yj yj, DrawContext class_3322) {
        yj.drawDraggable(class_3322);
    }

    private static boolean lambda$onRender$0(Yj yj) {
        return (boolean)(yj instanceof vHkhb || yj instanceof rV ? ( /* dynamic constant */ (Object)feG.ZQ("IhR", MethodHandles.lookup(), "ZQ", llQpvq.class, -1206820069, -1078725207, 1555961690, 10)) : ( /* dynamic constant */ (Object)feG.ZQ("LydWrT", MethodHandles.lookup(), "ZQ", llQpvq.class, 352285113, -2082119208, -31911520, 12)));
    }
}
