/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.ModelPart
 *  net.minecraft.EndCrystalEntityModel
 *  org.spongepowered.asm.mixin.Mixin
 *  org.spongepowered.asm.mixin.gen.Accessor
 */
package CLASSESS.M;

import net.minecraft.ModelPart;
import net.minecraft.EndCrystalEntityModel;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;

@Mixin(value={EndCrystalEntityModel.class})
public interface zJgmx {
    @Accessor(value="base")
    public ModelPart getBase();

    @Accessor(value="outerGlass")
    public ModelPart getOuterGlass();

    @Accessor(value="innerGlass")
    public ModelPart getInnerGlass();

    @Accessor(value="cube")
    public ModelPart getCube();
}
