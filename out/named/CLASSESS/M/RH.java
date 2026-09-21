/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.llamalad7.mixinextras.injector.ModifyExpressionValue
 *  net.minecraft.Entity
 *  org.spongepowered.asm.mixin.Mixin
 *  org.spongepowered.asm.mixin.injection.At
 */
package CLASSESS.M;

import CLASSESS.lnURa;
import com.llamalad7.mixinextras.injector.ModifyExpressionValue;
import net.minecraft.Entity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;

@Mixin(value={Entity.class})
public class RH
implements lnURa {
    @ModifyExpressionValue(method={"move"}, at={@At(value="INVOKE", target="Lnet/minecraft/entity/Entity;isControlledByPlayer()Z")})
    private boolean XvoZI(boolean bl) {
        if (this == RH.mc.field_1724) {
            return false;
        }
        return bl;
    }
}
