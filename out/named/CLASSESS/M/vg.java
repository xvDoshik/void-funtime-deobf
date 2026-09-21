/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.llamalad7.mixinextras.injector.v2.WrapWithCondition
 *  net.minecraft.MinecraftClient
 *  net.minecraft.Mouse
 *  net.minecraft.InputUtil$class_307
 *  net.minecraft.ClientPlayerEntity
 *  org.spongepowered.asm.mixin.Final
 *  org.spongepowered.asm.mixin.Mixin
 *  org.spongepowered.asm.mixin.Shadow
 *  org.spongepowered.asm.mixin.injection.At
 *  org.spongepowered.asm.mixin.injection.Inject
 *  org.spongepowered.asm.mixin.injection.callback.CallbackInfo
 */
package CLASSESS.M;

import CLASSESS.Nmc;
import CLASSESS.Pb;
import CLASSESS.QtySoD;
import CLASSESS.SyBEH;
import CLASSESS.TUagLH;
import CLASSESS.Up;
import CLASSESS.aq;
import CLASSESS.feG;
import CLASSESS.iB;
import CLASSESS.jRc;
import CLASSESS.o;
import CLASSESS.poecG;
import CLASSESS.rV;
import com.llamalad7.mixinextras.injector.v2.WrapWithCondition;
import java.lang.invoke.MethodHandles;
import net.minecraft.MinecraftClient;
import net.minecraft.Mouse;
import net.minecraft.InputUtil;
import net.minecraft.ClientPlayerEntity;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

/*
 * Uses jvm11+ dynamic constants - pseudocode provided - see https://www.benf.org/other/cfr/dynamic-constants.html
 */
@Mixin(value={Mouse.class})
public class vg {
    @Final
    @Shadow
    private MinecraftClient field_1779;

    @Inject(method={"onMouseButton"}, at={@At(value="HEAD")})
    public void onMouseButtonHook(long l, int n, int n2, int n3, CallbackInfo callbackInfo) {
        if (n != ( /* dynamic constant */ (Object)feG.ZQ("FcJe", MethodHandles.lookup(), "ZQ", vg.class, 90671662, -1315621036, -1247496827, 19)) && n >= 0 && l == this.field_1779.method_22683().method_4490()) {
            if (n2 == ( /* dynamic constant */ (Object)feG.ZQ("XIQuMH", MethodHandles.lookup(), "ZQ", vg.class, 1403239187, 133899195, -1756287311, 31)) && this.field_1779.field_1755 == null) {
                try {
                    if (n == 0) {
                        try {
                            double d = this.field_1779.field_1729.method_1603() * (double)this.field_1779.method_22683().method_4486() / (double)this.field_1779.method_22683().method_4480();
                            double d2 = this.field_1779.field_1729.method_1604() * (double)this.field_1779.method_22683().method_4502() / (double)this.field_1779.method_22683().method_4507();
                            rV rV2 = rV.zi();
                            if (rV2 != null && rV2.mouseClicked(d, d2, n)) {
                                return;
                            }
                        }
                        catch (Throwable throwable) {
                            // empty catch block
                        }
                    }
                    if (aq.PO(n, (boolean)( /* dynamic constant */ (Object)feG.ZQ("XIQuMH", MethodHandles.lookup(), "ZQ", vg.class, 1403239187, 133899195, -1756287311, 31)))) {
                        return;
                    }
                    Nmc nmc = Nmc.VxeOIR();
                    if (nmc != null) {
                        int n4 = nmc.getQuickShellKey();
                        if (vg.isMouseBound(n4) && n4 == n) {
                            aq.WT();
                            return;
                        }
                        if (vg.isMouseBound(nmc.getBanTargetKey()) && nmc.getBanTargetKey() == n) {
                            Nmc.Vy();
                        } else if (vg.isMouseBound(nmc.getReviseTargetKey()) && nmc.getReviseTargetKey() == n) {
                            Nmc.atv();
                        } else if (vg.isMouseBound(nmc.getDetachTargetKey()) && nmc.getDetachTargetKey() == n) {
                            Nmc.PlEr();
                        }
                    }
                    QtySoD.tc(n, n2);
                    Pb.Bb((int)n, (int)n2);
                }
                catch (Throwable throwable) {
                    System.out.println("[Void QA] MouseMixin error: " + String.valueOf(throwable));
                    throwable.printStackTrace();
                }
            }
            Up.vh((SyBEH)((Object)new iB(this.field_1779.field_1755, InputUtil.class_307.field_1672, n, n2)));
        }
    }

