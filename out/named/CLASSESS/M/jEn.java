/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.DrawContext
 *  net.minecraft.BossBarHud
 *  org.spongepowered.asm.mixin.Mixin
 *  org.spongepowered.asm.mixin.injection.At
 *  org.spongepowered.asm.mixin.injection.Inject
 *  org.spongepowered.asm.mixin.injection.callback.CallbackInfo
 */
package CLASSESS.M;

import CLASSESS.QHMTVh;
import CLASSESS.feG;
import java.lang.invoke.MethodHandles;
import net.minecraft.DrawContext;
import net.minecraft.BossBarHud;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

/*
 * Uses jvm11+ dynamic constants - pseudocode provided - see https://www.benf.org/other/cfr/dynamic-constants.html
 */
@Mixin(value={BossBarHud.class})
public class jEn {
    @Inject(method={"render"}, at={@At(value="HEAD")}, cancellable=true)
    private void HR(DrawContext class_3322, CallbackInfo callbackInfo) {
        try {
            QHMTVh qHMTVh = QHMTVh.rrLUn();
            if (qHMTVh != null && qHMTVh.shouldHide((String)( /* dynamic constant */ (Object)feG.fL("nvZhO", MethodHandles.lookup(), "fL", jEn.class, "\u00c8\u00c6\u00bb\u0094&g%\u0011", -1670456521, -1051272774, 2044916145, 0)))) {
                callbackInfo.cancel();
            }
        }
        catch (Throwable throwable) {
            // empty catch block
        }
    }
}
