/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_1297
 *  net.minecraft.class_1657
 *  net.minecraft.class_4587
 *  net.minecraft.class_4597
 *  net.minecraft.class_4604
 *  net.minecraft.class_898
 *  org.spongepowered.asm.mixin.Mixin
 *  org.spongepowered.asm.mixin.injection.At
 *  org.spongepowered.asm.mixin.injection.Inject
 *  org.spongepowered.asm.mixin.injection.callback.CallbackInfo
 *  org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable
 */
package CLASSESS.M;

import CLASSESS.QtySoD;
import CLASSESS.TUagLH;
import CLASSESS.feG;
import java.lang.invoke.MethodHandles;
import net.minecraft.class_1297;
import net.minecraft.class_1657;
import net.minecraft.class_4587;
import net.minecraft.class_4597;
import net.minecraft.class_4604;
import net.minecraft.class_898;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

/*
 * Uses jvm11+ dynamic constants - pseudocode provided - see https://www.benf.org/other/cfr/dynamic-constants.html
 */
@Mixin(value={class_898.class})
public class Kz {
    @Inject(method={"shouldRender"}, at={@At(value="HEAD")}, cancellable=true)
    private void void$targetFocusShouldRender(class_1297 class_12972, class_4604 class_46042, double d, double d2, double d3, CallbackInfoReturnable<Boolean> callbackInfoReturnable) {
        class_1657 class_16572;
        if (class_12972 instanceof class_1657 && Kz.void$shouldHide(class_16572 = (class_1657)class_12972)) {
            callbackInfoReturnable.setReturnValue((Object)((boolean)( /* dynamic constant */ (Object)feG.ZQ("hoH", MethodHandles.lookup(), "ZQ", Kz.class, -1642180653, 126102048, -442070676, 2))));
        }
    }

    @Inject(method={"render(Lnet/minecraft/entity/Entity;DDDFLnet/minecraft/client/util/math/MatrixStack;Lnet/minecraft/client/render/VertexConsumerProvider;I)V"}, at={@At(value="HEAD")}, cancellable=true)
    private void void$targetFocusRender(class_1297 class_12972, double d, double d2, double d3, float f, class_4587 class_45872, class_4597 class_45972, int n, CallbackInfo callbackInfo) {
        class_1657 class_16572;
        if (class_12972 instanceof class_1657 && Kz.void$shouldHide(class_16572 = (class_1657)class_12972)) {
            callbackInfo.cancel();
        }
    }

    private static boolean void$shouldHide(class_1657 class_16572) {
        try {
            QtySoD qtySoD = QtySoD.ZwVTUs();
            if (qtySoD != null && qtySoD.shouldHidePlayer(class_16572)) {
                return (boolean)( /* dynamic constant */ (Object)feG.ZQ("Qhc", MethodHandles.lookup(), "ZQ", Kz.class, 260864751, -1493417573, 544385232, 23));
            }
            TUagLH tUagLH = TUagLH.WXxUT();
            return (boolean)(tUagLH != null && tUagLH.shouldHideTarget(class_16572) ? ( /* dynamic constant */ (Object)feG.ZQ("Qhc", MethodHandles.lookup(), "ZQ", Kz.class, 260864751, -1493417573, 544385232, 23)) : ( /* dynamic constant */ (Object)feG.ZQ("hoH", MethodHandles.lookup(), "ZQ", Kz.class, -1642180653, 126102048, -442070676, 2)));
        }
        catch (Throwable throwable) {
            return (boolean)( /* dynamic constant */ (Object)feG.ZQ("hoH", MethodHandles.lookup(), "ZQ", Kz.class, -1642180653, 126102048, -442070676, 2));
        }
    }
}
