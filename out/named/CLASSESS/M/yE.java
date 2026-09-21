/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.Text
 *  net.minecraft.KeyBinding
 *  net.minecraft.InputUtil$class_306
 *  org.spongepowered.asm.mixin.Mixin
 *  org.spongepowered.asm.mixin.Shadow
 *  org.spongepowered.asm.mixin.injection.At
 *  org.spongepowered.asm.mixin.injection.Inject
 *  org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable
 */
package CLASSESS.M;

import net.minecraft.Text;
import net.minecraft.KeyBinding;
import net.minecraft.InputUtil;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(value={KeyBinding.class})
public class yE {
    @Shadow
    private InputUtil.class_306 field_1655;

    @Inject(method={"getBoundKeyLocalizedText"}, at={@At(value="HEAD")}, cancellable=true)
    private void onGetBoundKeyLocalizedText(CallbackInfoReturnable<Text> callbackInfoReturnable) {
        callbackInfoReturnable.setReturnValue((Object)this.field_1655.method_27445());
    }
}
