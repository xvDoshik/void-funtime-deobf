/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_2561
 *  net.minecraft.class_304
 *  net.minecraft.class_3675$class_306
 *  org.spongepowered.asm.mixin.Mixin
 *  org.spongepowered.asm.mixin.Shadow
 *  org.spongepowered.asm.mixin.injection.At
 *  org.spongepowered.asm.mixin.injection.Inject
 *  org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable
 */
package CLASSESS.M;

import net.minecraft.class_2561;
import net.minecraft.class_304;
import net.minecraft.class_3675;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(value={class_304.class})
public class yE {
    @Shadow
    private class_3675.class_306 field_1655;

    @Inject(method={"getBoundKeyLocalizedText"}, at={@At(value="HEAD")}, cancellable=true)
    private void onGetBoundKeyLocalizedText(CallbackInfoReturnable<class_2561> callbackInfoReturnable) {
        callbackInfoReturnable.setReturnValue((Object)this.field_1655.method_27445());
    }
}
