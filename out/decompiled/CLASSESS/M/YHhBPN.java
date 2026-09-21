/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.mojang.authlib.GameProfile
 *  net.minecraft.class_2561
 *  net.minecraft.class_266
 *  net.minecraft.class_269
 *  net.minecraft.class_274$class_275
 *  net.minecraft.class_310
 *  net.minecraft.class_327
 *  net.minecraft.class_332
 *  net.minecraft.class_355
 *  net.minecraft.class_5250
 *  net.minecraft.class_5348
 *  net.minecraft.class_5481
 *  net.minecraft.class_640
 *  net.minecraft.class_9013
 *  net.minecraft.class_9015
 *  net.minecraft.class_9022
 *  net.minecraft.class_9025
 *  org.spongepowered.asm.mixin.Final
 *  org.spongepowered.asm.mixin.Mixin
 *  org.spongepowered.asm.mixin.Shadow
 *  org.spongepowered.asm.mixin.Unique
 *  org.spongepowered.asm.mixin.gen.Invoker
 *  org.spongepowered.asm.mixin.injection.At
 *  org.spongepowered.asm.mixin.injection.Inject
 *  org.spongepowered.asm.mixin.injection.Redirect
 *  org.spongepowered.asm.mixin.injection.callback.CallbackInfo
 */
package CLASSESS.M;

import CLASSESS.VL;
import CLASSESS.feG;
import CLASSESS.lw;
import com.mojang.authlib.GameProfile;
import java.lang.invoke.MethodHandles;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import net.minecraft.class_2561;
import net.minecraft.class_266;
import net.minecraft.class_269;
import net.minecraft.class_274;
import net.minecraft.class_310;
import net.minecraft.class_327;
import net.minecraft.class_332;
import net.minecraft.class_355;
import net.minecraft.class_5250;
import net.minecraft.class_5348;
import net.minecraft.class_5481;
import net.minecraft.class_640;
import net.minecraft.class_9013;
import net.minecraft.class_9015;
import net.minecraft.class_9022;
import net.minecraft.class_9025;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.gen.Invoker;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.Redirect;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

/*
 * Uses jvm11+ dynamic constants - pseudocode provided - see https://www.benf.org/other/cfr/dynamic-constants.html
 */
@Mixin(value={class_355.class}, priority=10000)
public abstract class YHhBPN {
    @Shadow
    @Final
    private class_310 field_2155;
    @Shadow
    private class_2561 field_2153;
    @Shadow
    private class_2561 field_2154;
    @Unique
    private final Map<String, int[]> vd$friendBackgrounds = new HashMap<String, int[]>();
    @Unique
    private boolean vd$tabGlassActive;
    @Unique
    private boolean vd$tabGlassRendered;

    @Shadow
    public abstract class_2561 method_1918(class_640 var1);

    @Invoker(value="collectPlayerEntries")
    protected abstract List<class_640> vd$collectPlayerEntries();

    @Redirect(method={"render(Lnet/minecraft/client/gui/DrawContext;ILnet/minecraft/scoreboard/Scoreboard;Lnet/minecraft/scoreboard/ScoreboardObjective;)V"}, at=@At(value="INVOKE", target="Lnet/minecraft/client/gui/DrawContext;fill(IIIII)V", ordinal=0), require=0)
    private void vd$renderHeaderGlass(class_332 class_3322, int n, int n2, int n3, int n4, int n5) {
        if (!this.vd$tabGlassRendered) {
            class_3322.method_25294(n, n2, n3, n4, n5);
        }
    }

    @Redirect(method={"render(Lnet/minecraft/client/gui/DrawContext;ILnet/minecraft/scoreboard/Scoreboard;Lnet/minecraft/scoreboard/ScoreboardObjective;)V"}, at=@At(value="INVOKE", target="Lnet/minecraft/client/gui/DrawContext;fill(IIIII)V", ordinal=1), require=0)
    private void vd$renderMainGlass(class_332 class_3322, int n, int n2, int n3, int n4, int n5) {
        if (!this.vd$tabGlassRendered) {
            class_3322.method_25294(n, n2, n3, n4, n5);
        }
    }

