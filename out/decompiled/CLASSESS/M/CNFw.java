/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_1294
 *  net.minecraft.class_1297
 *  net.minecraft.class_1309
 *  net.minecraft.class_4184
 *  net.minecraft.class_5636
 *  net.minecraft.class_638
 *  net.minecraft.class_6854
 *  net.minecraft.class_758
 *  net.minecraft.class_758$class_4596
 *  net.minecraft.class_9958
 *  org.joml.Vector4f
 *  org.spongepowered.asm.mixin.Mixin
 *  org.spongepowered.asm.mixin.Unique
 *  org.spongepowered.asm.mixin.injection.At
 *  org.spongepowered.asm.mixin.injection.Inject
 *  org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable
 */
package CLASSESS.M;

import CLASSESS.SyBEH;
import CLASSESS.Up;
import CLASSESS.feG;
import CLASSESS.sV;
import CLASSESS.uShSb;
import java.lang.invoke.MethodHandles;
import net.minecraft.class_1294;
import net.minecraft.class_1297;
import net.minecraft.class_1309;
import net.minecraft.class_4184;
import net.minecraft.class_5636;
import net.minecraft.class_638;
import net.minecraft.class_6854;
import net.minecraft.class_758;
import net.minecraft.class_9958;
import org.joml.Vector4f;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

/*
 * Uses jvm11+ dynamic constants - pseudocode provided - see https://www.benf.org/other/cfr/dynamic-constants.html
 */
@Mixin(value={class_758.class})
public class CNFw {
    @Unique
    private static boolean HuZipb(class_4184 class_41842, class_758.class_4596 class_45962) {
        if (class_45962 != class_758.class_4596.field_20946) {
            return true;
        }
        class_5636 class_56362 = class_41842.method_19334();
        if (class_56362 != class_5636.field_27888) {
            return true;
        }
        class_1297 class_12972 = class_41842.method_19331();
        if (class_12972 instanceof class_1309) {
            class_1309 class_13092 = (class_1309)class_12972;
            if (class_13092.method_6059(class_1294.field_5919)) {
                return true;
            }
            return class_13092.method_6059(class_1294.field_38092);
        }
        return false;
    }

    @Inject(method={"getFogColor"}, at={@At(value="HEAD")}, cancellable=true)
    private static void nnWonv(class_4184 class_41842, float f, class_638 class_6382, int n, float f2, CallbackInfoReturnable<Vector4f> callbackInfoReturnable) {
        if (CNFw.HuZipb(class_41842, class_758.class_4596.field_20946)) {
            return;
        }
        sV sV2 = new sV();
        Up.vh((SyBEH)((Object)sV2));
        if (sV2.isCancelled()) {
            int n2 = sV2.getColor();
            callbackInfoReturnable.setReturnValue((Object)new Vector4f(uShSb.rm(n2), uShSb.fwUgZ(n2), uShSb.xq(n2), uShSb.DF(n2)));
        }
    }

    @Inject(method={"applyFog"}, at={@At(value="HEAD")}, cancellable=true)
    private static void CLqB(class_4184 class_41842, class_758.class_4596 class_45962, Vector4f vector4f, float f, boolean bl, float f2, CallbackInfoReturnable<class_9958> callbackInfoReturnable) {
        if (CNFw.HuZipb(class_41842, class_45962)) {
            return;
        }
        sV sV2 = new sV();
        Up.vh((SyBEH)((Object)sV2));
        if (sV2.isCancelled()) {
            int n = sV2.getColor();
            callbackInfoReturnable.setReturnValue((Object)new class_9958((float)( /* dynamic constant */ (Object)feG.Rz("Ui", MethodHandles.lookup(), "Rz", CNFw.class, -133684637, 134399828, 1792573312, 21)), sV2.getDistance(), class_6854.field_36351, uShSb.rm(n), uShSb.fwUgZ(n), uShSb.xq(n), uShSb.DF(n)));
        }
    }
}
