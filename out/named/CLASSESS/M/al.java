/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.Entity
 *  net.minecraft.BlockView
 *  net.minecraft.MinecraftClient
 *  net.minecraft.Camera
 *  org.spongepowered.asm.mixin.Mixin
 *  org.spongepowered.asm.mixin.injection.At
 *  org.spongepowered.asm.mixin.injection.Inject
 *  org.spongepowered.asm.mixin.injection.callback.CallbackInfo
 */
package CLASSESS.M;

import CLASSESS.TUagLH;
import CLASSESS.o;
import net.minecraft.Entity;
import net.minecraft.BlockView;
import net.minecraft.MinecraftClient;
import net.minecraft.Camera;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(value={Camera.class})
public class al {
    @Inject(method={"update"}, at={@At(value="TAIL")})
    private void void$applyFollowCamera(BlockView class_19222, Entity class_12972, boolean bl, boolean bl2, float f, CallbackInfo callbackInfo) {
        try {
            o.cUzXZ((Camera)this, f);
            TUagLH.Ie((Camera)this, f);
            MinecraftClient class_3102 = MinecraftClient.method_1551();
            if ((o.xE() || TUagLH.tIFgxB()) && class_3102.method_1483() != null) {
                class_3102.method_1483().method_4876((Camera)this);
            }
        }
        catch (Throwable throwable) {
            // empty catch block
        }
    }
}
