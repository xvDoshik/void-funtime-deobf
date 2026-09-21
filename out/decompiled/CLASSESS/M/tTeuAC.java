/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.llamalad7.mixinextras.injector.ModifyExpressionValue
 *  net.minecraft.class_765
 *  org.spongepowered.asm.mixin.Mixin
 *  org.spongepowered.asm.mixin.injection.At
 *  org.spongepowered.asm.mixin.injection.Inject
 *  org.spongepowered.asm.mixin.injection.callback.CallbackInfo
 */
package CLASSESS.M;

import CLASSESS.SyBEH;
import CLASSESS.Up;
import CLASSESS.feG;
import CLASSESS.iK;
import CLASSESS.uAtFiz;
import com.llamalad7.mixinextras.injector.ModifyExpressionValue;
import java.lang.invoke.MethodHandles;
import net.minecraft.class_765;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

/*
 * Uses jvm11+ dynamic constants - pseudocode provided - see https://www.benf.org/other/cfr/dynamic-constants.html
 */
@Mixin(value={class_765.class})
public class tTeuAC {
    @ModifyExpressionValue(method={"update(F)V"}, at={@At(value="INVOKE", target="Lnet/minecraft/client/option/SimpleOption;getValue()Ljava/lang/Object;")})
    private Object Rkhuqx(Object object) {
        uAtFiz uAtFiz2 = uAtFiz.m();
        if (uAtFiz2 != null && uAtFiz2.isState()) {
            return Math.max((Double)object, (double)(uAtFiz2.getBrightSetting().getValue() * ( /* dynamic constant */ (Object)feG.Rz("vX", MethodHandles.lookup(), "Rz", tTeuAC.class, 950126894, -675779655, 421156701, 2))));
        }
        return object;
    }

    @Inject(method={"update"}, at={@At(value="HEAD")})
    private void onLightmapUpdate(float f, CallbackInfo callbackInfo) {
        Up.vh((SyBEH)((Object)new iK((class_765)this)));
    }
}
