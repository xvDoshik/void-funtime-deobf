/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.Keyboard
 *  net.minecraft.MinecraftClient
 *  net.minecraft.InputUtil$class_307
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
import CLASSESS.Up;
import CLASSESS.aq;
import CLASSESS.bjk;
import CLASSESS.feG;
import CLASSESS.iB;
import java.lang.invoke.MethodHandles;
import net.minecraft.Keyboard;
import net.minecraft.MinecraftClient;
import net.minecraft.InputUtil;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

/*
 * Uses jvm11+ dynamic constants - pseudocode provided - see https://www.benf.org/other/cfr/dynamic-constants.html
 */
@Mixin(value={Keyboard.class})
public class Pd {
    @Final
    @Shadow
    private MinecraftClient field_1678;

    @Inject(method={"onKey"}, at={@At(value="HEAD")})
    private void onKey(long l, int n, int n2, int n3, int n4, CallbackInfo callbackInfo) {
        if (n != ( /* dynamic constant */ (Object)feG.ZQ("zgFnG", MethodHandles.lookup(), "ZQ", Pd.class, 1008829810, 829659920, 1005233195, 7)) && l == this.field_1678.method_22683().method_4490()) {
            Object object = this.field_1678.field_1755 != null || Pd.isChatFocused(this.field_1678) ? ( /* dynamic constant */ (Object)feG.ZQ("bli", MethodHandles.lookup(), "ZQ", Pd.class, -1583062997, 497462460, -606011539, 10)) : ( /* dynamic constant */ (Object)feG.ZQ("aEkR", MethodHandles.lookup(), "ZQ", Pd.class, -395838323, 927457013, -866611186, 9));
            Nmc nmc = Nmc.VxeOIR();
            if (n3 == ( /* dynamic constant */ (Object)feG.ZQ("bli", MethodHandles.lookup(), "ZQ", Pd.class, -1583062997, 497462460, -606011539, 10)) && n != ( /* dynamic constant */ (Object)feG.ZQ("zgFnG", MethodHandles.lookup(), "ZQ", Pd.class, 1008829810, 829659920, 1005233195, 7)) && n >= 0 && object == false) {
                if (aq.PO(n, (boolean)( /* dynamic constant */ (Object)feG.ZQ("aEkR", MethodHandles.lookup(), "ZQ", Pd.class, -395838323, 927457013, -866611186, 9)))) {
                    return;
                }
                if (nmc != null) {
                    if (n == nmc.getMenuKey()) {
                        bjk.INSTANCE.openGui();
                    } else {
                        if (Pd.isBound(nmc.getQuickShellKey()) && n == nmc.getQuickShellKey()) {
                            aq.WT();
                            return;
                        }
                        if (Pd.isBound(nmc.getBanTargetKey()) && n == nmc.getBanTargetKey()) {
                            Nmc.Vy();
                        } else if (Pd.isBound(nmc.getReviseTargetKey()) && n == nmc.getReviseTargetKey()) {
                            Nmc.atv();
                        } else if (Pd.isBound(nmc.getDetachTargetKey()) && n == nmc.getDetachTargetKey()) {
                            Nmc.PlEr();
                        }
                    }
                }
                QtySoD.tc(n, n3);
                Pb.Bb((int)n, (int)n3);
            }
            Up.vh((SyBEH)((Object)new iB(this.field_1678.field_1755, InputUtil.class_307.field_1668, n, n3)));
        }
    }

    private static boolean isChatFocused(MinecraftClient class_3102) {
        try {
            return (boolean)(class_3102 != null && class_3102.field_1705 != null && class_3102.field_1705.method_1743() != null && class_3102.field_1705.method_1743().method_1819() ? ( /* dynamic constant */ (Object)feG.ZQ("bli", MethodHandles.lookup(), "ZQ", Pd.class, -1583062997, 497462460, -606011539, 10)) : ( /* dynamic constant */ (Object)feG.ZQ("aEkR", MethodHandles.lookup(), "ZQ", Pd.class, -395838323, 927457013, -866611186, 9)));
        }
        catch (Throwable throwable) {
            return (boolean)( /* dynamic constant */ (Object)feG.ZQ("aEkR", MethodHandles.lookup(), "ZQ", Pd.class, -395838323, 927457013, -866611186, 9));
        }
    }

    private static boolean isBound(int n) {
        return (boolean)(n >= 0 && n != ( /* dynamic constant */ (Object)feG.ZQ("zgFnG", MethodHandles.lookup(), "ZQ", Pd.class, 1008829810, 829659920, 1005233195, 7)) ? ( /* dynamic constant */ (Object)feG.ZQ("bli", MethodHandles.lookup(), "ZQ", Pd.class, -1583062997, 497462460, -606011539, 10)) : ( /* dynamic constant */ (Object)feG.ZQ("aEkR", MethodHandles.lookup(), "ZQ", Pd.class, -395838323, 927457013, -866611186, 9)));
    }
}
