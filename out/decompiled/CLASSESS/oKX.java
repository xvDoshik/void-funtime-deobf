/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_2561
 *  net.minecraft.class_310
 *  net.minecraft.class_332
 *  net.minecraft.class_339
 *  net.minecraft.class_342
 *  org.spongepowered.asm.mixin.Mixin
 *  org.spongepowered.asm.mixin.Shadow
 *  org.spongepowered.asm.mixin.Unique
 *  org.spongepowered.asm.mixin.injection.At
 *  org.spongepowered.asm.mixin.injection.Inject
 *  org.spongepowered.asm.mixin.injection.callback.CallbackInfo
 */
package CLASSESS;

import CLASSESS.GYaDdW;
import CLASSESS.Xb;
import CLASSESS.ehdu;
import CLASSESS.feG;
import CLASSESS.nZcHI;
import CLASSESS.uShSb;
import CLASSESS.upGW;
import java.lang.invoke.MethodHandles;
import net.minecraft.class_2561;
import net.minecraft.class_310;
import net.minecraft.class_332;
import net.minecraft.class_339;
import net.minecraft.class_342;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

/*
 * Uses jvm11+ dynamic constants - pseudocode provided - see https://www.benf.org/other/cfr/dynamic-constants.html
 */
@Mixin(value={class_342.class})
public abstract class oKX
extends class_339 {
    @Unique
    private static final nZcHI VD$FONT = Xb.qa(14, upGW.DEFAULT);
    @Shadow
    private int field_2101;
    @Shadow
    private boolean field_2094;
    @Shadow
    private String field_2106;
    @Shadow
    private class_2561 field_41100;
    @Unique
    private float vd$focus;
    @Unique
    private long vd$lastFrame;
    @Unique
    private String vd$lastText = "";
    @Unique
    private float vd$typePulse;

    protected oKX(int n, int n2, int n3, int n4, class_2561 class_25612) {
        super(n, n2, n3, n4, class_25612);
    }

    @Shadow
    public abstract String method_1882();

    @Shadow
    public abstract int method_1881();

    /*
     * WARNING - void declaration
     */
    @Inject(method={"renderWidget"}, at={@At(value="HEAD")}, cancellable=true)
    private void vd$renderTextField(class_332 class_3322, int n, int n2, float f, CallbackInfo callbackInfo) {
        int n3;
        int n4;
        int f11;
        int string3;
        int n5;
        void var21_21;
        class_310 class_3102 = class_310.method_1551();
        if (class_3102.field_1755 == null || class_3102.field_1755.getClass().getName().startsWith((String)( /* dynamic constant */ (Object)feG.fL("GmRyg", MethodHandles.lookup(), "fL", oKX.class, "\u001a\u00f3\u009b\u00b2\u009cy^\"\u0006\u00a0\u00db\u00a8\u00c5", -1856781481, -569946144, 639229549, 0)))) {
            return;
        }
        long l = System.nanoTime();
        Object object = this.vd$lastFrame == ( /* dynamic constant */ (Object)feG.TR("wm", MethodHandles.lookup(), "TR", oKX.class, -470418143351588580L, 9118847077744742240L, -8116187180278123209L, 3)) ? ( /* dynamic constant */ (Object)feG.ZQ("FxJTgv", MethodHandles.lookup(), "ZQ", oKX.class, -960231817, -623265328, -911287428, 25)) : (Object)Math.min((float)( /* dynamic constant */ (Object)feG.ZQ("KEJQD", MethodHandles.lookup(), "ZQ", oKX.class, -1252885464, 981193736, 603547333, 2)), Math.max((float)( /* dynamic constant */ (Object)feG.ZQ("ZHG", MethodHandles.lookup(), "ZQ", oKX.class, -1537609864, 901714082, -869243207, 13)), (float)(l - this.vd$lastFrame) / ( /* dynamic constant */ (Object)feG.ZQ("vIleJ", MethodHandles.lookup(), "ZQ", oKX.class, 1483634320, -420884242, 70536240, 20))));
        this.vd$lastFrame = l;
        Object object2 = this.method_25370() ? ( /* dynamic constant */ (Object)feG.ZQ("Qx", MethodHandles.lookup(), "ZQ", oKX.class, -1122989898, -353398801, 662324255, 11)) : (this.field_22762 ? ( /* dynamic constant */ (Object)feG.ZQ("kAsxcf", MethodHandles.lookup(), "ZQ", oKX.class, 283920240, -833679876, 1273568711, 22)) : ( /* dynamic constant */ (Object)feG.ZQ("gRO", MethodHandles.lookup(), "ZQ", oKX.class, -147727191, -126958587, 826932614, 15)));
        this.vd$focus += (object2 - this.vd$focus) * (( /* dynamic constant */ (Object)feG.ZQ("Qx", MethodHandles.lookup(), "ZQ", oKX.class, -1122989898, -353398801, 662324255, 11)) - (float)Math.exp((double)(( /* dynamic constant */ (Object)feG.ZQ("UbVVF", MethodHandles.lookup(), "ZQ", oKX.class, -2057871823, 141862652, 2146524058, 1)) * object)));
        float f2 = (float)this.method_46426() + ( /* dynamic constant */ (Object)feG.ZQ("QRggBt", MethodHandles.lookup(), "ZQ", oKX.class, 260703537, -1968122097, -433184124, 24));
        float f3 = (float)this.method_46427() + ( /* dynamic constant */ (Object)feG.ZQ("QRggBt", MethodHandles.lookup(), "ZQ", oKX.class, 260703537, -1968122097, -433184124, 24));
        float f4 = Math.max((float)( /* dynamic constant */ (Object)feG.ZQ("Qx", MethodHandles.lookup(), "ZQ", oKX.class, -1122989898, -353398801, 662324255, 11)), (float)this.method_25368() - ( /* dynamic constant */ (Object)feG.ZQ("Qx", MethodHandles.lookup(), "ZQ", oKX.class, -1122989898, -353398801, 662324255, 11)));
        float f5 = Math.max((float)( /* dynamic constant */ (Object)feG.ZQ("Qx", MethodHandles.lookup(), "ZQ", oKX.class, -1122989898, -353398801, 662324255, 11)), (float)this.method_25364() - ( /* dynamic constant */ (Object)feG.ZQ("Qx", MethodHandles.lookup(), "ZQ", oKX.class, -1122989898, -353398801, 662324255, 11)));
        float f6 = Math.max((float)( /* dynamic constant */ (Object)feG.ZQ("gRO", MethodHandles.lookup(), "ZQ", oKX.class, -147727191, -126958587, 826932614, 15)), Math.min((float)( /* dynamic constant */ (Object)feG.ZQ("Qx", MethodHandles.lookup(), "ZQ", oKX.class, -1122989898, -353398801, 662324255, 11)), ((float)n - f2) / Math.max((float)( /* dynamic constant */ (Object)feG.ZQ("Qx", MethodHandles.lookup(), "ZQ", oKX.class, -1122989898, -353398801, 662324255, 11)), f4)));
        float f7 = Math.max((float)( /* dynamic constant */ (Object)feG.ZQ("gRO", MethodHandles.lookup(), "ZQ", oKX.class, -147727191, -126958587, 826932614, 15)), Math.min((float)( /* dynamic constant */ (Object)feG.ZQ("Qx", MethodHandles.lookup(), "ZQ", oKX.class, -1122989898, -353398801, 662324255, 11)), ((float)n2 - f3) / Math.max((float)( /* dynamic constant */ (Object)feG.ZQ("Qx", MethodHandles.lookup(), "ZQ", oKX.class, -1122989898, -353398801, 662324255, 11)), f5)));
        GYaDdW.nJ(class_3322.method_51448(), f2, f3, f4, f5, Math.min((float)( /* dynamic constant */ (Object)feG.ZQ("Gpb", MethodHandles.lookup(), "ZQ", oKX.class, -2003960031, 1351534006, -1523785732, 14)), f5 * ( /* dynamic constant */ (Object)feG.ZQ("HG", MethodHandles.lookup(), "ZQ", oKX.class, 1767601823, 939527650, -464647176, 18))), this.vd$focus, (float)(this.field_22762 ? (Object)this.vd$focus : ( /* dynamic constant */ (Object)feG.ZQ("gRO", MethodHandles.lookup(), "ZQ", oKX.class, -147727191, -126958587, 826932614, 15))), f6, f7, this.field_22763 ? this.field_22765 : this.field_22765 * ( /* dynamic constant */ (Object)feG.ZQ("kAsxcf", MethodHandles.lookup(), "ZQ", oKX.class, 283920240, -833679876, 1273568711, 22)));
        Object object3 =  /* dynamic constant */ (Object)feG.ZQ("LmkAe", MethodHandles.lookup(), "ZQ", oKX.class, 290317535, 303428336, -58982454, 18);
        float f8 = Math.max((float)( /* dynamic constant */ (Object)feG.ZQ("Qx", MethodHandles.lookup(), "ZQ", oKX.class, -1122989898, -353398801, 662324255, 11)), f4 - (float)object3 * ( /* dynamic constant */ (Object)feG.ZQ("VrSNQ", MethodHandles.lookup(), "ZQ", oKX.class, 1792303639, 610337555, -1748954724, 18)));
        String string = this.method_1882();
        if (!string.equals(this.vd$lastText)) {
            this.vd$lastText = string;
            this.vd$typePulse = (float)( /* dynamic constant */ (Object)feG.ZQ("Qx", MethodHandles.lookup(), "ZQ", oKX.class, -1122989898, -353398801, 662324255, 11));
        } else {
            this.vd$typePulse = Math.max((float)( /* dynamic constant */ (Object)feG.ZQ("gRO", MethodHandles.lookup(), "ZQ", oKX.class, -147727191, -126958587, 826932614, 15)), this.vd$typePulse - object * ( /* dynamic constant */ (Object)feG.ZQ("tYs", MethodHandles.lookup(), "ZQ", oKX.class, 729113333, 1051331137, -195245224, 8)));
        }
        int n8 = Math.max((int)( /* dynamic constant */ (Object)feG.ZQ("iYsoq", MethodHandles.lookup(), "ZQ", oKX.class, 761237123, 476841946, -418557407, 23)), Math.min(string.length(), this.method_1881()));
        Object object4 =  /* dynamic constant */ (Object)feG.ZQ("iYsoq", MethodHandles.lookup(), "ZQ", oKX.class, 761237123, 476841946, -418557407, 23);
        while (var21_21 < n8 && VD$FONT.getStringWidth(string.substring((int)var21_21, n8)) > f8 - ( /* dynamic constant */ (Object)feG.ZQ("VrSNQ", MethodHandles.lookup(), "ZQ", oKX.class, 1792303639, 610337555, -1748954724, 18))) {
            var21_21 += ( /* dynamic constant */ (Object)feG.ZQ("fcE", MethodHandles.lookup(), "ZQ", oKX.class, -1572341953, 18053084, 1671509118, 8));
        }
        for (n5 = string.length(); n5 > n8 && VD$FONT.getStringWidth(string.substring((int)var21_21, n5)) > f8; n5 += ( /* dynamic constant */ (Object)feG.ZQ("WWl", MethodHandles.lookup(), "ZQ", oKX.class, 1404745891, 1329769724, 1492879348, 8))) {
        }
        String string2 = string.substring((int)var21_21, Math.max((int)var21_21, n5));
        float f9 = f2 + (float)object3;
        float f10 = ehdu.dbWHp(VD$FONT, string2, f3, f5);
        class_3322.method_44379(Math.round(f2 + ( /* dynamic constant */ (Object)feG.ZQ("VrSNQ", MethodHandles.lookup(), "ZQ", oKX.class, 1792303639, 610337555, -1748954724, 18))), Math.round(f3 + ( /* dynamic constant */ (Object)feG.ZQ("VrSNQ", MethodHandles.lookup(), "ZQ", oKX.class, 1792303639, 610337555, -1748954724, 18))), Math.round(f2 + f4 - ( /* dynamic constant */ (Object)feG.ZQ("VrSNQ", MethodHandles.lookup(), "ZQ", oKX.class, 1792303639, 610337555, -1748954724, 18))), Math.round(f3 + f5 - ( /* dynamic constant */ (Object)feG.ZQ("VrSNQ", MethodHandles.lookup(), "ZQ", oKX.class, 1792303639, 610337555, -1748954724, 18))));
        int n6 = Math.max((int)var21_21, Math.min(n5, this.field_2101));
        int n7 = Math.max((int)var21_21, Math.min(n5, n8));
        if (n6 != n7) {
            string3 = Math.min(n6, n7);
            f11 = Math.max(n6, n7);
            n4 = Math.round(f9 + VD$FONT.getStringWidth(string.substring((int)var21_21, string3)));
            n3 = Math.round(f9 + VD$FONT.getStringWidth(string.substring((int)var21_21, f11)));
            class_3322.method_25294(n4, Math.round(f3 + ( /* dynamic constant */ (Object)feG.ZQ("sajMT", MethodHandles.lookup(), "ZQ", oKX.class, -1259926976, 1709252652, -1340169916, 28))), n3, Math.round(f3 + f5 - ( /* dynamic constant */ (Object)feG.ZQ("sajMT", MethodHandles.lookup(), "ZQ", oKX.class, -1259926976, 1709252652, -1340169916, 28))), uShSb.YGoKeb(uShSb.eCgpGw(), this.field_22765 * ( /* dynamic constant */ (Object)feG.ZQ("jLpYOu", MethodHandles.lookup(), "ZQ", oKX.class, 125058530, 1388390772, -1283948007, 11))));
        }
        if (string2.isEmpty() && !this.method_25370() && this.field_41100 != null) {
            String f12 = oKX.vd$fit(this.field_41100.getString(), f8);
            VD$FONT.drawStringWithWeight(class_3322.method_51448(), f12, f9, f10, uShSb.YGoKeb(uShSb.MBeEJ(), this.field_22765 * ( /* dynamic constant */ (Object)feG.ZQ("wUgQF", MethodHandles.lookup(), "ZQ", oKX.class, -889005994, 1739880966, 1868242866, 8))), (float)( /* dynamic constant */ (Object)feG.ZQ("poB", MethodHandles.lookup(), "ZQ", oKX.class, -2111130922, 1618947584, 1858173311, 25)));
        } else {
            string3 = uShSb.YGoKeb(this.field_2094 ? (this.vd$typePulse > ( /* dynamic constant */ (Object)feG.ZQ("yQWq", MethodHandles.lookup(), "ZQ", oKX.class, -1500900222, -1977179037, 98907956, 31)) ? ( /* dynamic constant */ (int)(int)feG.ZQ("LZo", MethodHandles.lookup(), "ZQ", oKX.class, 1838899898, 360595402, 2116410618, 28)) : uShSb.tpPlcX()) : uShSb.MBeEJ(), this.field_22765);
            VD$FONT.drawStringWithWeight(class_3322.method_51448(), string2, f9, f10, string3, (float)( /* dynamic constant */ (Object)feG.ZQ("poB", MethodHandles.lookup(), "ZQ", oKX.class, -2111130922, 1618947584, 1858173311, 25)));
            if (n5 == string.length() && this.field_2106 != null && !this.field_2106.isEmpty()) {
                float f12 = f9 + VD$FONT.getStringWidth(string2);
                VD$FONT.drawString(class_3322.method_51448(), this.field_2106, f12, f10, uShSb.YGoKeb(uShSb.MBeEJ(), this.field_22765 * ( /* dynamic constant */ (Object)feG.ZQ("KdF", MethodHandles.lookup(), "ZQ", oKX.class, -488547395, 1894109544, -1705901824, 12))));
            }
        }
        if (this.method_25370() && (this.vd$typePulse > ( /* dynamic constant */ (Object)feG.ZQ("xF", MethodHandles.lookup(), "ZQ", oKX.class, -1549752768, -1849937963, 527121372, 31)) || (System.currentTimeMillis() / ( /* dynamic constant */ (Object)feG.TR("iuYFyK", MethodHandles.lookup(), "TR", oKX.class, -6765671317830291838L, 3441223720576710431L, -4964212748229279423L, 13)) & ( /* dynamic constant */ (Object)feG.TR("Xofy", MethodHandles.lookup(), "TR", oKX.class, -5420378277487909315L, -8188842074954114543L, -8825703480682565616L, 11))) == ( /* dynamic constant */ (Object)feG.TR("wm", MethodHandles.lookup(), "TR", oKX.class, -470418143351588580L, 9118847077744742240L, -8116187180278123209L, 3)))) {
            float f13 = VD$FONT.getStringWidth(string.substring((int)var21_21, n7));
            f11 = Math.round(f9 + f13);
            n4 = Math.round(f3 + ( /* dynamic constant */ (Object)feG.ZQ("Gpb", MethodHandles.lookup(), "ZQ", oKX.class, -2003960031, 1351534006, -1523785732, 14)) - this.vd$typePulse);
            n3 = Math.round(f3 + f5 - ( /* dynamic constant */ (Object)feG.ZQ("Gpb", MethodHandles.lookup(), "ZQ", oKX.class, -2003960031, 1351534006, -1523785732, 14)) + this.vd$typePulse);
            class_3322.method_25294(f11, n4, f11 + ( /* dynamic constant */ (Object)feG.ZQ("fcE", MethodHandles.lookup(), "ZQ", oKX.class, -1572341953, 18053084, 1671509118, 8)), n3, uShSb.YGoKeb(uShSb.eCgpGw(), this.field_22765));
        }
        class_3322.method_44380();
        callbackInfo.cancel();
    }

    @Unique
    private static String vd$fit(String string, float f) {
        int n;
        if (VD$FONT.getStringWidth(string) <= f) {
            return string;
        }
        Object object =  /* dynamic constant */ (Object)feG.fL("EykZF", MethodHandles.lookup(), "fL", oKX.class, "0\u0013r", 231849977, -491138469, -861977358, 0);
        for (n = string.length(); n > 0 && VD$FONT.getStringWidth(string.substring((int)( /* dynamic constant */ (Object)feG.ZQ("iYsoq", MethodHandles.lookup(), "ZQ", oKX.class, 761237123, 476841946, -418557407, 23)), n) + (String)object) > f; n += ( /* dynamic constant */ (Object)feG.ZQ("WWl", MethodHandles.lookup(), "ZQ", oKX.class, 1404745891, 1329769724, 1492879348, 8))) {
        }
        return string.substring((int)( /* dynamic constant */ (Object)feG.ZQ("iYsoq", MethodHandles.lookup(), "ZQ", oKX.class, 761237123, 476841946, -418557407, 23)), n) + (String)object;
    }
}