    private static boolean isMouseBound(int n) {
        return (boolean)(n >= 0 && n < ( /* dynamic constant */ (Object)feG.ZQ("zb", MethodHandles.lookup(), "ZQ", vg.class, 270410576, -1272967674, -514546249, 20)) && n != ( /* dynamic constant */ (Object)feG.ZQ("FcJe", MethodHandles.lookup(), "ZQ", vg.class, 90671662, -1315621036, -1247496827, 19)) ? ( /* dynamic constant */ (Object)feG.ZQ("XIQuMH", MethodHandles.lookup(), "ZQ", vg.class, 1403239187, 133899195, -1756287311, 31)) : ( /* dynamic constant */ (Object)feG.ZQ("fo", MethodHandles.lookup(), "ZQ", vg.class, 1427291433, -359302889, -1479261914, 28)));
    }

    @Inject(method={"onMouseScroll"}, at={@At(value="INVOKE", target="Lnet/minecraft/client/network/ClientPlayerEntity;getInventory()Lnet/minecraft/entity/player/PlayerInventory;")}, cancellable=true)
    public void onMouseScrollHook(long l, double d, double d2, CallbackInfo callbackInfo) {
        poecG poecG2 = new poecG(d, d2);
        Up.vh((SyBEH)((Object)poecG2));
        if (poecG2.isCancelled()) {
            callbackInfo.cancel();
        }
    }

    @Inject(method={"onMouseScroll"}, at={@At(value="HEAD")}, cancellable=true)
    private void void$cameraScroll(long l, double d, double d2, CallbackInfo callbackInfo) {
        if (l == this.field_1779.method_22683().method_4490() && o.xE() && o.ilmH(d2)) {
            callbackInfo.cancel();
        }
    }

    @WrapWithCondition(method={"updateMouse"}, at={@At(value="INVOKE", target="Lnet/minecraft/client/network/ClientPlayerEntity;changeLookDirection(DD)V")}, require=1, allow=1)
    private boolean modifyMouseRotationInput(ClientPlayerEntity class_7462, double d, double d2) {
        if (TUagLH.fl((float)d, (float)d2)) {
            return (boolean)( /* dynamic constant */ (Object)feG.ZQ("fo", MethodHandles.lookup(), "ZQ", vg.class, 1427291433, -359302889, -1479261914, 28));
        }
        if (o.xE() && o.WczvGU((float)d, (float)d2)) {
            return (boolean)( /* dynamic constant */ (Object)feG.ZQ("fo", MethodHandles.lookup(), "ZQ", vg.class, 1427291433, -359302889, -1479261914, 28));
        }
        jRc jRc2 = new jRc((float)d, (float)d2);
        Up.vh((SyBEH)((Object)jRc2));
        if (jRc2.isCancelled()) {
            return (boolean)( /* dynamic constant */ (Object)feG.ZQ("fo", MethodHandles.lookup(), "ZQ", vg.class, 1427291433, -359302889, -1479261914, 28));
        }
        class_7462.method_5872((double)jRc2.getCursorDeltaX(), (double)jRc2.getCursorDeltaY());
        return (boolean)( /* dynamic constant */ (Object)feG.ZQ("fo", MethodHandles.lookup(), "ZQ", vg.class, 1427291433, -359302889, -1479261914, 28));
    }
}
