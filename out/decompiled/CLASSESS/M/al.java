/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_1297
 *  net.minecraft.class_1922
 *  net.minecraft.class_310
 *  net.minecraft.class_4184
 *  org.spongepowered.asm.mixin.Mixin
 *  org.spongepowered.asm.mixin.injection.At
 *  org.spongepowered.asm.mixin.injection.Inject
 *  org.spongepowered.asm.mixin.injection.callback.CallbackInfo
 */
package CLASSESS.M;

import CLASSESS.TUagLH;
import CLASSESS.o;
import net.minecraft.class_1297;
import net.minecraft.class_1922;
import net.minecraft.class_310;
import net.minecraft.class_4184;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(value={class_4184.class})
public class al {
    @Inject(method={"update"}, at={@At(value="TAIL")})
    private void void$applyFollowCamera(class_1922 class_19222, class_1297 class_12972, boolean bl, boolean bl2, float f, CallbackInfo callbackInfo) {
        try {
            o.cUzXZ((class_4184)this, f);
            TUagLH.Ie((class_4184)this, f);
            class_310 class_3102 = class_310.method_1551();
            if ((o.xE() || TUagLH.tIFgxB()) && class_3102.method_1483() != null) {
                class_3102.method_1483().method_4876((class_4184)this);
            }
        }
        catch (Throwable throwable) {
            // empty catch block
        }
    }
}
