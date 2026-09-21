/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.Entity
 *  net.minecraft.PlayerEntity
 *  net.minecraft.SlotActionType
 *  net.minecraft.HitResult
 *  net.minecraft.HitResult$class_240
 *  net.minecraft.Vec3d
 *  net.minecraft.MinecraftClient
 *  net.minecraft.EntityHitResult
 *  net.minecraft.ClientPlayerInteractionManager
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
import net.minecraft.Entity;
import net.minecraft.PlayerEntity;
import net.minecraft.SlotActionType;
import net.minecraft.HitResult;
import net.minecraft.Vec3d;
import net.minecraft.MinecraftClient;
import net.minecraft.EntityHitResult;
import net.minecraft.ClientPlayerInteractionManager;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

/*
 * Uses jvm11+ dynamic constants - pseudocode provided - see https://www.benf.org/other/cfr/dynamic-constants.html
 */
@Mixin(value={ClientPlayerInteractionManager.class})
public class rq {
    @Shadow
    @Final
    private MinecraftClient field_3712;

    @Inject(method={"clickSlot"}, at={@At(value="HEAD")}, cancellable=true)
    private void void$banAnimPushClick(int n, int n2, int n3, SlotActionType class_17132, PlayerEntity class_16572, CallbackInfo callbackInfo) {
        try {
            if (wP.bqJqp((int)n, (int)n2, (int)n3, (SlotActionType)class_17132, (PlayerEntity)class_16572)) {
                callbackInfo.cancel();
                return;
            }
        }
        catch (Exception exception) {
            // empty catch block
        }
    }

    @Inject(method={"attackEntity"}, at={@At(value="HEAD")}, cancellable=true)
    private void onAttackEntityPre(PlayerEntity class_16572, Entity class_12972, CallbackInfo callbackInfo) {
        Vec3d VanillaChestLootTableGenerator = this.getHitPosition(class_12972);
        Yh yh = new Yh(class_12972, (boolean)( /* dynamic constant */ (Object)feG.ZQ("aYUsZG", MethodHandles.lookup(), "ZQ", rq.class, -842982416, 1693569706, -778136947, 31)), VanillaChestLootTableGenerator);
        Up.vh(yh);
        if (yh.isCancelled()) {
            callbackInfo.cancel();
        }
    }

    @Inject(method={"attackEntity"}, at={@At(value="RETURN")})
    private void onAttackEntityPost(PlayerEntity class_16572, Entity class_12972, CallbackInfo callbackInfo) {
        Vec3d VanillaChestLootTableGenerator = this.getHitPosition(class_12972);
        Yh yh = new Yh(class_12972, (boolean)( /* dynamic constant */ (Object)feG.ZQ("gR", MethodHandles.lookup(), "ZQ", rq.class, 749802544, -413483583, 1866815062, 8)), VanillaChestLootTableGenerator);
        Up.vh(yh);
    }

    private Vec3d getHitPosition(Entity class_12972) {
        EntityHitResult class_39662;
        HitResult ItemStackParticleEffect = this.field_3712.field_1765;
        if (ItemStackParticleEffect != null && ItemStackParticleEffect.method_17783() == HitResult.class_240.field_1331 && (class_39662 = (EntityHitResult)ItemStackParticleEffect).method_17782() == class_12972) {
            return class_39662.method_17784();
        }
        return class_12972.method_19538().method_1031((double)( /* dynamic constant */ (Object)feG.TR("ToMH", MethodHandles.lookup(), "TR", rq.class, -1994723523107370396L, 3527960258975432644L, 5919078601824369756L, 32)), (double)class_12972.method_17682() / ( /* dynamic constant */ (Object)feG.TR("fTnDg", MethodHandles.lookup(), "TR", rq.class, 2590011195934186765L, 8203726847241526675L, 2879958647116773852L, 20)), (double)( /* dynamic constant */ (Object)feG.TR("ToMH", MethodHandles.lookup(), "TR", rq.class, -1994723523107370396L, 3527960258975432644L, 5919078601824369756L, 32)));
    }
}
