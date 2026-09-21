/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.Slot
 *  net.minecraft.DrawContext
 *  net.minecraft.HandledScreen
 *  org.jetbrains.annotations.Nullable
 *  org.spongepowered.asm.mixin.Mixin
 *  org.spongepowered.asm.mixin.Shadow
 *  org.spongepowered.asm.mixin.injection.At
 *  org.spongepowered.asm.mixin.injection.Inject
 *  org.spongepowered.asm.mixin.injection.callback.CallbackInfo
 */
package CLASSESS.M;

import CLASSESS.Up;
import CLASSESS.iIn;
import net.minecraft.Slot;
import net.minecraft.DrawContext;
import net.minecraft.HandledScreen;
import org.jetbrains.annotations.Nullable;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(value={HandledScreen.class})
public abstract class I {
    @Shadow
    protected int field_2776;
    @Shadow
    protected int field_2800;
    @Shadow
    protected int field_2792;
    @Shadow
    protected int field_2779;
    @Shadow
    @Nullable
    protected Slot field_2787;

    @Inject(method={"render"}, at={@At(value="RETURN")})
    public void onRenderReturn(DrawContext class_3322, int n, int n2, float f, CallbackInfo callbackInfo) {
        Up.vh(new iIn(class_3322, this.field_2787, this.field_2792, this.field_2779, this.field_2776, this.field_2800));
    }
}
