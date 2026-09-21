/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.DrawContext
 *  net.minecraft.Screen
 *  org.spongepowered.asm.mixin.Mixin
 *  org.spongepowered.asm.mixin.Unique
 *  org.spongepowered.asm.mixin.injection.At
 *  org.spongepowered.asm.mixin.injection.Inject
 *  org.spongepowered.asm.mixin.injection.Redirect
 *  org.spongepowered.asm.mixin.injection.callback.CallbackInfo
 */
package CLASSESS.M;

import CLASSESS.AGlrB;
import CLASSESS.bjk;
import CLASSESS.feG;
import java.lang.invoke.MethodHandles;
import net.minecraft.DrawContext;
import net.minecraft.Screen;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.Redirect;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

/*
 * Uses jvm11+ dynamic constants - pseudocode provided - see https://www.benf.org/other/cfr/dynamic-constants.html
 */
@Mixin(value={Screen.class})
public class hjmKN {
    @Unique
    private boolean vd$customBackground;

    @Inject(method={"render"}, at={@At(value="HEAD")})
    private void vd$renderCustomBackground(DrawContext class_3322, int n, int n2, float f, CallbackInfo callbackInfo) {
        if (this instanceof bjk || this instanceof AGlrB) {
            this.vd$customBackground =  /* dynamic constant */ (Object)feG.ZQ("IDCXc", MethodHandles.lookup(), "ZQ", hjmKN.class, -1465329011, -1524397954, 1007555913, 6);
            return;
        }
        this.vd$customBackground =  /* dynamic constant */ (Object)feG.ZQ("AdQu", MethodHandles.lookup(), "ZQ", hjmKN.class, -1958021271, -888225138, -254578944, 22);
    }

    @Redirect(method={"render"}, at=@At(value="INVOKE", target="Lnet/minecraft/client/gui/screen/Screen;renderBackground(Lnet/minecraft/client/gui/DrawContext;IIF)V"))
    private void JgRUZg(Screen class_4372, DrawContext class_3322, int n, int n2, float f) {
        if (!this.vd$customBackground) {
            class_4372.method_25420(class_3322, n, n2, f);
        }
    }
}
