/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_3695
 *  net.minecraft.class_4184
 *  net.minecraft.class_4604
 *  net.minecraft.class_761
 *  net.minecraft.class_9779
 *  net.minecraft.class_9909
 *  net.minecraft.class_9958
 *  org.joml.Matrix4f
 *  org.spongepowered.asm.mixin.Mixin
 *  org.spongepowered.asm.mixin.Shadow
 *  org.spongepowered.asm.mixin.injection.At
 *  org.spongepowered.asm.mixin.injection.Redirect
 */
package CLASSESS.M;

import CLASSESS.feG;
import CLASSESS.nx;
import java.lang.invoke.MethodHandles;
import net.minecraft.class_3695;
import net.minecraft.class_4184;
import net.minecraft.class_4604;
import net.minecraft.class_761;
import net.minecraft.class_9779;
import net.minecraft.class_9909;
import net.minecraft.class_9958;
import org.joml.Matrix4f;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

/*
 * Uses jvm11+ dynamic constants - pseudocode provided - see https://www.benf.org/other/cfr/dynamic-constants.html
 */
@Mixin(value={class_761.class})
public abstract class kOLGsi {
    @Shadow
    protected abstract void method_62202(class_9909 var1, class_4604 var2, class_4184 var3, Matrix4f var4, Matrix4f var5, class_9958 var6, boolean var7, boolean var8, class_9779 var9, class_3695 var10);

    @Redirect(method={"render"}, at=@At(value="INVOKE", target="Lnet/minecraft/client/render/WorldRenderer;renderMain(Lnet/minecraft/client/render/FrameGraphBuilder;Lnet/minecraft/client/render/Frustum;Lnet/minecraft/client/render/Camera;Lorg/joml/Matrix4f;Lorg/joml/Matrix4f;Lnet/minecraft/client/render/Fog;ZZLnet/minecraft/client/render/RenderTickCounter;Lnet/minecraft/util/profiler/Profiler;)V"))
    private void onRender(class_761 class_7612, class_9909 class_99092, class_4604 class_46042, class_4184 class_41842, Matrix4f matrix4f, Matrix4f matrix4f2, class_9958 class_99582, boolean bl, boolean bl2, class_9779 class_97792, class_3695 class_36952) {
        nx nx2 = nx.bN();
        Object object = nx2 == null || !nx2.isState() ? ( /* dynamic constant */ (Object)feG.ZQ("WKKnrn", MethodHandles.lookup(), "ZQ", kOLGsi.class, -1239419782, 1335285622, 973655315, 15)) : ( /* dynamic constant */ (Object)feG.ZQ("eamQPf", MethodHandles.lookup(), "ZQ", kOLGsi.class, -904494125, -235518489, 1038932000, 16));
        this.method_62202(class_99092, class_46042, class_41842, matrix4f, matrix4f2, class_99582, (boolean)object, bl2, class_97792, class_36952);
    }
}