    @Redirect(method={"render(Lnet/minecraft/client/gui/DrawContext;ILnet/minecraft/scoreboard/Scoreboard;Lnet/minecraft/scoreboard/ScoreboardObjective;)V"}, at=@At(value="INVOKE", target="Lnet/minecraft/client/gui/DrawContext;fill(IIIII)V", ordinal=2), require=0)
    private void captureFillCoordinates(class_332 class_3322, int n, int n2, int n3, int n4, int n5) {
        if (!this.vd$tabGlassRendered) {
            class_3322.method_25294(n, n2, n3, n4, n5);
        }
        int[] nArray = new int[ /* dynamic constant */ (Object)feG.ZQ("FPcnJ", MethodHandles.lookup(), "ZQ", YHhBPN.class, -1403647980, 1173392088, 858515943, 29)];
        nArray[ /* dynamic constant */ (Object)feG.ZQ("us", MethodHandles.lookup(), "ZQ", YHhBPN.class, 1127670648, 1436521381, 1054438653, 4)] = n;
        nArray[ /* dynamic constant */ (Object)feG.ZQ("OuWzIa", MethodHandles.lookup(), "ZQ", YHhBPN.class, 263970478, 1672094725, 1398285172, 7)] = n2;
        nArray[ /* dynamic constant */ (Object)feG.ZQ("yoWnjp", MethodHandles.lookup(), "ZQ", YHhBPN.class, -452273848, -367725944, 1584140205, 20)] = n3;
        nArray[ /* dynamic constant */ (Object)feG.ZQ("RJAsA", MethodHandles.lookup(), "ZQ", YHhBPN.class, 1407895202, -730053110, 1279244099, 9)] = n4;
        int[] nArray2 = nArray;
        this.vd$friendBackgrounds.put("y_" + n2, nArray2);
    }

    @Redirect(method={"render(Lnet/minecraft/client/gui/DrawContext;ILnet/minecraft/scoreboard/Scoreboard;Lnet/minecraft/scoreboard/ScoreboardObjective;)V"}, at=@At(value="INVOKE", target="Lnet/minecraft/client/gui/DrawContext;fill(IIIII)V", ordinal=3), require=0)
    private void vd$renderFooterGlass(class_332 class_3322, int n, int n2, int n3, int n4, int n5) {
        if (!this.vd$tabGlassRendered) {
            class_3322.method_25294(n, n2, n3, n4, n5);
        }
    }

    @Inject(method={"render(Lnet/minecraft/client/gui/DrawContext;ILnet/minecraft/scoreboard/Scoreboard;Lnet/minecraft/scoreboard/ScoreboardObjective;)V"}, at={@At(value="HEAD")})
    private void zyP(class_332 class_3322, int n, class_269 class_2692, class_266 class_2662, CallbackInfo callbackInfo) {
        this.vd$friendBackgrounds.clear();
        VL vL = VL.Mps();
        this.vd$tabGlassActive = vL != null && vL.isEnabled() && (vL.isLiquidGlassEnabled() || vL.isMergeEnabled()) && vL.appliesTo((String)( /* dynamic constant */ (Object)feG.fL("Qen", MethodHandles.lookup(), "fL", YHhBPN.class, "\u00d9\u00cd\u00a9", -896083940, 47837114, -1541469175, 0)));
        this.vd$tabGlassRendered = this.vd$tabGlassActive && this.vd$renderWholeTabGlass(class_3322, n, class_2692, class_2662);
    }

