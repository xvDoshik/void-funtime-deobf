/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.StatusEffects
 *  net.minecraft.Entity
 *  net.minecraft.LivingEntity
 *  net.minecraft.Camera
 *  net.minecraft.CameraSubmersionType
 *  net.minecraft.ClientWorld
 *  net.minecraft.FogShape
 *  net.minecraft.BackgroundRenderer
 *  net.minecraft.BackgroundRenderer$class_4596
 *  net.minecraft.Fog
 *  org.joml.Vector4f
 *  org.spongepowered.asm.mixin.Mixin
 *  org.spongepowered.asm.mixin.Unique
 *  org.spongepowered.asm.mixin.injection.At
 *  org.spongepowered.asm.mixin.injection.Inject
 *  org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable
 */
package CLASSESS.M;

import CLASSESS.SyBEH;
import CLASSESS.Up;
import CLASSESS.feG;
import CLASSESS.sV;
import CLASSESS.uShSb;
import java.lang.invoke.MethodHandles;
import net.minecraft.StatusEffects;
import net.minecraft.Entity;
import net.minecraft.LivingEntity;
import net.minecraft.Camera;
import net.minecraft.CameraSubmersionType;
import net.minecraft.ClientWorld;
import net.minecraft.FogShape;
import net.minecraft.BackgroundRenderer;
import net.minecraft.Fog;
import org.joml.Vector4f;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

/*
 * Uses jvm11+ dynamic constants - pseudocode provided - see https://www.benf.org/other/cfr/dynamic-constants.html
 */
@Mixin(value={BackgroundRenderer.class})
public class CNFw {
    @Unique
    private static boolean HuZipb(Camera class_41842, BackgroundRenderer.class_4596 class_45962) {
        if (class_45962 != BackgroundRenderer.class_4596.field_20946) {
            return true;
        }
        CameraSubmersionType class_56362 = class_41842.method_19334();
        if (class_56362 != CameraSubmersionType.field_27888) {
            return true;
        }
        Entity class_12972 = class_41842.method_19331();
        if (class_12972 instanceof LivingEntity) {
            LivingEntity class_13092 = (LivingEntity)class_12972;
            if (class_13092.method_6059(StatusEffects.field_5919)) {
                return true;
            }
            return class_13092.method_6059(StatusEffects.field_38092);
        }
        return false;
    }

    @Inject(method={"getFogColor"}, at={@At(value="HEAD")}, cancellable=true)
    private static void nnWonv(Camera class_41842, float f, ClientWorld NarrationMessageBuilder, int n, float f2, CallbackInfoReturnable<Vector4f> callbackInfoReturnable) {
        if (CNFw.HuZipb(class_41842, BackgroundRenderer.class_4596.field_20946)) {
            return;
        }
        sV sV2 = new sV();
        Up.vh((SyBEH)((Object)sV2));
        if (sV2.isCancelled()) {
            int n2 = sV2.getColor();
            callbackInfoReturnable.setReturnValue((Object)new Vector4f(uShSb.rm(n2), uShSb.fwUgZ(n2), uShSb.xq(n2), uShSb.DF(n2)));
        }
    }

    @Inject(method={"applyFog"}, at={@At(value="HEAD")}, cancellable=true)
    private static void CLqB(Camera class_41842, BackgroundRenderer.class_4596 class_45962, Vector4f vector4f, float f, boolean bl, float f2, CallbackInfoReturnable<Fog> callbackInfoReturnable) {
        if (CNFw.HuZipb(class_41842, class_45962)) {
            return;
        }
        sV sV2 = new sV();
        Up.vh((SyBEH)((Object)sV2));
        if (sV2.isCancelled()) {
            int n = sV2.getColor();
            callbackInfoReturnable.setReturnValue((Object)new Fog((float)( /* dynamic constant */ (Object)feG.Rz("Ui", MethodHandles.lookup(), "Rz", CNFw.class, -133684637, 134399828, 1792573312, 21)), sV2.getDistance(), FogShape.field_36351, uShSb.rm(n), uShSb.fwUgZ(n), uShSb.xq(n), uShSb.DF(n)));
        }
    }
}
