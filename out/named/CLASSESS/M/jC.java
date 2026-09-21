/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.MinecraftClient
 *  net.minecraft.TitleScreen
 *  net.minecraft.InactivityFpsLimiter
 *  org.spongepowered.asm.mixin.Mixin
 *  org.spongepowered.asm.mixin.injection.At
 *  org.spongepowered.asm.mixin.injection.Inject
 *  org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable
 */
package CLASSESS.M;

import CLASSESS.Mr;
import net.minecraft.MinecraftClient;
import net.minecraft.TitleScreen;
import net.minecraft.InactivityFpsLimiter;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(value={InactivityFpsLimiter.class})
public abstract class jC {
    @Inject(method={"update"}, at={@At(value="HEAD")}, cancellable=true)
    private void Hq(CallbackInfoReturnable<Integer> callbackInfoReturnable) {
        MinecraftClient class_3102 = MinecraftClient.method_1551();
        if ((class_3102.field_1755 instanceof TitleScreen || class_3102.field_1755 instanceof Mr) && !class_3102.method_22683().method_61946()) {
            callbackInfoReturnable.setReturnValue((Object)((Integer)class_3102.field_1690.method_42524().method_41753()));
        }
    }
}
