/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.llamalad7.mixinextras.sugar.Local
 *  com.mojang.blaze3d.systems.RenderSystem
 *  net.minecraft.MinecraftClient
 *  net.minecraft.Camera
 *  net.minecraft.MatrixStack
 *  net.minecraft.GameRenderer
 *  net.minecraft.RenderTickCounter
 *  org.joml.Matrix4f
 *  org.joml.Matrix4fc
 *  org.spongepowered.asm.mixin.Final
 *  org.spongepowered.asm.mixin.Mixin
 *  org.spongepowered.asm.mixin.Shadow
 *  org.spongepowered.asm.mixin.injection.At
 *  org.spongepowered.asm.mixin.injection.Inject
 *  org.spongepowered.asm.mixin.injection.callback.CallbackInfo
 *  org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable
 */
package CLASSESS.M;

import CLASSESS.KgEPmp;
import CLASSESS.QHMTVh;
import CLASSESS.SuxXFL;
import CLASSESS.TUagLH;
import CLASSESS.Up;
import CLASSESS.ZlooG;
import CLASSESS.feG;
import CLASSESS.rNWiQ;
import com.llamalad7.mixinextras.sugar.Local;
import com.mojang.blaze3d.systems.RenderSystem;
import java.lang.invoke.MethodHandles;
import net.minecraft.MinecraftClient;
import net.minecraft.Camera;
import net.minecraft.MatrixStack;
import net.minecraft.GameRenderer;
import net.minecraft.RenderTickCounter;
import org.joml.Matrix4f;
import org.joml.Matrix4fc;
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
@Mixin(value={GameRenderer.class}, priority=1001)
public abstract class qe {
    @Final
    @Shadow
    private MinecraftClient field_4015;
    @Shadow
    private float field_4005;
    @Shadow
    private float field_3988;
    @Shadow
    private float field_4004;
    @Shadow
    private float field_4025;

    @Inject(method={"renderWorld"}, at={@At(value="FIELD", target="Lnet/minecraft/client/render/GameRenderer;renderHand:Z", opcode=180, ordinal=0)})
    public void hookWorldRender(RenderTickCounter class_97792, CallbackInfo callbackInfo, @Local(ordinal=2) Matrix4f matrix4f) {
        MatrixStack class_45872 = new MatrixStack();
        class_45872.method_34425(matrix4f);
        class_45872.method_61958(this.field_4015.method_1561().field_4686.method_19326().method_22882());
        SuxXFL.eL(RenderSystem.getProjectionMatrix());
        SuxXFL.EA(class_45872.method_23760());
        rNWiQ.fsG();
        KgEPmp kgEPmp = new KgEPmp(class_45872, class_97792.method_60637((boolean)( /* dynamic constant */ (Object)feG.ZQ("PdPzx", MethodHandles.lookup(), "ZQ", qe.class, -18115157, 564006822, -1164243957, 31))));
        TUagLH.pd();
        Up.vh(kgEPmp);
        SuxXFL.mrDih();
    }

    @Inject(method={"getBasicProjectionMatrix"}, at={@At(value="TAIL")}, cancellable=true)
    public void getBasicProjectionMatrixHook(float f, CallbackInfoReturnable<Matrix4f> callbackInfoReturnable) {
        ZlooG zlooG = ZlooG.UQ();
        if (zlooG == null || !zlooG.isEnabled()) {
            return;
        }
        MatrixStack class_45872 = new MatrixStack();
        class_45872.method_23760().method_23761().identity();
        float f2 = zlooG.getRatio();
        if (this.field_4005 != ( /* dynamic constant */ (Object)feG.ZQ("zlhakz", MethodHandles.lookup(), "ZQ", qe.class, -1139998819, 1989888606, -1967176335, 16))) {
            class_45872.method_46416(this.field_3988, -this.field_4004, (float)( /* dynamic constant */ (Object)feG.ZQ("QgIMiT", MethodHandles.lookup(), "ZQ", qe.class, 2143012727, -816134392, 2105739267, 5)));
            class_45872.method_22905(this.field_4005, this.field_4005, (float)( /* dynamic constant */ (Object)feG.ZQ("zlhakz", MethodHandles.lookup(), "ZQ", qe.class, -1139998819, 1989888606, -1967176335, 16)));
        }
        class_45872.method_23760().method_23761().mul((Matrix4fc)new Matrix4f().setPerspective((float)((double)f * ( /* dynamic constant */ (Object)feG.TR("iYh", MethodHandles.lookup(), "TR", qe.class, 5305765393283878872L, 7174022801144875394L, 5239096587921720691L, 46))), f2, (float)( /* dynamic constant */ (Object)feG.ZQ("VPuT", MethodHandles.lookup(), "ZQ", qe.class, -1967443348, 96832721, 883394554, 31)), this.field_4025 * ( /* dynamic constant */ (Object)feG.ZQ("lBjf", MethodHandles.lookup(), "ZQ", qe.class, 1988365160, -1464745062, -618360931, 31))));
        callbackInfoReturnable.setReturnValue((Object)class_45872.method_23760().method_23761());
    }

    @Inject(method={"getFov"}, at={@At(value="RETURN")}, cancellable=true)
    private void K(Camera class_41842, float f, boolean bl, CallbackInfoReturnable<Float> callbackInfoReturnable) {
        callbackInfoReturnable.setReturnValue((Object)Float.valueOf(TUagLH.BG(callbackInfoReturnable.getReturnValueF())));
    }

    @Inject(method={"tiltViewWhenHurt"}, at={@At(value="HEAD")}, cancellable=true)
    private void maDWe(MatrixStack class_45872, float f, CallbackInfo callbackInfo) {
        try {
            QHMTVh qHMTVh = QHMTVh.rrLUn();
            if (qHMTVh != null && qHMTVh.shouldHide((String)( /* dynamic constant */ (Object)feG.fL("Zvb", MethodHandles.lookup(), "fL", qe.class, "\u00bd\u000eM\u00d5\u00f3/X\u00cd", -916761631, -772933351, -1471133772, 1)))) {
                callbackInfo.cancel();
            }
        }
        catch (Throwable throwable) {
            // empty catch block
        }
    }
}
