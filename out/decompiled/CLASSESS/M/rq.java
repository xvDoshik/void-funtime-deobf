/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_1297
 *  net.minecraft.class_1657
 *  net.minecraft.class_1713
 *  net.minecraft.class_239
 *  net.minecraft.class_239$class_240
 *  net.minecraft.class_243
 *  net.minecraft.class_310
 *  net.minecraft.class_3966
 *  net.minecraft.class_636
 *  org.spongepowered.asm.mixin.Final
 *  org.spongepowered.asm.mixin.Mixin
 *  org.spongepowered.asm.mixin.Shadow
 *  org.spongepowered.asm.mixin.injection.At
 *  org.spongepowered.asm.mixin.injection.Inject
 *  org.spongepowered.asm.mixin.injection.callback.CallbackInfo
 */
package CLASSESS.M;

import CLASSESS.Up;
import CLASSESS.Yh;
import CLASSESS.feG;
import CLASSESS.wP;
import java.lang.invoke.MethodHandles;
import net.minecraft.class_1297;
import net.minecraft.class_1657;
import net.minecraft.class_1713;
import net.minecraft.class_239;
import net.minecraft.class_243;
import net.minecraft.class_310;
import net.minecraft.class_3966;
import net.minecraft.class_636;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

/*
 * Uses jvm11+ dynamic constants - pseudocode provided - see https://www.benf.org/other/cfr/dynamic-constants.html
 */
@Mixin(value={class_636.class})
public class rq {
    @Shadow
    @Final
    private class_310 field_3712;

    @Inject(method={"clickSlot"}, at={@At(value="HEAD")}, cancellable=true)
    private void void$banAnimPushClick(int n, int n2, int n3, class_1713 class_17132, class_1657 class_16572, CallbackInfo callbackInfo) {
        try {
            if (wP.bqJqp((int)n, (int)n2, (int)n3, (class_1713)class_17132, (class_1657)class_16572)) {
                callbackInfo.cancel();
                return;
            }
        }
        catch (Exception exception) {
            // empty catch block
        }
    }

    @Inject(method={"attackEntity"}, at={@At(value="HEAD")}, cancellable=true)
    private void onAttackEntityPre(class_1657 class_16572, class_1297 class_12972, CallbackInfo callbackInfo) {
        class_243 class_2432 = this.getHitPosition(class_12972);
        Yh yh = new Yh(class_12972, (boolean)( /* dynamic constant */ (Object)feG.ZQ("aYUsZG", MethodHandles.lookup(), "ZQ", rq.class, -842982416, 1693569706, -778136947, 31)), class_2432);
        Up.vh(yh);
        if (yh.isCancelled()) {
            callbackInfo.cancel();
        }
    }

    @Inject(method={"attackEntity"}, at={@At(value="RETURN")})
    private void onAttackEntityPost(class_1657 class_16572, class_1297 class_12972, CallbackInfo callbackInfo) {
        class_243 class_2432 = this.getHitPosition(class_12972);
        Yh yh = new Yh(class_12972, (boolean)( /* dynamic constant */ (Object)feG.ZQ("gR", MethodHandles.lookup(), "ZQ", rq.class, 749802544, -413483583, 1866815062, 8)), class_2432);
        Up.vh(yh);
    }

    private class_243 getHitPosition(class_1297 class_12972) {
        class_3966 class_39662;
        class_239 class_2392 = this.field_3712.field_1765;
        if (class_2392 != null && class_2392.method_17783() == class_239.class_240.field_1331 && (class_39662 = (class_3966)class_2392).method_17782() == class_12972) {
            return class_39662.method_17784();
        }
        return class_12972.method_19538().method_1031((double)( /* dynamic constant */ (Object)feG.TR("ToMH", MethodHandles.lookup(), "TR", rq.class, -1994723523107370396L, 3527960258975432644L, 5919078601824369756L, 32)), (double)class_12972.method_17682() / ( /* dynamic constant */ (Object)feG.TR("fTnDg", MethodHandles.lookup(), "TR", rq.class, 2590011195934186765L, 8203726847241526675L, 2879958647116773852L, 20)), (double)( /* dynamic constant */ (Object)feG.TR("ToMH", MethodHandles.lookup(), "TR", rq.class, -1994723523107370396L, 3527960258975432644L, 5919078601824369756L, 32)));
    }
}
