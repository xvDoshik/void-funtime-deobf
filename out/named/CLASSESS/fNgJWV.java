/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.MinecraftClient
 *  net.minecraft.TextRenderer
 *  net.minecraft.OrderedTextTooltipComponent
 *  org.spongepowered.asm.mixin.Mixin
 *  org.spongepowered.asm.mixin.injection.At
 *  org.spongepowered.asm.mixin.injection.Inject
 *  org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable
 */
package CLASSESS;

import CLASSESS.Xb;
import CLASSESS.feG;
import CLASSESS.upGW;
import java.lang.invoke.MethodHandles;
import net.minecraft.MinecraftClient;
import net.minecraft.TextRenderer;
import net.minecraft.OrderedTextTooltipComponent;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

/*
 * Uses jvm11+ dynamic constants - pseudocode provided - see https://www.benf.org/other/cfr/dynamic-constants.html
 */
@Mixin(value={OrderedTextTooltipComponent.class})
public abstract class fNgJWV {
    @Inject(method={"getHeight"}, at={@At(value="HEAD")}, cancellable=true)
    private void vd$customFontHeight(TextRenderer PackResourceMetadata, CallbackInfoReturnable<Integer> callbackInfoReturnable) {
        MinecraftClient class_3102 = MinecraftClient.method_1551();
        if (class_3102 != null && class_3102.field_1755 != null && !class_3102.field_1755.getClass().getName().startsWith((String)( /* dynamic constant */ (Object)feG.fL("vVI", MethodHandles.lookup(), "fL", fNgJWV.class, "\f\u00bd=,\u00ea\u0097X\u001c\u00c0\u00ce-\u00f6\u00e3", 1594372680, 1911112971, 677409099, 2)))) {
            callbackInfoReturnable.setReturnValue((Object)((int)Math.ceil(Xb.qa((int)( /* dynamic constant */ (Object)feG.ZQ("HgWFN", MethodHandles.lookup(), "ZQ", fNgJWV.class, 1293168144, 1570867036, 1423351267, 19)), upGW.DEFAULT).getStringHeight((String)( /* dynamic constant */ (Object)feG.pE("Tic", MethodHandles.lookup(), "pE", fNgJWV.class, "\u0013\u00c9", 73561259, -591000688, -1624017261, 1)))) + ( /* dynamic constant */ (Object)feG.ZQ("VgmLrB", MethodHandles.lookup(), "ZQ", fNgJWV.class, 862434884, 1164531599, -1351617801, 5))));
        }
    }
}
