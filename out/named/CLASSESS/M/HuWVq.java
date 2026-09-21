/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.llamalad7.mixinextras.injector.wrapoperation.Operation
 *  com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation
 *  com.llamalad7.mixinextras.sugar.Local
 *  net.minecraft.Hand
 *  net.minecraft.Arm
 *  net.minecraft.LivingEntity
 *  net.minecraft.ItemStack
 *  net.minecraft.MatrixStack
 *  net.minecraft.VertexConsumerProvider
 *  net.minecraft.AbstractClientPlayerEntity
 *  net.minecraft.HeldItemRenderer
 *  net.minecraft.ModelTransformationMode
 *  org.spongepowered.asm.mixin.Mixin
 *  org.spongepowered.asm.mixin.injection.At
 *  org.spongepowered.asm.mixin.injection.At$Shift
 *  org.spongepowered.asm.mixin.injection.Inject
 *  org.spongepowered.asm.mixin.injection.callback.CallbackInfo
 */
package CLASSESS.M;

import CLASSESS.Qe;
import CLASSESS.SyBEH;
import CLASSESS.TUagLH;
import CLASSESS.Up;
import CLASSESS.bNQhc;
import CLASSESS.feG;
import CLASSESS.wn;
import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation;
import com.llamalad7.mixinextras.sugar.Local;
import java.lang.invoke.MethodHandles;
import net.minecraft.Hand;
import net.minecraft.Arm;
import net.minecraft.LivingEntity;
import net.minecraft.ItemStack;
import net.minecraft.MatrixStack;
import net.minecraft.VertexConsumerProvider;
import net.minecraft.AbstractClientPlayerEntity;
import net.minecraft.HeldItemRenderer;
import net.minecraft.ModelTransformationMode;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

/*
 * Uses jvm11+ dynamic constants - pseudocode provided - see https://www.benf.org/other/cfr/dynamic-constants.html
 */
@Mixin(value={HeldItemRenderer.class})
public abstract class HuWVq {
    @Inject(method={"renderFirstPersonItem"}, at={@At(value="INVOKE", target="Lnet/minecraft/client/util/math/MatrixStack;push()V", shift=At.Shift.AFTER)})
    private void onRenderFirstPersonItem(AbstractClientPlayerEntity TrackedPosition, float f, float f2, Hand class_12682, float f3, ItemStack class_17992, float f4, MatrixStack class_45872, VertexConsumerProvider class_45972, int n, CallbackInfo callbackInfo) {
        Qe qe2 = new Qe(class_45872, class_17992, class_12682);
        Up.vh((SyBEH)((Object)qe2));
    }

    @Inject(method={"renderFirstPersonItem"}, at={@At(value="HEAD")}, cancellable=true)
    private void hY(AbstractClientPlayerEntity TrackedPosition, float f, float f2, Hand class_12682, float f3, ItemStack class_17992, float f4, MatrixStack class_45872, VertexConsumerProvider class_45972, int n, CallbackInfo callbackInfo) {
        if (TUagLH.tIFgxB()) {
            callbackInfo.cancel();
        }
    }

