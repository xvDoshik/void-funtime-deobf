/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.mojang.authlib.GameProfile
 *  net.minecraft.class_10185
 *  net.minecraft.class_243
 *  net.minecraft.class_310
 *  net.minecraft.class_638
 *  net.minecraft.class_742
 *  net.minecraft.class_744
 *  net.minecraft.class_746
 *  org.spongepowered.asm.mixin.Final
 *  org.spongepowered.asm.mixin.Mixin
 *  org.spongepowered.asm.mixin.Shadow
 *  org.spongepowered.asm.mixin.Unique
 *  org.spongepowered.asm.mixin.injection.At
 *  org.spongepowered.asm.mixin.injection.At$Shift
 *  org.spongepowered.asm.mixin.injection.Inject
 *  org.spongepowered.asm.mixin.injection.callback.CallbackInfo
 */
package CLASSESS.M;

import CLASSESS.ACC;
import CLASSESS.H;
import CLASSESS.SyBEH;
import CLASSESS.TUagLH;
import CLASSESS.Up;
import CLASSESS.feG;
import com.mojang.authlib.GameProfile;
import java.lang.invoke.MethodHandles;
import net.minecraft.class_10185;
import net.minecraft.class_243;
import net.minecraft.class_310;
import net.minecraft.class_638;
import net.minecraft.class_742;
import net.minecraft.class_744;
import net.minecraft.class_746;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

/*
 * Uses jvm11+ dynamic constants - pseudocode provided - see https://www.benf.org/other/cfr/dynamic-constants.html
 */
@Mixin(value={class_746.class})
public abstract class oHvpd
extends class_742 {
    @Final
    @Shadow
    protected class_310 field_3937;
    @Shadow
    public class_744 field_3913;

    @Shadow
    public abstract float method_5695(float var1);

    @Shadow
    public abstract float method_5705(float var1);

    public oHvpd(class_638 class_6382, GameProfile gameProfile) {
        super(class_6382, gameProfile);
    }

    @Inject(method={"tick"}, at={@At(value="HEAD")})
    public void tick(CallbackInfo callbackInfo) {
        if (this.field_3937.field_1724 != null && this.field_3937.field_1687 != null) {
            Up.vh((SyBEH)((Object)new H()));
        }
    }

    @Inject(method={"tickMovement"}, at={@At(value="HEAD")})
    private void pM(CallbackInfo callbackInfo) {
        this.jw();
    }

    @Inject(method={"tickMovement"}, at={@At(value="INVOKE", target="Lnet/minecraft/client/input/Input;tick()V", shift=At.Shift.AFTER)})
    private void PjlYq(CallbackInfo callbackInfo) {
        this.jw();
    }

    @Unique
    private void jw() {
        if (!TUagLH.tIFgxB()) {
            return;
        }
        if (this.field_3913 != null) {
            this.field_3913.field_54155 = class_10185.field_54098;
            this.field_3913.field_3905 = (float)( /* dynamic constant */ (Object)feG.Rz("PpR", MethodHandles.lookup(), "Rz", oHvpd.class, -1804202794, 1161768203, -110500133, 11));
            this.field_3913.field_3907 = (float)( /* dynamic constant */ (Object)feG.Rz("PpR", MethodHandles.lookup(), "Rz", oHvpd.class, -1804202794, 1161768203, -110500133, 11));
        }
        this.method_5728(false);
        this.method_18799(class_243.field_1353);
    }

    @Inject(method={"closeHandledScreen"}, at={@At(value="HEAD")}, cancellable=true)
    private void jO(CallbackInfo callbackInfo) {
        ACC aCC = new ACC(this.field_3937.field_1755);
        Up.vh((SyBEH)((Object)aCC));
        if (aCC.isCancelled()) {
            callbackInfo.cancel();
        }
    }
}
