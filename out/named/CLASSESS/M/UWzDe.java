/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.EntityRenderState
 *  net.minecraft.Entity
 *  net.minecraft.PlayerEntity
 *  net.minecraft.EntityRenderer
 *  org.spongepowered.asm.mixin.Mixin
 *  org.spongepowered.asm.mixin.injection.At
 *  org.spongepowered.asm.mixin.injection.Inject
 *  org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable
 */
package CLASSESS.M;

import CLASSESS.TUagLH;
import net.minecraft.EntityRenderState;
import net.minecraft.Entity;
import net.minecraft.PlayerEntity;
import net.minecraft.EntityRenderer;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(value={EntityRenderer.class})
public abstract class UWzDe<S extends EntityRenderState> {
    @Inject(method={"hasLabel"}, at={@At(value="HEAD")}, cancellable=true)
    private void cTY(Entity class_12972, double d, CallbackInfoReturnable<Boolean> callbackInfoReturnable) {
        TUagLH tUagLH = TUagLH.WXxUT();
        if (class_12972 instanceof PlayerEntity) {
            PlayerEntity class_16572 = (PlayerEntity)class_12972;
            if (tUagLH != null && tUagLH.shouldHideTarget(class_16572)) {
                callbackInfoReturnable.setReturnValue((Object)false);
            }
        }
    }
}
