/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.Text
 *  net.minecraft.ChatHudLine$class_7590
 *  net.minecraft.DrawContext
 *  net.minecraft.ChatHud
 *  net.minecraft.MessageSignatureData
 *  net.minecraft.MessageIndicator
 *  org.jetbrains.annotations.Nullable
 *  org.spongepowered.asm.mixin.Mixin
 *  org.spongepowered.asm.mixin.Shadow
 *  org.spongepowered.asm.mixin.Unique
 *  org.spongepowered.asm.mixin.injection.At
 *  org.spongepowered.asm.mixin.injection.Inject
 *  org.spongepowered.asm.mixin.injection.Redirect
 *  org.spongepowered.asm.mixin.injection.callback.CallbackInfo
 */
package CLASSESS.M;

import CLASSESS.SyBEH;
import CLASSESS.Up;
import CLASSESS.VL;
import CLASSESS.VyPtW;
import CLASSESS.XUwby;
import CLASSESS.feG;
import CLASSESS.lw;
import CLASSESS.o;
import java.lang.invoke.MethodHandles;
import java.util.List;
import net.minecraft.Text;
import net.minecraft.ChatHudLine;
import net.minecraft.DrawContext;
import net.minecraft.ChatHud;
import net.minecraft.MessageSignatureData;
import net.minecraft.MessageIndicator;
import org.jetbrains.annotations.Nullable;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.Redirect;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

/*
 * Uses jvm11+ dynamic constants - pseudocode provided - see https://www.benf.org/other/cfr/dynamic-constants.html
 */
@Mixin(value={ChatHud.class})
public abstract class wnSRjH {
    private static final long SAME_MESSAGE_WINDOW_NS = 50000000L;
    private static Text vd$lastMessage;
    private static long vd$lastMessageAt;
    private static boolean vd$lastMessageCancelled;
    @Shadow
    private List<ChatHudLine.class_7590> field_2064;
    @Shadow
    private int field_2066;
    @Unique
    private boolean vd$chatGlassActive;
    @Unique
    private boolean vd$chatGlassDrawn;
    @Unique
    private int vd$chatGlassLines;
    @Unique
    private float vd$chatGlassAlpha;

    @Shadow
    public abstract int method_1813();

    @Inject(method={"render(Lnet/minecraft/client/gui/DrawContext;IIIZ)V"}, at={@At(value="HEAD")})
    private void ZG(DrawContext class_3322, int n, int n2, int n3, boolean bl, CallbackInfo callbackInfo) {
        VL vL = VL.Mps();
        this.vd$chatGlassActive = vL != null && vL.isEnabled() && (vL.isLiquidGlassEnabled() || vL.isMergeEnabled()) && vL.appliesTo((String)( /* dynamic constant */ (Object)feG.fL("coWn", MethodHandles.lookup(), "fL", wnSRjH.class, "\b\u00ce\u00b5\u0098", -1755640432, 966283820, -334695112, 1)));
        this.vd$chatGlassDrawn = false;
        this.vd$chatGlassLines = 0;
        this.vd$chatGlassAlpha = (float)( /* dynamic constant */ (Object)feG.Rz("ij", MethodHandles.lookup(), "Rz", wnSRjH.class, -305596465, 1258189558, -854174682, 5));
        if (!this.vd$chatGlassActive || this.field_2064 == null || this.field_2064.isEmpty()) {
            return;
        }
        int n4 = Math.min(this.method_1813(), Math.max(0, this.field_2064.size() - this.field_2066));
        for (int i = 0; i < n4; ++i) {
            Object object;
            int n5;
            ChatHudLine.class_7590 class_75902 = this.field_2064.get(i + this.field_2066);
            if (class_75902 == null || (n5 = n - class_75902.comp_895()) >= 200 && !bl) continue;
            Object object2 = object = bl ? ( /* dynamic constant */ (Object)feG.Kl("ORA", MethodHandles.lookup(), "Kl", wnSRjH.class, 7302573523883542467L, 194358304797795576L, 7270265142431255830L, 5)) : (Object)wnSRjH.mDbFV(n5);
            if ((int)(( /* dynamic constant */ (Object)feG.Kl("KX", MethodHandles.lookup(), "Kl", wnSRjH.class, 5229096801281276857L, -8872067030076344890L, -4103575761157321753L, 63)) * object) <= 3) continue;
            this.vd$chatGlassLines = i + 1;
            this.vd$chatGlassAlpha = Math.max(this.vd$chatGlassAlpha, (float)object);
        }
        if (this.vd$chatGlassLines <= 0) {
            this.vd$chatGlassActive = false;
        }
    }