    /*
     * WARNING - void declaration
     */
    @Unique
    private boolean vd$renderWholeTabGlass(class_332 class_3322, int n, class_269 class_2692, class_266 class_2662) {
        reference var20_39;
        reference var19_36;
        void var11_18;
        int n2;
        List<class_640> list;
        try {
            list = this.vd$collectPlayerEntries();
        }
        catch (Throwable throwable) {
            return (boolean)( /* dynamic constant */ (Object)feG.ZQ("us", MethodHandles.lookup(), "ZQ", YHhBPN.class, 1127670648, 1436521381, 1054438653, 4));
        }
        if (list == null || list.isEmpty()) {
            return (boolean)( /* dynamic constant */ (Object)feG.ZQ("us", MethodHandles.lookup(), "ZQ", YHhBPN.class, 1127670648, 1436521381, 1054438653, 4));
        }
        Object object =  /* dynamic constant */ (Object)feG.ZQ("us", MethodHandles.lookup(), "ZQ", YHhBPN.class, 1127670648, 1436521381, 1054438653, 4);
        Object object2 =  /* dynamic constant */ (Object)feG.ZQ("us", MethodHandles.lookup(), "ZQ", YHhBPN.class, 1127670648, 1436521381, 1054438653, 4);
        int n3 = this.field_2155.field_1772.method_1727((String)( /* dynamic constant */ (Object)feG.fL("evm", MethodHandles.lookup(), "fL", YHhBPN.class, "\u00f2", 1306965693, 320624556, -616789783, 2)));
        for (class_640 class_6402 : list) {
            object = Math.max((int)object, this.field_2155.field_1772.method_27525((class_5348)this.method_1918(class_6402)));
            if (class_2662 == null || class_2662.method_1118() == class_274.class_275.field_1471) continue;
            try {
                class_9013 throwable = class_2692.method_55430(class_9015.method_55420((GameProfile)class_6402.method_2966()), class_2662);
                class_5250 class_52502 = class_9013.method_55398((class_9013)throwable, (class_9022)class_2662.method_55380((class_9022)class_9025.field_47568));
                int object3 = this.field_2155.field_1772.method_27525((class_5348)class_52502);
                if (object3 <= 0) continue;
                object2 = Math.max((int)object2, n3 + object3);
            }
            catch (Throwable throwable) {}
        }
        int n5 = n2 = list.size();
        Object object3 =  /* dynamic constant */ (Object)feG.ZQ("OuWzIa", MethodHandles.lookup(), "ZQ", YHhBPN.class, 263970478, 1672094725, 1398285172, 7);
        while (n5 > ( /* dynamic constant */ (Object)feG.ZQ("PFE", MethodHandles.lookup(), "ZQ", YHhBPN.class, -2080113127, -1618001775, -1907930164, 4))) {
            n5 = (n2 + (var11_18 += ( /* dynamic constant */ (Object)feG.ZQ("OuWzIa", MethodHandles.lookup(), "ZQ", YHhBPN.class, 263970478, 1672094725, 1398285172, 7))) - ( /* dynamic constant */ (Object)feG.ZQ("OuWzIa", MethodHandles.lookup(), "ZQ", YHhBPN.class, 263970478, 1672094725, 1398285172, 7))) / var11_18;
        }
        int n4 = this.field_2155.method_1542();
        try {
            n4 |= this.field_2155.method_1562() != null && this.field_2155.method_1562().method_48296().method_10771() ? ( /* dynamic constant */ (Object)feG.ZQ("OuWzIa", MethodHandles.lookup(), "ZQ", YHhBPN.class, 263970478, 1672094725, 1398285172, 7)) : ( /* dynamic constant */ (Object)feG.ZQ("us", MethodHandles.lookup(), "ZQ", YHhBPN.class, 1127670648, 1436521381, 1054438653, 4));
        }
        catch (Throwable throwable) {
            // empty catch block
        }
        Object object4 = class_2662 == null ? ( /* dynamic constant */ (Object)feG.ZQ("us", MethodHandles.lookup(), "ZQ", YHhBPN.class, 1127670648, 1436521381, 1054438653, 4)) : (class_2662.method_1118() == class_274.class_275.field_1471 ? ( /* dynamic constant */ (Object)feG.ZQ("KiNJ", MethodHandles.lookup(), "ZQ", YHhBPN.class, 1689377898, 355594236, -1627400058, 31)) : object2);
        int n6 = Math.min((int)(var11_18 * ((n4 != 0 ? ( /* dynamic constant */ (Object)feG.ZQ("UlkBI", MethodHandles.lookup(), "ZQ", YHhBPN.class, -769888830, -845198489, 524850888, 26)) : ( /* dynamic constant */ (Object)feG.ZQ("us", MethodHandles.lookup(), "ZQ", YHhBPN.class, 1127670648, 1436521381, 1054438653, 4))) + object + object4 + ( /* dynamic constant */ (Object)feG.ZQ("mOhce", MethodHandles.lookup(), "ZQ", YHhBPN.class, -49304817, -698724479, -1910065834, 8)))), n - ( /* dynamic constant */ (Object)feG.ZQ("iYxre", MethodHandles.lookup(), "ZQ", YHhBPN.class, -234891585, -2037570659, -1696813830, 2))) / var11_18;
        int n7 = n6 * var11_18 + (var11_18 - ( /* dynamic constant */ (Object)feG.ZQ("OuWzIa", MethodHandles.lookup(), "ZQ", YHhBPN.class, 263970478, 1672094725, 1398285172, 7))) * ( /* dynamic constant */ (Object)feG.ZQ("GXntpT", MethodHandles.lookup(), "ZQ", YHhBPN.class, -1407249293, 1526741276, 1834828926, 14));
        List list2 = this.field_2153 == null ? List.of() : this.field_2155.field_1772.method_1728((class_5348)this.field_2153, n - ( /* dynamic constant */ (Object)feG.ZQ("iYxre", MethodHandles.lookup(), "ZQ", YHhBPN.class, -234891585, -2037570659, -1696813830, 2)));
        List list3 = this.field_2154 == null ? List.of() : this.field_2155.field_1772.method_1728((class_5348)this.field_2154, n - ( /* dynamic constant */ (Object)feG.ZQ("iYxre", MethodHandles.lookup(), "ZQ", YHhBPN.class, -234891585, -2037570659, -1696813830, 2)));
        for (class_5481 class_54812 : list2) {
            n7 = Math.max(n7, this.field_2155.field_1772.method_30880(class_54812));
        }
        for (class_5481 class_54813 : list3) {
            n7 = Math.max(n7, this.field_2155.field_1772.method_30880(class_54813));
        }
        Object object5 =  /* dynamic constant */ (Object)feG.ZQ("UlkBI", MethodHandles.lookup(), "ZQ", YHhBPN.class, -769888830, -845198489, 524850888, 26);
        Object object6 =  /* dynamic constant */ (Object)feG.ZQ("BtJUg", MethodHandles.lookup(), "ZQ", YHhBPN.class, -924668042, 1226672712, 1247608704, 15);
        if (!list2.isEmpty()) {
            var19_36 = object6 + (list2.size() * ( /* dynamic constant */ (Object)feG.ZQ("UlkBI", MethodHandles.lookup(), "ZQ", YHhBPN.class, -769888830, -845198489, 524850888, 26)) + ( /* dynamic constant */ (Object)feG.ZQ("OuWzIa", MethodHandles.lookup(), "ZQ", YHhBPN.class, 263970478, 1672094725, 1398285172, 7)));
        }
        void var20_38 = var19_36 + n5 * ( /* dynamic constant */ (Object)feG.ZQ("UlkBI", MethodHandles.lookup(), "ZQ", YHhBPN.class, -769888830, -845198489, 524850888, 26));
        if (!list3.isEmpty()) {
            reference var19_37 = var19_36 + (n5 * ( /* dynamic constant */ (Object)feG.ZQ("UlkBI", MethodHandles.lookup(), "ZQ", YHhBPN.class, -769888830, -845198489, 524850888, 26)) + ( /* dynamic constant */ (Object)feG.ZQ("OuWzIa", MethodHandles.lookup(), "ZQ", YHhBPN.class, 263970478, 1672094725, 1398285172, 7)));
            var20_39 = var19_37 + list3.size() * ( /* dynamic constant */ (Object)feG.ZQ("UlkBI", MethodHandles.lookup(), "ZQ", YHhBPN.class, -769888830, -845198489, 524850888, 26));
        }
        Object object7 =  /* dynamic constant */ (Object)feG.ZQ("RJAsA", MethodHandles.lookup(), "ZQ", YHhBPN.class, 1407895202, -730053110, 1279244099, 9);
        int n8 = n / ( /* dynamic constant */ (Object)feG.ZQ("yoWnjp", MethodHandles.lookup(), "ZQ", YHhBPN.class, -452273848, -367725944, 1584140205, 20)) - n7 / ( /* dynamic constant */ (Object)feG.ZQ("yoWnjp", MethodHandles.lookup(), "ZQ", YHhBPN.class, -452273848, -367725944, 1584140205, 20)) - ( /* dynamic constant */ (Object)feG.ZQ("OuWzIa", MethodHandles.lookup(), "ZQ", YHhBPN.class, 263970478, 1672094725, 1398285172, 7)) - object7;
        int n9 = n / ( /* dynamic constant */ (Object)feG.ZQ("yoWnjp", MethodHandles.lookup(), "ZQ", YHhBPN.class, -452273848, -367725944, 1584140205, 20)) + n7 / ( /* dynamic constant */ (Object)feG.ZQ("yoWnjp", MethodHandles.lookup(), "ZQ", YHhBPN.class, -452273848, -367725944, 1584140205, 20)) + ( /* dynamic constant */ (Object)feG.ZQ("OuWzIa", MethodHandles.lookup(), "ZQ", YHhBPN.class, 263970478, 1672094725, 1398285172, 7)) + object7;
        reference var18_31 = object5 - object7;
        reference var20_40 = var20_39 + object7;
        lw.SL((String)( /* dynamic constant */ (Object)feG.fL("AeFf", MethodHandles.lookup(), "fL", YHhBPN.class, "O\u00c3\u000b", 1957521469, -964102339, -370729954, 2)), class_3322.method_51448(), n8, (float)var18_31, n9 - n8, (float)(var20_40 - var18_31), (float)( /* dynamic constant */ (Object)feG.ZQ("rzMaG", MethodHandles.lookup(), "ZQ", YHhBPN.class, -740998191, -1320752637, 1716396686, 16)));
        return lw.vKAtz((String)( /* dynamic constant */ (Object)feG.fL("nofra", MethodHandles.lookup(), "fL", YHhBPN.class, "e\u00e9!", -1430006059, 2033464787, 1382891465, 2)), class_3322.method_51448(), n8, (float)var18_31, n9 - n8, (float)(var20_40 - var18_31), (float)( /* dynamic constant */ (Object)feG.ZQ("SjZ", MethodHandles.lookup(), "ZQ", YHhBPN.class, -179694594, 1813084775, -1568252380, 22)), (float)( /* dynamic constant */ (Object)feG.ZQ("rzMaG", MethodHandles.lookup(), "ZQ", YHhBPN.class, -740998191, -1320752637, 1716396686, 16)));
    }

    @Redirect(method={"render(Lnet/minecraft/client/gui/DrawContext;ILnet/minecraft/scoreboard/Scoreboard;Lnet/minecraft/scoreboard/ScoreboardObjective;)V"}, at=@At(value="INVOKE", target="Lnet/minecraft/client/gui/DrawContext;drawTextWithShadow(Lnet/minecraft/client/font/TextRenderer;Lnet/minecraft/text/Text;III)I"), require=0)
    private int redirectDrawText(class_332 class_3322, class_327 class_3272, class_2561 class_25612, int n, int n2, int n3) {
        return class_3322.method_27535(class_3272, class_25612, n, n2, n3);
    }
}
