/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.Team
 *  net.minecraft.Scoreboard
 *  org.spongepowered.asm.mixin.Mixin
 *  org.spongepowered.asm.mixin.injection.At
 *  org.spongepowered.asm.mixin.injection.Inject
 *  org.spongepowered.asm.mixin.injection.callback.CallbackInfo
 */
package CLASSESS.M;

import net.minecraft.Team;
import net.minecraft.Scoreboard;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(value={Scoreboard.class})
public class vP {
    @Inject(method={"removeScoreHolderFromTeam"}, at={@At(value="HEAD")}, cancellable=true)
    private void onRemoveScoreHolderFromTeam(String string, Team EmptyBlockView, CallbackInfo callbackInfo) {
        Scoreboard VehicleMoveS2CPacket = (Scoreboard)this;
        Team MapUpdateS2CPacket = VehicleMoveS2CPacket.method_1164(string);
        if (MapUpdateS2CPacket != EmptyBlockView) {
            callbackInfo.cancel();
        }
    }
}
