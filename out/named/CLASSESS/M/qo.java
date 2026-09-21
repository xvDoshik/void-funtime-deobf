/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.ParticleEffect
 *  net.minecraft.ParticleType
 *  net.minecraft.ParticleTypes
 *  net.minecraft.ParticleTextureSheet
 *  net.minecraft.ParticleManager
 *  net.minecraft.Particle
 *  org.spongepowered.asm.mixin.Final
 *  org.spongepowered.asm.mixin.Mixin
 *  org.spongepowered.asm.mixin.Shadow
 *  org.spongepowered.asm.mixin.injection.At
 *  org.spongepowered.asm.mixin.injection.Inject
 *  org.spongepowered.asm.mixin.injection.callback.CallbackInfo
 *  org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable
 */
package CLASSESS.M;

import CLASSESS.Ki;
import CLASSESS.feG;
import java.lang.invoke.MethodHandles;
import java.util.Map;
import java.util.Queue;
import net.minecraft.ParticleEffect;
import net.minecraft.ParticleType;
import net.minecraft.ParticleTypes;
import net.minecraft.ParticleTextureSheet;
import net.minecraft.ParticleManager;
import net.minecraft.Particle;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

/*
 * Uses jvm11+ dynamic constants - pseudocode provided - see https://www.benf.org/other/cfr/dynamic-constants.html
 */
@Mixin(value={ParticleManager.class})
public abstract class qo {
    @Shadow
    @Final
    private Map<ParticleTextureSheet, Queue<Particle>> field_3830;
    @Shadow
    @Final
    private Queue<Particle> field_3836;

    @Inject(method={"addParticle(Lnet/minecraft/particle/ParticleEffect;DDDDDD)Lnet/minecraft/client/particle/Particle;"}, at={@At(value="HEAD")}, cancellable=true)
    private void void$skipSmoke(ParticleEffect class_23942, double d, double d2, double d3, double d4, double d5, double d6, CallbackInfoReturnable<Particle> callbackInfoReturnable) {
        if (Ki.bA() && Ki.i() && qo.void$isSmoke(class_23942.method_10295())) {
            callbackInfoReturnable.setReturnValue(null);
        }
    }

    @Inject(method={"tick"}, at={@At(value="HEAD")})
    private void void$removeExistingSmoke(CallbackInfo callbackInfo) {
        if (!Ki.bA() || !Ki.i()) {
            return;
        }
        this.field_3836.removeIf(qo::void$isSmokeParticle);
        for (Queue<Particle> queue : this.field_3830.values()) {
            queue.removeIf(qo::void$isSmokeParticle);
        }
    }

    private static boolean void$isSmoke(ParticleType<?> class_23962) {
        return (boolean)(class_23962 == ParticleTypes.field_11251 || class_23962 == ParticleTypes.field_11237 || class_23962 == ParticleTypes.field_46911 || class_23962 == ParticleTypes.field_17430 || class_23962 == ParticleTypes.field_17431 || class_23962 == ParticleTypes.field_22247 || class_23962 == ParticleTypes.field_23956 ? ( /* dynamic constant */ (Object)feG.ZQ("KTlexS", MethodHandles.lookup(), "ZQ", qo.class, 87642472, -1367187466, -1134783060, 18)) : ( /* dynamic constant */ (Object)feG.ZQ("Th", MethodHandles.lookup(), "ZQ", qo.class, 1383271038, 2032358615, 1800385183, 15)));
    }

    private static boolean void$isSmokeParticle(Particle class_7032) {
        String string = class_7032.getClass().getSimpleName();
        return (boolean)(string.contains((CharSequence)( /* dynamic constant */ (Object)feG.fL("tCtWrN", MethodHandles.lookup(), "fL", qo.class, "(S\u00cf\u00b9\u000e", 2048553801, 1846714083, -975632825, 1))) || string.contains((CharSequence)( /* dynamic constant */ (Object)feG.fL("uX", MethodHandles.lookup(), "fL", qo.class, "$\u00af\u007f", 1769247833, 16113914, 1173391692, 2))) ? ( /* dynamic constant */ (Object)feG.ZQ("KTlexS", MethodHandles.lookup(), "ZQ", qo.class, 87642472, -1367187466, -1134783060, 18)) : ( /* dynamic constant */ (Object)feG.ZQ("Th", MethodHandles.lookup(), "ZQ", qo.class, 1383271038, 2032358615, 1800385183, 15)));
    }
}
