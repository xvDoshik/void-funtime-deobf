/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.GameJoinS2CPacket
 *  net.minecraft.PlaySoundFromEntityS2CPacket
 *  net.minecraft.PlaySoundS2CPacket
 *  net.minecraft.MinecraftClient
 *  net.minecraft.SoundEvent
 *  net.minecraft.ClientPlayNetworkHandler
 *  org.spongepowered.asm.mixin.Mixin
 *  org.spongepowered.asm.mixin.injection.At
 *  org.spongepowered.asm.mixin.injection.Inject
 *  org.spongepowered.asm.mixin.injection.callback.CallbackInfo
 *  org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable
 */
package CLASSESS.M;

import CLASSESS.PLgFi;
import CLASSESS.TUagLH;
import CLASSESS.TfXevN;
import CLASSESS.UF;
import CLASSESS.VyPtW;
import CLASSESS.Xz;
import CLASSESS.bIdOr;
import CLASSESS.bh;
import CLASSESS.dQeKfI;
import CLASSESS.ewa;
import CLASSESS.eyNOkz;
import CLASSESS.fM;
import CLASSESS.feG;
import CLASSESS.imu;
import CLASSESS.o;
import CLASSESS.qCIog;
import CLASSESS.sfTGPQ;
import CLASSESS.wP;
import java.lang.invoke.MethodHandles;
import net.minecraft.GameJoinS2CPacket;
import net.minecraft.PlaySoundFromEntityS2CPacket;
import net.minecraft.PlaySoundS2CPacket;
import net.minecraft.MinecraftClient;
import net.minecraft.SoundEvent;
import net.minecraft.ClientPlayNetworkHandler;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

/*
 * Uses jvm11+ dynamic constants - pseudocode provided - see https://www.benf.org/other/cfr/dynamic-constants.html
 */
@Mixin(value={ClientPlayNetworkHandler.class})
public abstract class Jt {
    @Inject(method={"onGameJoin"}, at={@At(value="RETURN")})
    private void onGameJoin(GameJoinS2CPacket class_26782, CallbackInfo callbackInfo) {
        MinecraftClient class_3102 = MinecraftClient.method_1551();
        if (class_3102.method_1558() != null) {
            String string = class_3102.method_1558().field_3761;
            ewa.FL(string);
        }
        UF.UJ();
        fM.ai().onGameJoin();
    }

    @Inject(method={"onPlaySound"}, at={@At(value="HEAD")}, cancellable=true, require=0)
    private void MB(PlaySoundS2CPacket class_27672, CallbackInfo callbackInfo) {
        boolean bl = dQeKfI.Kxg((SoundEvent)class_27672.method_11894().comp_349());
        if (bl) {
            callbackInfo.cancel();
        }
    }

    @Inject(method={"onPlaySoundFromEntity"}, at={@At(value="HEAD")}, cancellable=true, require=0)
    private void WXQtn(PlaySoundFromEntityS2CPacket class_27652, CallbackInfo callbackInfo) {
        boolean bl = dQeKfI.Kxg((SoundEvent)class_27652.method_11882().comp_349());
        if (bl) {
            callbackInfo.cancel();
        }
    }

    @Inject(method={"sendChatMessage"}, at={@At(value="HEAD")})
    private void Lr(String string, CallbackInfo callbackInfo) {
        try {
            PLgFi.CF(string);
        }
        catch (Throwable throwable) {
            // empty catch block
        }
    }

    @Inject(method={"sendChatCommand"}, at={@At(value="HEAD")}, cancellable=true)
    private void onSendChatCommand(String string, CallbackInfo callbackInfo) {
        if (TfXevN.Eeuoy()) {
            return;
        }
        if (Xz.dx((String)string) && Xz.cG((String)string)) {
            callbackInfo.cancel();
            return;
        }
        if (bIdOr.ek(string)) {
            callbackInfo.cancel();
            return;
        }
        if (bh.GD((String)string)) {
            callbackInfo.cancel();
            return;
        }
        if (VyPtW.KO(string)) {
            callbackInfo.cancel();
            return;
        }
        if (eyNOkz.xi(string)) {
            callbackInfo.cancel();
            return;
        }
        if (eyNOkz.zKd(string)) {
            callbackInfo.cancel();
            return;
        }
        if (eyNOkz.qPHjFP(string)) {
            callbackInfo.cancel();
            return;
        }
        if (qCIog.LX(string)) {
            callbackInfo.cancel();
            return;
        }
        if (qCIog.Hk(string)) {
            callbackInfo.cancel();
            return;
        }
        if (o.eu(string)) {
            callbackInfo.cancel();
            return;
        }
        try {
            TUagLH tUagLH = TUagLH.WXxUT();
            if (tUagLH != null && tUagLH.tryIntercept(string)) {
                callbackInfo.cancel();
                return;
            }
        }
        catch (Exception exception) {
            // empty catch block
        }
        Jt.trackOutgoing(string);
    }

