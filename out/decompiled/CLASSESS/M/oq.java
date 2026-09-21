/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_1291
 *  net.minecraft.class_1292
 *  net.minecraft.class_1293
 *  net.minecraft.class_1294
 *  net.minecraft.class_1309
 *  net.minecraft.class_1657
 *  net.minecraft.class_310
 *  net.minecraft.class_6880
 *  net.minecraft.class_746
 *  org.jetbrains.annotations.Nullable
 *  org.spongepowered.asm.mixin.Mixin
 *  org.spongepowered.asm.mixin.Shadow
 *  org.spongepowered.asm.mixin.Unique
 *  org.spongepowered.asm.mixin.injection.At
 *  org.spongepowered.asm.mixin.injection.Inject
 *  org.spongepowered.asm.mixin.injection.callback.CallbackInfo
 *  org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable
 */
package CLASSESS.M;

import CLASSESS.SyBEH;
import CLASSESS.Up;
import CLASSESS.feG;
import CLASSESS.tQ;
import CLASSESS.yhZvX;
import java.lang.invoke.MethodHandles;
import net.minecraft.class_1291;
import net.minecraft.class_1292;
import net.minecraft.class_1293;
import net.minecraft.class_1294;
import net.minecraft.class_1309;
import net.minecraft.class_1657;
import net.minecraft.class_310;
import net.minecraft.class_6880;
import net.minecraft.class_746;
import org.jetbrains.annotations.Nullable;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

/*
 * Uses jvm11+ dynamic constants - pseudocode provided - see https://www.benf.org/other/cfr/dynamic-constants.html
 */
@Mixin(value={class_1309.class}, priority=999)
public abstract class oq {
    @Unique
    private final class_310 client = class_310.method_1551();

    @Shadow
    public abstract boolean method_6059(class_6880<class_1291> var1);

    @Shadow
    @Nullable
    public abstract class_1293 method_6112(class_6880<class_1291> var1);

    @Inject(method={"jump"}, at={@At(value="HEAD")}, cancellable=true, require=0)
    private void jump(CallbackInfo callbackInfo) {
        Object object = this;
        if (object instanceof class_746) {
            class_746 class_7462 = (class_746)object;
            object = new tQ((class_1657)class_7462);
            Up.vh((SyBEH)object);
            if (object.isCancelled()) {
                callbackInfo.cancel();
            }
        }
    }

    @Inject(method={"getHandSwingDuration"}, at={@At(value="HEAD")}, cancellable=true, require=0)
    private void onGetHandSwingDuration(CallbackInfoReturnable<Integer> callbackInfoReturnable) {
        if (this != class_310.method_1551().field_1724) {
            return;
        }
        yhZvX yhZvX2 = new yhZvX();
        Up.vh((SyBEH)((Object)yhZvX2));
        if (yhZvX2.isCancelled()) {
            float f = yhZvX2.getAnimation();
            if (class_1292.method_5576((class_1309)class_310.method_1551().field_1724)) {
                f *= (float)(( /* dynamic constant */ (Object)feG.ZQ("bcHCG", MethodHandles.lookup(), "ZQ", oq.class, -1235074071, 271774761, 348514814, 3)) - (( /* dynamic constant */ (Object)feG.ZQ("ZCpr", MethodHandles.lookup(), "ZQ", oq.class, 2021787821, 2106298304, 1876407238, 5)) + class_1292.method_5575((class_1309)class_310.method_1551().field_1724)));
            } else if (this.method_6059((class_6880<class_1291>)class_1294.field_5901)) {
                class_1293 class_12932 = this.method_6112((class_6880<class_1291>)class_1294.field_5901);
                f *= (float)(( /* dynamic constant */ (Object)feG.ZQ("bcHCG", MethodHandles.lookup(), "ZQ", oq.class, -1235074071, 271774761, 348514814, 3)) + (( /* dynamic constant */ (Object)feG.ZQ("ZCpr", MethodHandles.lookup(), "ZQ", oq.class, 2021787821, 2106298304, 1876407238, 5)) + class_12932.method_5578()) * ( /* dynamic constant */ (Object)feG.ZQ("BgkZCT", MethodHandles.lookup(), "ZQ", oq.class, 11492674, 405459515, 152440787, 23)));
            } else {
                f *= ( /* dynamic constant */ (Object)feG.ZQ("SHW", MethodHandles.lookup(), "ZQ", oq.class, -504190741, -1410155305, -1087630283, 24));
            }
            callbackInfoReturnable.setReturnValue((Object)((int)f));
        }
    }
}
