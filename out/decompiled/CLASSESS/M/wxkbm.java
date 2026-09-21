/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_638$class_5271
 *  org.spongepowered.asm.mixin.Mixin
 *  org.spongepowered.asm.mixin.Shadow
 *  org.spongepowered.asm.mixin.injection.At
 *  org.spongepowered.asm.mixin.injection.Inject
 *  org.spongepowered.asm.mixin.injection.callback.CallbackInfo
 */
package CLASSESS.M;

import CLASSESS.lEMQd;
import CLASSESS.lnURa;
import net.minecraft.class_638;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(value={class_638.class_5271.class})
public class wxkbm
implements lnURa {
    @Shadow
    private long field_24439;

    @Inject(method={"setTimeOfDay"}, at={@At(value="HEAD")}, cancellable=true)
    public void setTimeOfDayHook(long l, CallbackInfo callbackInfo) {
        lEMQd lEMQd2 = lEMQd.SuPzEZ();
        if (lEMQd2 != null && lEMQd2.isEnabled()) {
            this.field_24439 = (long)lEMQd2.getTimeSetting().getInt() * 1000L;
            callbackInfo.cancel();
        }
    }
}
