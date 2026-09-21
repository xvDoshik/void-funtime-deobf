/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.mojang.authlib.GameProfile
 *  net.minecraft.PlayerListEntry
 *  org.spongepowered.asm.mixin.Mixin
 *  org.spongepowered.asm.mixin.gen.Accessor
 */
package CLASSESS.M;

import com.mojang.authlib.GameProfile;
import net.minecraft.PlayerListEntry;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;

@Mixin(value={PlayerListEntry.class})
public interface mCm {
    @Accessor(value="profile")
    public GameProfile getProfile();
}
