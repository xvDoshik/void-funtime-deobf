/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.MinecraftClient
 *  net.minecraft.MatrixStack
 *  net.minecraft.VertexConsumerProvider
 *  net.minecraft.InGameOverlayRenderer
 *  org.spongepowered.asm.mixin.Mixin
 *  org.spongepowered.asm.mixin.injection.At
 *  org.spongepowered.asm.mixin.injection.Inject
 *  org.spongepowered.asm.mixin.injection.callback.CallbackInfo
 */
package CLASSESS.M;

import CLASSESS.QHMTVh;
import CLASSESS.feG;
import java.lang.invoke.MethodHandles;
import net.minecraft.MinecraftClient;
import net.minecraft.MatrixStack;
import net.minecraft.VertexConsumerProvider;
import net.minecraft.InGameOverlayRenderer;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

/*
 * Uses jvm11+ dynamic constants - pseudocode provided - see https://www.benf.org/other/cfr/dynamic-constants.html
 */
@Mixin(value={InGameOverlayRenderer.class})
public class WeuFmN {
    @Inject(method={"renderFireOverlay"}, at={@At(value="HEAD")}, cancellable=true)
    private static void rWmO(MatrixStack class_45872, VertexConsumerProvider class_45972, CallbackInfo callbackInfo) {
        try {
            QHMTVh qHMTVh = QHMTVh.rrLUn();
            if (qHMTVh != null && qHMTVh.shouldHide((String)( /* dynamic constant */ (Object)feG.fL("vK", MethodHandles.lookup(), "fL", WeuFmN.class, "-\u00e3\u00db\u00ad", -1185160480, 356417583, 239647043, 0)))) {
                callbackInfo.cancel();
            }
        }
        catch (Throwable throwable) {
            // empty catch block
        }
    }

    @Inject(method={"renderUnderwaterOverlay"}, at={@At(value="HEAD")}, cancellable=true)
    private static void YnB(MinecraftClient class_3102, MatrixStack class_45872, VertexConsumerProvider class_45972, CallbackInfo callbackInfo) {
        try {
            QHMTVh qHMTVh = QHMTVh.rrLUn();
            if (qHMTVh != null && qHMTVh.shouldHide((String)( /* dynamic constant */ (Object)feG.fL("UZxn", MethodHandles.lookup(), "fL", WeuFmN.class, "\u008d\u008f\u008c\u001b3", 892161405, 1216297670, -1081462374, 1)))) {
                callbackInfo.cancel();
            }
        }
        catch (Throwable throwable) {
            // empty catch block
        }
    }
}
