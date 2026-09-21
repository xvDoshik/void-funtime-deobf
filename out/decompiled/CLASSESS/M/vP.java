/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_268
 *  net.minecraft.class_269
 *  org.spongepowered.asm.mixin.Mixin
 *  org.spongepowered.asm.mixin.injection.At
 *  org.spongepowered.asm.mixin.injection.Inject
 *  org.spongepowered.asm.mixin.injection.callback.CallbackInfo
 */
package CLASSESS.M;

import net.minecraft.class_268;
import net.minecraft.class_269;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(value={class_269.class})
public class vP {
    @Inject(method={"removeScoreHolderFromTeam"}, at={@At(value="HEAD")}, cancellable=true)
    private void onRemoveScoreHolderFromTeam(String string, class_268 class_2682, CallbackInfo callbackInfo) {
        class_269 class_2692 = (class_269)this;
        class_268 class_2683 = class_2692.method_1164(string);
        if (class_2683 != class_2682) {
            callbackInfo.cancel();
        }
    }
}
