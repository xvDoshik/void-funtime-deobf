/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.Text
 *  net.minecraft.Style
 *  net.minecraft.MinecraftClient
 *  net.minecraft.TextRenderer
 *  net.minecraft.DrawContext
 *  net.minecraft.MatrixStack
 *  net.minecraft.OrderedText
 *  org.spongepowered.asm.mixin.Mixin
 *  org.spongepowered.asm.mixin.Shadow
 *  org.spongepowered.asm.mixin.Unique
 *  org.spongepowered.asm.mixin.injection.At
 *  org.spongepowered.asm.mixin.injection.Inject
 *  org.spongepowered.asm.mixin.injection.callback.CallbackInfo
 *  org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable
 */
package CLASSESS;

import CLASSESS.Xb;
import CLASSESS.feG;
import CLASSESS.lnURa;
import CLASSESS.nZcHI;
import CLASSESS.upGW;
import java.lang.invoke.MethodHandles;
import net.minecraft.Text;
import net.minecraft.Style;
import net.minecraft.MinecraftClient;
import net.minecraft.TextRenderer;
import net.minecraft.DrawContext;
import net.minecraft.MatrixStack;
import net.minecraft.OrderedText;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

/*
 * Uses jvm11+ dynamic constants - pseudocode provided - see https://www.benf.org/other/cfr/dynamic-constants.html
 */
