/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_10017
 *  net.minecraft.class_1297
 *  net.minecraft.class_1657
 *  net.minecraft.class_897
 *  org.spongepowered.asm.mixin.Mixin
 *  org.spongepowered.asm.mixin.injection.At
 *  org.spongepowered.asm.mixin.injection.Inject
 *  org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable
 */
package CLASSESS.M;

import CLASSESS.TUagLH;
import net.minecraft.class_10017;
import net.minecraft.class_1297;
import net.minecraft.class_1657;
import net.minecraft.class_897;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(value={class_897.class})
public abstract class UWzDe<S extends class_10017> {
    @Inject(method={"hasLabel"}, at={@At(value="HEAD")}, cancellable=true)
    private void cTY(class_1297 class_12972, double d, CallbackInfoReturnable<Boolean> callbackInfoReturnable) {
        TUagLH tUagLH = TUagLH.WXxUT();
        if (class_12972 instanceof class_1657) {
            class_1657 class_16572 = (class_1657)class_12972;
            if (tUagLH != null && tUagLH.shouldHideTarget(class_16572)) {
                callbackInfoReturnable.setReturnValue((Object)false);
            }
        }
    }
}