    @Inject(method={"sendCommand"}, at={@At(value="HEAD")}, cancellable=true)
    private void onSendCommand(String string, CallbackInfoReturnable<Boolean> callbackInfoReturnable) {
        if (TfXevN.Eeuoy()) {
            return;
        }
        if (Xz.dx((String)string) && Xz.cG((String)string)) {
            callbackInfoReturnable.setReturnValue((Object)((boolean)( /* dynamic constant */ (Object)feG.ZQ("CtYsT", MethodHandles.lookup(), "ZQ", Jt.class, -173622536, -1371983308, 1148639373, 4))));
            return;
        }
        if (bIdOr.ek(string)) {
            callbackInfoReturnable.setReturnValue((Object)((boolean)( /* dynamic constant */ (Object)feG.ZQ("CtYsT", MethodHandles.lookup(), "ZQ", Jt.class, -173622536, -1371983308, 1148639373, 4))));
            return;
        }
        if (bh.GD((String)string)) {
            callbackInfoReturnable.setReturnValue((Object)((boolean)( /* dynamic constant */ (Object)feG.ZQ("CtYsT", MethodHandles.lookup(), "ZQ", Jt.class, -173622536, -1371983308, 1148639373, 4))));
            return;
        }
        if (VyPtW.KO(string)) {
            callbackInfoReturnable.setReturnValue((Object)((boolean)( /* dynamic constant */ (Object)feG.ZQ("CtYsT", MethodHandles.lookup(), "ZQ", Jt.class, -173622536, -1371983308, 1148639373, 4))));
            return;
        }
        if (eyNOkz.xi(string)) {
            callbackInfoReturnable.setReturnValue((Object)((boolean)( /* dynamic constant */ (Object)feG.ZQ("CtYsT", MethodHandles.lookup(), "ZQ", Jt.class, -173622536, -1371983308, 1148639373, 4))));
            return;
        }
        if (eyNOkz.zKd(string)) {
            callbackInfoReturnable.setReturnValue((Object)((boolean)( /* dynamic constant */ (Object)feG.ZQ("CtYsT", MethodHandles.lookup(), "ZQ", Jt.class, -173622536, -1371983308, 1148639373, 4))));
            return;
        }
        if (eyNOkz.qPHjFP(string)) {
            callbackInfoReturnable.setReturnValue((Object)((boolean)( /* dynamic constant */ (Object)feG.ZQ("CtYsT", MethodHandles.lookup(), "ZQ", Jt.class, -173622536, -1371983308, 1148639373, 4))));
            return;
        }
        if (qCIog.LX(string)) {
            callbackInfoReturnable.setReturnValue((Object)((boolean)( /* dynamic constant */ (Object)feG.ZQ("CtYsT", MethodHandles.lookup(), "ZQ", Jt.class, -173622536, -1371983308, 1148639373, 4))));
            return;
        }
        if (qCIog.Hk(string)) {
            callbackInfoReturnable.setReturnValue((Object)((boolean)( /* dynamic constant */ (Object)feG.ZQ("CtYsT", MethodHandles.lookup(), "ZQ", Jt.class, -173622536, -1371983308, 1148639373, 4))));
            return;
        }
        if (o.eu(string)) {
            callbackInfoReturnable.setReturnValue((Object)((boolean)( /* dynamic constant */ (Object)feG.ZQ("CtYsT", MethodHandles.lookup(), "ZQ", Jt.class, -173622536, -1371983308, 1148639373, 4))));
            return;
        }
        try {
            TUagLH tUagLH = TUagLH.WXxUT();
            if (tUagLH != null && tUagLH.tryIntercept(string)) {
                callbackInfoReturnable.setReturnValue((Object)((boolean)( /* dynamic constant */ (Object)feG.ZQ("CtYsT", MethodHandles.lookup(), "ZQ", Jt.class, -173622536, -1371983308, 1148639373, 4))));
                return;
            }
        }
        catch (Exception exception) {
            // empty catch block
        }
        Jt.trackOutgoing(string);
    }

    private static void trackOutgoing(String string) {
        if (string == null) {
            return;
        }
        try {
            dQeKfI.hGquL(string);
        }
        catch (Exception exception) {
            // empty catch block
        }
        try {
            eyNOkz.NmICE(string);
        }
        catch (Exception exception) {
            // empty catch block
        }
        try {
            wP.mm((String)string);
        }
        catch (Exception exception) {
            // empty catch block
        }
        try {
            sfTGPQ.eTyEt().onOutgoingCommand(string);
        }
        catch (Exception exception) {
            // empty catch block
        }
        if (string.startsWith((String)( /* dynamic constant */ (Object)feG.fL("ENlim", MethodHandles.lookup(), "fL", Jt.class, "#\u00cc\u00a0\u0084\u008a\u001ac\u00d6\u00a3\u0091\u000f0\u0088", 758495170, -1967790587, 785477872, 1)))) {
            String string2 = string.substring(((String)( /* dynamic constant */ (Object)feG.fL("xDXmeQ", MethodHandles.lookup(), "fL", Jt.class, "+\u0085]\u001b\u00ce\u00a1/%\u00e5\u00b9\u0011\u00de\u00d5", 1382288158, -1409183402, 1128169506, 2))).length()).trim();
            sfTGPQ sfTGPQ2 = sfTGPQ.eTyEt();
            if (sfTGPQ2.getTargetName() != null && sfTGPQ2.getTargetName().equals(string2)) {
                sfTGPQ2.setSummoned((boolean)( /* dynamic constant */ (Object)feG.ZQ("CtYsT", MethodHandles.lookup(), "ZQ", Jt.class, -173622536, -1371983308, 1148639373, 4)));
            }
        }
        imu.fqA(string);
        UF.xxKYX((String)string);
    }
}