@Mixin(value={DrawContext.class})
public abstract class ItvQE
implements lnURa {
    @Unique
    private static final nZcHI VD$SCREEN_FONT = Xb.qa(13, upGW.DEFAULT);

    @Shadow
    public abstract MatrixStack method_51448();

    @Inject(method={"drawCenteredTextWithShadow(Lnet/minecraft/client/font/TextRenderer;Ljava/lang/String;III)V"}, at={@At(value="HEAD")}, cancellable=true)
    private void vd$drawCenteredString(TextRenderer PackResourceMetadata, String string, int n, int n2, int n3, CallbackInfo callbackInfo) {
        if (!ItvQE.vd$useCustomFont()) {
            return;
        }
        this.vd$drawText(string, (float)n - VD$SCREEN_FONT.getStringWidth(string) * ( /* dynamic constant */ (Object)feG.ZQ("mmFLUj", MethodHandles.lookup(), "ZQ", ItvQE.class, 381852191, -751026843, -64070367, 25)), n2, n3, (boolean)( /* dynamic constant */ (Object)feG.ZQ("pBjst", MethodHandles.lookup(), "ZQ", ItvQE.class, 39430744, 1492726487, -284994879, 15)));
        callbackInfo.cancel();
    }

    @Inject(method={"drawCenteredTextWithShadow(Lnet/minecraft/client/font/TextRenderer;Lnet/minecraft/text/Text;III)V"}, at={@At(value="HEAD")}, cancellable=true)
    private void vd$drawCenteredText(TextRenderer PackResourceMetadata, Text class_25612, int n, int n2, int n3, CallbackInfo callbackInfo) {
        if (!ItvQE.vd$useCustomFont()) {
            return;
        }
        String string = class_25612.getString();
        this.vd$drawText(string, (float)n - VD$SCREEN_FONT.getStringWidth(string) * ( /* dynamic constant */ (Object)feG.ZQ("mmFLUj", MethodHandles.lookup(), "ZQ", ItvQE.class, 381852191, -751026843, -64070367, 25)), n2, n3, (boolean)( /* dynamic constant */ (Object)feG.ZQ("pBjst", MethodHandles.lookup(), "ZQ", ItvQE.class, 39430744, 1492726487, -284994879, 15)));
        callbackInfo.cancel();
    }

    @Inject(method={"drawCenteredTextWithShadow(Lnet/minecraft/client/font/TextRenderer;Lnet/minecraft/text/OrderedText;III)V"}, at={@At(value="HEAD")}, cancellable=true)
    private void vd$drawCenteredOrdered(TextRenderer PackResourceMetadata, OrderedText class_54812, int n, int n2, int n3, CallbackInfo callbackInfo) {
        if (!ItvQE.vd$useCustomFont()) {
            return;
        }
        String string = ItvQE.vd$plainText(class_54812);
        this.vd$drawText(string, (float)n - VD$SCREEN_FONT.getStringWidth(string) * ( /* dynamic constant */ (Object)feG.ZQ("mmFLUj", MethodHandles.lookup(), "ZQ", ItvQE.class, 381852191, -751026843, -64070367, 25)), n2, n3, (boolean)( /* dynamic constant */ (Object)feG.ZQ("pBjst", MethodHandles.lookup(), "ZQ", ItvQE.class, 39430744, 1492726487, -284994879, 15)));
        callbackInfo.cancel();
    }

    @Inject(method={"drawTextWithShadow(Lnet/minecraft/client/font/TextRenderer;Ljava/lang/String;III)I"}, at={@At(value="HEAD")}, cancellable=true)
    private void vd$drawStringShadow(TextRenderer PackResourceMetadata, String string, int n, int n2, int n3, CallbackInfoReturnable<Integer> callbackInfoReturnable) {
        if (!ItvQE.vd$useCustomFont()) {
            return;
        }
        callbackInfoReturnable.setReturnValue((Object)this.vd$drawText(string, n, n2, n3, (boolean)( /* dynamic constant */ (Object)feG.ZQ("pBjst", MethodHandles.lookup(), "ZQ", ItvQE.class, 39430744, 1492726487, -284994879, 15))));
    }

    @Inject(method={"drawTextWithShadow(Lnet/minecraft/client/font/TextRenderer;Lnet/minecraft/text/Text;III)I"}, at={@At(value="HEAD")}, cancellable=true)
    private void vd$drawTextShadow(TextRenderer PackResourceMetadata, Text class_25612, int n, int n2, int n3, CallbackInfoReturnable<Integer> callbackInfoReturnable) {
        if (!ItvQE.vd$useCustomFont()) {
            return;
        }
        callbackInfoReturnable.setReturnValue((Object)this.vd$drawText(class_25612.getString(), n, n2, n3, (boolean)( /* dynamic constant */ (Object)feG.ZQ("pBjst", MethodHandles.lookup(), "ZQ", ItvQE.class, 39430744, 1492726487, -284994879, 15))));
    }

    @Inject(method={"drawTextWithShadow(Lnet/minecraft/client/font/TextRenderer;Lnet/minecraft/text/OrderedText;III)I"}, at={@At(value="HEAD")}, cancellable=true)
    private void vd$drawOrderedShadow(TextRenderer PackResourceMetadata, OrderedText class_54812, int n, int n2, int n3, CallbackInfoReturnable<Integer> callbackInfoReturnable) {
        if (!ItvQE.vd$useCustomFont()) {
            return;
        }
        callbackInfoReturnable.setReturnValue((Object)this.vd$drawText(ItvQE.vd$plainText(class_54812), n, n2, n3, (boolean)( /* dynamic constant */ (Object)feG.ZQ("pBjst", MethodHandles.lookup(), "ZQ", ItvQE.class, 39430744, 1492726487, -284994879, 15))));
    }

    @Inject(method={"drawText(Lnet/minecraft/client/font/TextRenderer;Ljava/lang/String;IIIZ)I"}, at={@At(value="HEAD")}, cancellable=true)
    private void vd$drawString(TextRenderer PackResourceMetadata, String string, int n, int n2, int n3, boolean bl, CallbackInfoReturnable<Integer> callbackInfoReturnable) {
        if (!ItvQE.vd$useCustomFont()) {
            return;
        }
        callbackInfoReturnable.setReturnValue((Object)this.vd$drawText(string, n, n2, n3, bl));
    }

    @Inject(method={"drawText(Lnet/minecraft/client/font/TextRenderer;Lnet/minecraft/text/OrderedText;IIIZ)I"}, at={@At(value="HEAD")}, cancellable=true)
    private void vd$drawOrdered(TextRenderer PackResourceMetadata, OrderedText class_54812, int n, int n2, int n3, boolean bl, CallbackInfoReturnable<Integer> callbackInfoReturnable) {
        if (!ItvQE.vd$useCustomFont()) {
            return;
        }
        callbackInfoReturnable.setReturnValue((Object)this.vd$drawText(ItvQE.vd$plainText(class_54812), n, n2, n3, bl));
    }

    @Inject(method={"drawText(Lnet/minecraft/client/font/TextRenderer;Lnet/minecraft/text/Text;IIIZ)I"}, at={@At(value="HEAD")}, cancellable=true)
    private void vd$drawTextDirect(TextRenderer PackResourceMetadata, Text class_25612, int n, int n2, int n3, boolean bl, CallbackInfoReturnable<Integer> callbackInfoReturnable) {
        if (!ItvQE.vd$useCustomFont()) {
            return;
        }
        callbackInfoReturnable.setReturnValue((Object)this.vd$drawText(class_25612.getString(), n, n2, n3, bl));
    }

    @Unique
    private static boolean vd$useCustomFont() {
        MinecraftClient class_3102 = MinecraftClient.method_1551();
        return (boolean)(class_3102 != null && class_3102.field_1755 != null && !class_3102.field_1755.getClass().getName().startsWith((String)( /* dynamic constant */ (Object)feG.fL("CsppdH", MethodHandles.lookup(), "fL", ItvQE.class, "\u00faK\u00cb\u00da\u001ca\u00ae\u00ea68\u00db\u0000\u0015", -296309611, -384730510, 417200621, 2))) ? ( /* dynamic constant */ (Object)feG.ZQ("pBjst", MethodHandles.lookup(), "ZQ", ItvQE.class, 39430744, 1492726487, -284994879, 15)) : ( /* dynamic constant */ (Object)feG.ZQ("CMY", MethodHandles.lookup(), "ZQ", ItvQE.class, -907738892, 1950262366, 1452896857, 30)));
    }

    @Unique
    private int vd$drawText(String string, float f, float f2, int n, boolean bl) {
        int n2 = (n & ( /* dynamic constant */ (Object)feG.ZQ("pvJoGK", MethodHandles.lookup(), "ZQ", ItvQE.class, 1945163099, -1487832453, -1678059770, 29))) == 0 ? n | ( /* dynamic constant */ (Object)feG.ZQ("pvJoGK", MethodHandles.lookup(), "ZQ", ItvQE.class, 1945163099, -1487832453, -1678059770, 29)) : n;
        int n3 = n2 >>> ( /* dynamic constant */ (Object)feG.ZQ("LSfQKX", MethodHandles.lookup(), "ZQ", ItvQE.class, 347330226, -1048977481, 1054829183, 19));
        if (bl) {
            int n4 = Math.round((float)n3 * ( /* dynamic constant */ (Object)feG.ZQ("GWWd", MethodHandles.lookup(), "ZQ", ItvQE.class, -1126373084, -691112226, -219601406, 31))) << ( /* dynamic constant */ (Object)feG.ZQ("LSfQKX", MethodHandles.lookup(), "ZQ", ItvQE.class, 347330226, -1048977481, 1054829183, 19));
            VD$SCREEN_FONT.drawStringWithWeight(this.method_51448(), string, f + ( /* dynamic constant */ (Object)feG.ZQ("jSUVkN", MethodHandles.lookup(), "ZQ", ItvQE.class, -809382942, -1481025995, -1626151545, 30)), f2 + ( /* dynamic constant */ (Object)feG.ZQ("wyFKGF", MethodHandles.lookup(), "ZQ", ItvQE.class, -784059073, 1791838652, 1293540270, 6)), n4, (float)( /* dynamic constant */ (Object)feG.ZQ("YUdWoF", MethodHandles.lookup(), "ZQ", ItvQE.class, -76683951, -478361150, 873784180, 8)));
        }
        VD$SCREEN_FONT.drawStringWithWeight(this.method_51448(), string, f, f2 + ( /* dynamic constant */ (Object)feG.ZQ("kYC", MethodHandles.lookup(), "ZQ", ItvQE.class, -1538083322, 1913315809, 33560398, 12)), n2, (float)( /* dynamic constant */ (Object)feG.ZQ("YUdWoF", MethodHandles.lookup(), "ZQ", ItvQE.class, -76683951, -478361150, 873784180, 8)));
        return Math.round(f + VD$SCREEN_FONT.getStringWidth(string));
    }

    @Unique
    private static String vd$plainText(OrderedText class_54812) {
        StringBuilder stringBuilder = new StringBuilder();
        class_54812.accept((arg_0, arg_1, arg_2) -> ItvQE.bG(stringBuilder, arg_0, arg_1, arg_2));
        return stringBuilder.toString();
    }

    private static boolean bG(StringBuilder stringBuilder, int n, Style class_25832, int n2) {
        stringBuilder.appendCodePoint(n2);
        return true;
    }
}
