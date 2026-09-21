/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.Text
 *  net.minecraft.DrawContext
 *  net.minecraft.ChatScreen
 *  net.minecraft.Screen
 *  org.spongepowered.asm.mixin.Mixin
 *  org.spongepowered.asm.mixin.Unique
 *  org.spongepowered.asm.mixin.injection.At
 *  org.spongepowered.asm.mixin.injection.Inject
 *  org.spongepowered.asm.mixin.injection.callback.CallbackInfo
 *  org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable
 */
package CLASSESS.M;

import CLASSESS.LAx;
import CLASSESS.UF;
import CLASSESS.Yj;
import CLASSESS.feG;
import CLASSESS.imu;
import CLASSESS.lnURa;
import java.lang.invoke.MethodHandles;
import java.util.List;
import net.minecraft.Text;
import net.minecraft.DrawContext;
import net.minecraft.ChatScreen;
import net.minecraft.Screen;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

/*
 * Uses jvm11+ dynamic constants - pseudocode provided - see https://www.benf.org/other/cfr/dynamic-constants.html
 */
@Mixin(value={ChatScreen.class})
public class CJYYzN
extends Screen
implements lnURa {
    @Unique
    List<Yj> draggable = LAx.Gh().getDraggableRepository().draggable();

    protected CJYYzN() {
        super((Text)Text.method_43473());
    }

    @Inject(method={"render"}, at={@At(value="HEAD")})
    private void onRender(DrawContext class_3322, int n, int n2, float f, CallbackInfo callbackInfo) {
        for (int i = this.draggable.size() - ( /* dynamic constant */ (Object)feG.ZQ("CgwuFT", MethodHandles.lookup(), "ZQ", CJYYzN.class, -1708801831, -650317372, -245625203, 12)); i >= 0; i += ( /* dynamic constant */ (Object)feG.ZQ("LeEz", MethodHandles.lookup(), "ZQ", CJYYzN.class, 1291810825, -904765938, -1570979697, 27))) {
            Yj yj = this.draggable.get(i);
            try {
                if (!yj.canDraw(yj) || !yj.isDragging()) continue;
                yj.render(class_3322, n, n2, f);
                break;
            }
            catch (Throwable throwable) {
                // empty catch block
            }
        }
    }

    @Inject(method={"mouseClicked"}, at={@At(value="HEAD")}, cancellable=true)
    private void onMouseClicked(double d, double d2, int n, CallbackInfoReturnable<Boolean> callbackInfoReturnable) {
        for (Yj yj : this.draggable) {
            if (!yj.canDraw(yj) || !yj.mouseClicked(d, d2, n)) continue;
            callbackInfoReturnable.setReturnValue((Object)((boolean)( /* dynamic constant */ (Object)feG.ZQ("CgwuFT", MethodHandles.lookup(), "ZQ", CJYYzN.class, -1708801831, -650317372, -245625203, 12))));
            return;
        }
    }

    @Inject(method={"sendMessage"}, at={@At(value="HEAD")})
    private void uVcAM(String string, boolean bl, CallbackInfo callbackInfo) {
        if (string == null || string.isEmpty()) {
            return;
        }
        if (string.startsWith((String)( /* dynamic constant */ (Object)feG.fL("omNIYR", MethodHandles.lookup(), "fL", CJYYzN.class, "m", -1808700840, 588657538, -1093972169, 0)))) {
            return;
        }
        imu.fqA(string);
        UF.xxKYX((String)string);
    }

    public boolean method_25406(double d, double d2, int n) {
        this.draggable.forEach(arg_0 -> CJYYzN.lambda$mouseReleased$0(d, d2, n, arg_0));
        return super.method_25406(d, d2, n);
    }

    private static void lambda$mouseReleased$0(double d, double d2, int n, Yj yj) {
        yj.mouseReleased(d, d2, n);
    }
}