    @Redirect(method={"render(Lnet/minecraft/client/gui/DrawContext;IIIZ)V"}, at=@At(value="INVOKE", target="Lnet/minecraft/client/gui/DrawContext;fill(IIIII)V", ordinal=0))
    private void vd$renderChatGlass(DrawContext class_3322, int n, int n2, int n3, int n4, int n5) {
        if (!this.vd$chatGlassActive) {
            class_3322.method_25294(n, n2, n3, n4, n5);
            return;
        }
        if (!this.vd$chatGlassDrawn) {
            int n6 = Math.max((int)( /* dynamic constant */ (Object)feG.ZQ("SBes", MethodHandles.lookup(), "ZQ", wnSRjH.class, -1591265467, -78575264, -1129006396, 11)), n4 - n2);
            Object object =  /* dynamic constant */ (Object)feG.ZQ("Si", MethodHandles.lookup(), "ZQ", wnSRjH.class, -751796264, -1706555601, 656215830, 3);
            float f = n4 - this.vd$chatGlassLines * n6 - object;
            float f2 = n4 + object;
            lw.SL((String)( /* dynamic constant */ (Object)feG.fL("zQ", MethodHandles.lookup(), "fL", wnSRjH.class, "?\u00ado#", 1669285072, -933005323, -684864634, 2)), class_3322.method_51448(), n, f, n3 - n, f2 - f, this.vd$chatGlassAlpha);
            this.vd$chatGlassDrawn = lw.vKAtz((String)( /* dynamic constant */ (Object)feG.fL("oGRzF", MethodHandles.lookup(), "fL", wnSRjH.class, "\u0011\u0019\u00f1\u00db", 1954640883, -1012227048, 390011969, 0)), class_3322.method_51448(), n, f, n3 - n, f2 - f, (float)( /* dynamic constant */ (Object)feG.ZQ("tIFVa", MethodHandles.lookup(), "ZQ", wnSRjH.class, 908828945, -1076108020, -1151314076, 20)), this.vd$chatGlassAlpha);
            if (!this.vd$chatGlassDrawn) {
                this.vd$chatGlassActive =  /* dynamic constant */ (Object)feG.ZQ("tD", MethodHandles.lookup(), "ZQ", wnSRjH.class, 587240331, -933225026, 1786894133, 30);
                class_3322.method_25294(n, n2, n3, n4, n5);
            }
        }
    }

    @Redirect(method={"render(Lnet/minecraft/client/gui/DrawContext;IIIZ)V"}, at=@At(value="INVOKE", target="Lnet/minecraft/client/gui/DrawContext;fill(IIIII)V", ordinal=1))
    private void vd$hideChatIndicatorStrip(DrawContext class_3322, int n, int n2, int n3, int n4, int n5) {
        if (!this.vd$chatGlassActive) {
            class_3322.method_25294(n, n2, n3, n4, n5);
        }
    }

    @Redirect(method={"render(Lnet/minecraft/client/gui/DrawContext;IIIZ)V"}, at=@At(value="INVOKE", target="Lnet/minecraft/client/gui/DrawContext;fill(IIIIII)V"))
    private void vd$hideChatScrollbar(DrawContext class_3322, int n, int n2, int n3, int n4, int n5, int n6) {
        if (!this.vd$chatGlassActive) {
            class_3322.method_51737(n, n2, n3, n4, n5, n6);
        }
    }

    @Unique
    private static double mDbFV(int n) {
        Object object = ( /* dynamic constant */ (Object)feG.Kl("ORA", MethodHandles.lookup(), "Kl", wnSRjH.class, 7302573523883542467L, 194358304797795576L, 7270265142431255830L, 5)) - (double)n / ( /* dynamic constant */ (Object)feG.Kl("bmdF", MethodHandles.lookup(), "Kl", wnSRjH.class, -7649726985151447648L, 8462176760807132135L, 1635776129592132840L, 32));
        object = Math.max((double)( /* dynamic constant */ (Object)feG.Kl("dQcdLG", MethodHandles.lookup(), "Kl", wnSRjH.class, -1340377617681574786L, -7510276967948503942L, -9202701208944381598L, 33)), Math.min((double)( /* dynamic constant */ (Object)feG.Kl("ORA", MethodHandles.lookup(), "Kl", wnSRjH.class, 7302573523883542467L, 194358304797795576L, 7270265142431255830L, 5)), (double)(object * ( /* dynamic constant */ (Object)feG.Kl("zyww", MethodHandles.lookup(), "Kl", wnSRjH.class, -6378669016392177661L, -8305761981867989490L, 5183760791523696988L, 14)))));
        return (double)(object * object);
    }

    @Inject(method={"addMessage(Lnet/minecraft/text/Text;Lnet/minecraft/network/message/MessageSignatureData;Lnet/minecraft/client/gui/hud/MessageIndicator;)V"}, at={@At(value="HEAD")}, cancellable=true)
    private void zJc(Text class_25612, @Nullable MessageSignatureData class_74692, @Nullable MessageIndicator class_75912, CallbackInfo callbackInfo) {
        if (wnSRjH.szxBzk(class_25612)) {
            callbackInfo.cancel();
        }
    }

    @Inject(method={"addMessage(Lnet/minecraft/text/Text;)V"}, at={@At(value="HEAD")}, cancellable=true, require=0)
    private void lX(Text class_25612, CallbackInfo callbackInfo) {
        if (wnSRjH.szxBzk(class_25612)) {
            callbackInfo.cancel();
        }
    }

    private static synchronized boolean szxBzk(Text class_25612) {
        if (class_25612 == null) {
            return false;
        }
        long l = System.nanoTime();
        if (class_25612 == vd$lastMessage && l - vd$lastMessageAt <= 50000000L) {
            return vd$lastMessageCancelled;
        }
        try {
            o.XrEOSS(class_25612);
        }
        catch (Throwable throwable) {
            // empty catch block
        }
        try {
            VyPtW.PA(class_25612);
        }
        catch (Throwable throwable) {
            // empty catch block
        }
        XUwby xUwby = new XUwby(class_25612);
        Up.vh((SyBEH)((Object)xUwby));
        vd$lastMessage = class_25612;
        vd$lastMessageAt = System.nanoTime();
        vd$lastMessageCancelled = xUwby.isCancelled();
        return vd$lastMessageCancelled;
    }
}
