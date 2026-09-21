/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_243
 *  net.minecraft.class_4063
 *  net.minecraft.class_9955
 *  org.joml.Matrix4f
 *  org.spongepowered.asm.mixin.Mixin
 *  org.spongepowered.asm.mixin.injection.At
 *  org.spongepowered.asm.mixin.injection.Inject
 *  org.spongepowered.asm.mixin.injection.callback.CallbackInfo
 */
package CLASSESS.M;

import CLASSESS.Ki;
import net.minecraft.class_243;
import net.minecraft.class_4063;
import net.minecraft.class_9955;
import org.joml.Matrix4f;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(value={class_9955.class})
public abstract class pXrkwq {
    @Inject(method={"renderClouds"}, at={@At(value="HEAD")}, cancellable=true)
    private void Xd(int n, class_4063 class_40632, float f, Matrix4f matrix4f, Matrix4f matrix4f2, class_243 class_2432, float f2, CallbackInfo callbackInfo) {
        if (Ki.bA() && Ki.Xi()) {
            callbackInfo.cancel();
        }
    }
}
