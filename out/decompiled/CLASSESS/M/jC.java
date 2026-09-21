/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_310
 *  net.minecraft.class_442
 *  net.minecraft.class_9919
 *  org.spongepowered.asm.mixin.Mixin
 *  org.spongepowered.asm.mixin.injection.At
 *  org.spongepowered.asm.mixin.injection.Inject
 *  org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable
 */
package CLASSESS.M;

import CLASSESS.Mr;
import net.minecraft.class_310;
import net.minecraft.class_442;
import net.minecraft.class_9919;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(value={class_9919.class})
public abstract class jC {
    @Inject(method={"update"}, at={@At(value="HEAD")}, cancellable=true)
    private void Hq(CallbackInfoReturnable<Integer> callbackInfoReturnable) {
        class_310 class_3102 = class_310.method_1551();
        if ((class_3102.field_1755 instanceof class_442 || class_3102.field_1755 instanceof Mr) && !class_3102.method_22683().method_61946()) {
            callbackInfoReturnable.setReturnValue((Object)((Integer)class_3102.field_1690.method_42524().method_41753()));
        }
    }
}
