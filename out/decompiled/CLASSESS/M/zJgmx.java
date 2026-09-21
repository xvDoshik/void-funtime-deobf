/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_630
 *  net.minecraft.class_9946
 *  org.spongepowered.asm.mixin.Mixin
 *  org.spongepowered.asm.mixin.gen.Accessor
 */
package CLASSESS.M;

import net.minecraft.class_630;
import net.minecraft.class_9946;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;

@Mixin(value={class_9946.class})
public interface zJgmx {
    @Accessor(value="base")
    public class_630 getBase();

    @Accessor(value="outerGlass")
    public class_630 getOuterGlass();

    @Accessor(value="innerGlass")
    public class_630 getInnerGlass();

    @Accessor(value="cube")
    public class_630 getCube();
}
