/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_243
 *  net.minecraft.class_4063
 *  net.minecraft.class_4184
 *  net.minecraft.class_5294
 *  net.minecraft.class_5294$class_5401
 *  net.minecraft.class_761
 *  net.minecraft.class_9909
 *  net.minecraft.class_9925
 *  net.minecraft.class_9958
 *  org.joml.Matrix4f
 *  org.spongepowered.asm.mixin.Mixin
 *  org.spongepowered.asm.mixin.Unique
 *  org.spongepowered.asm.mixin.injection.At
 *  org.spongepowered.asm.mixin.injection.Inject
 *  org.spongepowered.asm.mixin.injection.callback.CallbackInfo
 */
package CLASSESS.M;

import CLASSESS.JTcpX;
import CLASSESS.QHMTVh;
import CLASSESS.feG;
import java.lang.invoke.MethodHandles;
import net.minecraft.class_243;
import net.minecraft.class_4063;
import net.minecraft.class_4184;
import net.minecraft.class_5294;
import net.minecraft.class_761;
import net.minecraft.class_9909;
import net.minecraft.class_9925;
import net.minecraft.class_9958;
import org.joml.Matrix4f;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

/*
 * Uses jvm11+ dynamic constants - pseudocode provided - see https://www.benf.org/other/cfr/dynamic-constants.html
 */
@Mixin(value={class_761.class})
public abstract class UMZytA {
    @Inject(method={"method_62215"}, at={@At(value="RETURN")})
    private void void$afterSkyDrawn(class_9958 class_99582, class_5294.class_5401 class_54012, float f, class_5294 class_52942, CallbackInfo callbackInfo) {
        try {
            JTcpX jTcpX = JTcpX.TxV();
            if (jTcpX != null && jTcpX.shouldRenderSky()) {
                jTcpX.renderSkyShader();
            }
        }
        catch (Throwable throwable) {
            // empty catch block
        }
    }

    @Inject(method={"renderClouds"}, at={@At(value="HEAD")}, cancellable=true)
    private void FUWGgt(class_9909 class_99092, Matrix4f matrix4f, Matrix4f matrix4f2, class_4063 class_40632, class_243 class_2432, float f, int n, float f2, CallbackInfo callbackInfo) {
        if (UMZytA.void$skyShadersActive() || UMZytA.void$noRender((String)( /* dynamic constant */ (Object)feG.fL("eIyx", MethodHandles.lookup(), "fL", UMZytA.class, "\u008e\u0018\u00d0\u0093M#", -897539879, 271713094, 59275219, 2)))) {
            callbackInfo.cancel();
        }
    }

    @Inject(method={"method_62205"}, at={@At(value="HEAD")}, cancellable=true)
    private void void$skipCloudsDraw(class_9925<?> class_99252, int n, class_4063 class_40632, float f, Matrix4f matrix4f, Matrix4f matrix4f2, class_243 class_2432, float f2, CallbackInfo callbackInfo) {
        if (UMZytA.void$skyShadersActive() || UMZytA.void$noRender((String)( /* dynamic constant */ (Object)feG.fL("iBdmt", MethodHandles.lookup(), "fL", UMZytA.class, "0\u00a6n-\u00f3\u009d", -1086813836, -409989248, 682469588, 2)))) {
            callbackInfo.cancel();
        }
    }

    @Inject(method={"renderWeather"}, at={@At(value="HEAD")}, cancellable=true)
    private void oqmVjK(class_9909 class_99092, class_243 class_2432, float f, class_9958 class_99582, CallbackInfo callbackInfo) {
        if (UMZytA.void$noRender((String)( /* dynamic constant */ (Object)feG.fL("ZcC", MethodHandles.lookup(), "fL", UMZytA.class, ",\u00ff\u00d8\u00ac\u009fsG", 1625093750, -1533379973, -501152022, 0)))) {
            callbackInfo.cancel();
        }
    }

    @Inject(method={"addWeatherParticlesAndSound"}, at={@At(value="HEAD")}, cancellable=true)
    private void void$skipWeatherParticles(class_4184 class_41842, CallbackInfo callbackInfo) {
        if (UMZytA.void$noRender((String)( /* dynamic constant */ (Object)feG.fL("dcivjy", MethodHandles.lookup(), "fL", UMZytA.class, "/\u00d8\u0001\u00c63Ui", -683575035, -1267242605, 2121757483, 1)))) {
            callbackInfo.cancel();
        }
    }

    @Unique
    private static boolean void$skyShadersActive() {
        JTcpX jTcpX = JTcpX.TxV();
        return (boolean)(jTcpX != null && jTcpX.shouldRenderSky() ? ( /* dynamic constant */ (Object)feG.ZQ("ZyXtHv", MethodHandles.lookup(), "ZQ", UMZytA.class, -1570276951, -1796887529, -669198047, 28)) : ( /* dynamic constant */ (Object)feG.ZQ("poUaW", MethodHandles.lookup(), "ZQ", UMZytA.class, -498621084, 1315458451, -1557676369, 7)));
    }

    @Unique
    private static boolean void$noRender(String string) {
        QHMTVh qHMTVh = QHMTVh.rrLUn();
        return (boolean)(qHMTVh != null && qHMTVh.shouldHide(string) ? ( /* dynamic constant */ (Object)feG.ZQ("ZyXtHv", MethodHandles.lookup(), "ZQ", UMZytA.class, -1570276951, -1796887529, -669198047, 28)) : ( /* dynamic constant */ (Object)feG.ZQ("poUaW", MethodHandles.lookup(), "ZQ", UMZytA.class, -498621084, 1315458451, -1557676369, 7)));
    }
}
