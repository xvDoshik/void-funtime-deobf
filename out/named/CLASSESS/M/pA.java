/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.PlayerEntityRenderState
 *  net.minecraft.PlayerEntityRenderer
 *  net.minecraft.Text
 *  net.minecraft.MatrixStack
 *  net.minecraft.VertexConsumerProvider
 *  org.spongepowered.asm.mixin.Mixin
 *  org.spongepowered.asm.mixin.injection.At
 *  org.spongepowered.asm.mixin.injection.Inject
 *  org.spongepowered.asm.mixin.injection.callback.CallbackInfo
 */
package CLASSESS.M;

import CLASSESS.rNWiQ;
import net.minecraft.PlayerEntityRenderState;
import net.minecraft.PlayerEntityRenderer;
import net.minecraft.Text;
import net.minecraft.MatrixStack;
import net.minecraft.VertexConsumerProvider;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(value={PlayerEntityRenderer.class})
public abstract class pA {
    @Inject(method={"renderLabelIfPresent"}, at={@At(value="TAIL")})
    private void void$renderCustomDetections(PlayerEntityRenderState class_100552, Text class_25612, MatrixStack class_45872, VertexConsumerProvider class_45972, int n, CallbackInfo callbackInfo) {
        rNWiQ.lSIqYx(class_100552, class_45872);
    }
}