    @WrapOperation(method={"renderFirstPersonItem"}, at={@At(value="INVOKE", target="Lnet/minecraft/client/render/item/HeldItemRenderer;renderItem(Lnet/minecraft/entity/LivingEntity;Lnet/minecraft/item/ItemStack;Lnet/minecraft/item/ModelTransformationMode;ZLnet/minecraft/client/util/math/MatrixStack;Lnet/minecraft/client/render/VertexConsumerProvider;I)V")})
    private void onRenderItem(HeldItemRenderer class_7592, LivingEntity class_13092, ItemStack class_17992, ModelTransformationMode DeathMessageType, boolean bl, MatrixStack class_45872, VertexConsumerProvider class_45972, int n, Operation<Void> operation, @Local(ordinal=0, argsOnly=true) Hand class_12682) {
        wn wn2 = new wn(class_45872, class_17992, class_12682);
        Up.vh((SyBEH)((Object)wn2));
        if (wn2.getScale() != ( /* dynamic constant */ (Object)feG.ZQ("fB", MethodHandles.lookup(), "ZQ", HuWVq.class, 46914643, -1455093419, -2146016844, 10))) {
            class_45872.method_22903();
            float f = wn2.getScale();
            class_45872.method_22905(f, f, f);
            Object[] objectArray = new Object[ /* dynamic constant */ (Object)feG.ZQ("gg", MethodHandles.lookup(), "ZQ", HuWVq.class, 1414628891, -1635156763, 77290220, 17)];
            objectArray[ /* dynamic constant */ (Object)feG.ZQ("pPbRn", MethodHandles.lookup(), "ZQ", HuWVq.class, -877181326, -1459827417, -1856160603, 1)] = class_7592;
            objectArray[ /* dynamic constant */ (Object)feG.ZQ("mqHV", MethodHandles.lookup(), "ZQ", HuWVq.class, 1115520271, 234072664, -379872699, 17)] = class_13092;
            objectArray[ /* dynamic constant */ (Object)feG.ZQ("ak", MethodHandles.lookup(), "ZQ", HuWVq.class, 1825968971, -1150362727, -557136482, 14)] = class_17992;
            objectArray[ /* dynamic constant */ (Object)feG.ZQ("DCIpD", MethodHandles.lookup(), "ZQ", HuWVq.class, 1196899043, -738321604, 1323741756, 7)] = DeathMessageType;
            objectArray[ /* dynamic constant */ (Object)feG.ZQ("rfvCjU", MethodHandles.lookup(), "ZQ", HuWVq.class, 725086540, -1077917655, 917994134, 4)] = bl;
            objectArray[ /* dynamic constant */ (Object)feG.ZQ("fZqVT", MethodHandles.lookup(), "ZQ", HuWVq.class, 193966710, 551427899, -548041572, 5)] = class_45872;
            objectArray[ /* dynamic constant */ (Object)feG.ZQ("KXSe", MethodHandles.lookup(), "ZQ", HuWVq.class, -769800789, 739791819, 348171834, 3)] = class_45972;
            objectArray[ /* dynamic constant */ (Object)feG.ZQ("AGS", MethodHandles.lookup(), "ZQ", HuWVq.class, -2142019280, 1045017637, 273508445, 29)] = n;
            operation.call(objectArray);
            class_45872.method_22909();
        } else {
            Object[] objectArray = new Object[ /* dynamic constant */ (Object)feG.ZQ("gg", MethodHandles.lookup(), "ZQ", HuWVq.class, 1414628891, -1635156763, 77290220, 17)];
            objectArray[ /* dynamic constant */ (Object)feG.ZQ("pPbRn", MethodHandles.lookup(), "ZQ", HuWVq.class, -877181326, -1459827417, -1856160603, 1)] = class_7592;
            objectArray[ /* dynamic constant */ (Object)feG.ZQ("mqHV", MethodHandles.lookup(), "ZQ", HuWVq.class, 1115520271, 234072664, -379872699, 17)] = class_13092;
            objectArray[ /* dynamic constant */ (Object)feG.ZQ("ak", MethodHandles.lookup(), "ZQ", HuWVq.class, 1825968971, -1150362727, -557136482, 14)] = class_17992;
            objectArray[ /* dynamic constant */ (Object)feG.ZQ("DCIpD", MethodHandles.lookup(), "ZQ", HuWVq.class, 1196899043, -738321604, 1323741756, 7)] = DeathMessageType;
            objectArray[ /* dynamic constant */ (Object)feG.ZQ("rfvCjU", MethodHandles.lookup(), "ZQ", HuWVq.class, 725086540, -1077917655, 917994134, 4)] = bl;
            objectArray[ /* dynamic constant */ (Object)feG.ZQ("fZqVT", MethodHandles.lookup(), "ZQ", HuWVq.class, 193966710, 551427899, -548041572, 5)] = class_45872;
            objectArray[ /* dynamic constant */ (Object)feG.ZQ("KXSe", MethodHandles.lookup(), "ZQ", HuWVq.class, -769800789, 739791819, 348171834, 3)] = class_45972;
            objectArray[ /* dynamic constant */ (Object)feG.ZQ("AGS", MethodHandles.lookup(), "ZQ", HuWVq.class, -2142019280, 1045017637, 273508445, 29)] = n;
            operation.call(objectArray);
        }
    }

    @WrapOperation(method={"renderFirstPersonItem"}, at={@At(value="INVOKE", target="Lnet/minecraft/client/render/item/HeldItemRenderer;swingArm(FFLnet/minecraft/client/util/math/MatrixStack;ILnet/minecraft/util/Arm;)V", ordinal=2)})
    private void onSwingArmMainHand(HeldItemRenderer class_7592, float f, float f2, MatrixStack class_45872, int n, Arm class_13062, Operation<Void> operation, @Local(ordinal=0, argsOnly=true) AbstractClientPlayerEntity TrackedPosition, @Local(ordinal=0, argsOnly=true) Hand class_12682) {
        bNQhc bNQhc2 = new bNQhc(class_45872, class_12682, f);
        Up.vh((SyBEH)((Object)bNQhc2));
        if (!bNQhc2.isCancelled()) {
            Object[] objectArray = new Object[ /* dynamic constant */ (Object)feG.ZQ("KXSe", MethodHandles.lookup(), "ZQ", HuWVq.class, -769800789, 739791819, 348171834, 3)];
            objectArray[ /* dynamic constant */ (Object)feG.ZQ("pPbRn", MethodHandles.lookup(), "ZQ", HuWVq.class, -877181326, -1459827417, -1856160603, 1)] = class_7592;
            objectArray[ /* dynamic constant */ (Object)feG.ZQ("mqHV", MethodHandles.lookup(), "ZQ", HuWVq.class, 1115520271, 234072664, -379872699, 17)] = Float.valueOf(f);
            objectArray[ /* dynamic constant */ (Object)feG.ZQ("ak", MethodHandles.lookup(), "ZQ", HuWVq.class, 1825968971, -1150362727, -557136482, 14)] = Float.valueOf(f2);
            objectArray[ /* dynamic constant */ (Object)feG.ZQ("DCIpD", MethodHandles.lookup(), "ZQ", HuWVq.class, 1196899043, -738321604, 1323741756, 7)] = class_45872;
            objectArray[ /* dynamic constant */ (Object)feG.ZQ("rfvCjU", MethodHandles.lookup(), "ZQ", HuWVq.class, 725086540, -1077917655, 917994134, 4)] = n;
            objectArray[ /* dynamic constant */ (Object)feG.ZQ("fZqVT", MethodHandles.lookup(), "ZQ", HuWVq.class, 193966710, 551427899, -548041572, 5)] = class_13062;
            operation.call(objectArray);
        }
    }
}
