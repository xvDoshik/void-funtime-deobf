/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.Vec3d
 *  net.minecraft.CloudRenderMode
 *  net.minecraft.CloudRenderer
 *  org.joml.Matrix4f
 *  org.spongepowered.asm.mixin.Mixin
 *  org.spongepowered.asm.mixin.injection.At
 *  org.spongepowered.asm.mixin.injection.Inject
 *  org.spongepowered.asm.mixin.injection.callback.CallbackInfo
 */
package CLASSESS.M;

import CLASSESS.Ki;
import net.minecraft.Vec3d;
import net.minecraft.CloudRenderMode;
import net.minecraft.CloudRenderer;
import org.joml.Matrix4f;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(value={CloudRenderer.class})
public abstract class pXrkwq {
    @Inject(method={"renderClouds"}, at={@At(value="HEAD")}, cancellable=true)
    private void Xd(int n, CloudRenderMode class_40632, float f, Matrix4f matrix4f, Matrix4f matrix4f2, Vec3d VanillaChestLootTableGenerator, float f2, CallbackInfo callbackInfo) {
        if (Ki.bA() && Ki.Xi()) {
            callbackInfo.cancel();
        }
    }
}
