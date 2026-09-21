/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.ChatHudLine
 *  net.minecraft.ChatHud
 *  org.spongepowered.asm.mixin.Mixin
 *  org.spongepowered.asm.mixin.gen.Accessor
 *  org.spongepowered.asm.mixin.gen.Invoker
 */
package CLASSESS.M;

import java.util.List;
import net.minecraft.ChatHudLine;
import net.minecraft.ChatHud;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;
import org.spongepowered.asm.mixin.gen.Invoker;

@Mixin(value={ChatHud.class})
public interface La {
    @Accessor(value="messages")
    public List<ChatHudLine> getMessages();

    @Invoker(value="refresh")
    public void invokeRefresh();
}
