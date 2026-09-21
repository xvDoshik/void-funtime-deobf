/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.StatusEffect
 *  net.minecraft.StatusEffectUtil
 *  net.minecraft.StatusEffectInstance
 *  net.minecraft.StatusEffects
 *  net.minecraft.LivingEntity
 *  net.minecraft.PlayerEntity
 *  net.minecraft.MinecraftClient
 *  net.minecraft.RegistryEntry
 *  net.minecraft.ClientPlayerEntity
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
import net.minecraft.StatusEffect;
import net.minecraft.StatusEffectUtil;
import net.minecraft.StatusEffectInstance;
import net.minecraft.StatusEffects;
import net.minecraft.LivingEntity;
import net.minecraft.PlayerEntity;
import net.minecraft.MinecraftClient;
import net.minecraft.RegistryEntry;
import net.minecraft.ClientPlayerEntity;
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
@Mixin(value={LivingEntity.class}, priority=999)
public abstract class oq {
    @Unique
    private final MinecraftClient client = MinecraftClient.method_1551();

    @Shadow
    public abstract boolean method_6059(RegistryEntry<StatusEffect> var1);

    @Shadow
    @Nullable
    public abstract StatusEffectInstance method_6112(RegistryEntry<StatusEffect> var1);

    @Inject(method={"jump"}, at={@At(value="HEAD")}, cancellable=true, require=0)
    private void jump(CallbackInfo callbackInfo) {
        Object object = this;
        if (object instanceof ClientPlayerEntity) {
            ClientPlayerEntity class_7462 = (ClientPlayerEntity)object;
            object = new tQ((PlayerEntity)class_7462);
            Up.vh((SyBEH)object);
            if (object.isCancelled()) {
                callbackInfo.cancel();
            }
        }
    }

    @Inject(method={"getHandSwingDuration"}, at={@At(value="HEAD")}, cancellable=true, require=0)
    private void onGetHandSwingDuration(CallbackInfoReturnable<Integer> callbackInfoReturnable) {
        if (this != MinecraftClient.method_1551().field_1724) {
            return;
        }
        yhZvX yhZvX2 = new yhZvX();
        Up.vh((SyBEH)((Object)yhZvX2));
        if (yhZvX2.isCancelled()) {
            float f = yhZvX2.getAnimation();
            if (StatusEffectUtil.method_5576((LivingEntity)MinecraftClient.method_1551().field_1724)) {
                f *= (float)(( /* dynamic constant */ (Object)feG.ZQ("bcHCG", MethodHandles.lookup(), "ZQ", oq.class, -1235074071, 271774761, 348514814, 3)) - (( /* dynamic constant */ (Object)feG.ZQ("ZCpr", MethodHandles.lookup(), "ZQ", oq.class, 2021787821, 2106298304, 1876407238, 5)) + StatusEffectUtil.method_5575((LivingEntity)MinecraftClient.method_1551().field_1724)));
            } else if (this.method_6059((RegistryEntry<StatusEffect>)StatusEffects.field_5901)) {
                StatusEffectInstance class_12932 = this.method_6112((RegistryEntry<StatusEffect>)StatusEffects.field_5901);
                f *= (float)(( /* dynamic constant */ (Object)feG.ZQ("bcHCG", MethodHandles.lookup(), "ZQ", oq.class, -1235074071, 271774761, 348514814, 3)) + (( /* dynamic constant */ (Object)feG.ZQ("ZCpr", MethodHandles.lookup(), "ZQ", oq.class, 2021787821, 2106298304, 1876407238, 5)) + class_12932.method_5578()) * ( /* dynamic constant */ (Object)feG.ZQ("BgkZCT", MethodHandles.lookup(), "ZQ", oq.class, 11492674, 405459515, 152440787, 23)));
            } else {
                f *= ( /* dynamic constant */ (Object)feG.ZQ("SHW", MethodHandles.lookup(), "ZQ", oq.class, -504190741, -1410155305, -1087630283, 24));
            }
            callbackInfoReturnable.setReturnValue((Object)((int)f));
        }
    }
}
