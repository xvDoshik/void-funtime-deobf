/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.fabricmc.api.EnvType
 *  net.fabricmc.api.Environment
 *  net.minecraft.class_310
 *  net.minecraft.class_437
 *  net.minecraft.class_442
 *  net.minecraft.class_542
 *  net.minecraft.class_638
 *  net.minecraft.class_746
 *  org.jetbrains.annotations.Nullable
 *  org.spongepowered.asm.mixin.Mixin
 *  org.spongepowered.asm.mixin.Shadow
 *  org.spongepowered.asm.mixin.Unique
 *  org.spongepowered.asm.mixin.injection.At
 *  org.spongepowered.asm.mixin.injection.Inject
 *  org.spongepowered.asm.mixin.injection.callback.CallbackInfo
 */
package CLASSESS.M;

import CLASSESS.LAx;
import CLASSESS.Mr;
import CLASSESS.Nl;
import CLASSESS.Oj;
import CLASSESS.SyBEH;
import CLASSESS.Up;
import CLASSESS.Xb;
import CLASSESS.Yj;
import CLASSESS.feG;
import CLASSESS.lnURa;
import CLASSESS.nt;
import CLASSESS.vB;
import java.lang.invoke.MethodHandles;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.class_310;
import net.minecraft.class_437;
import net.minecraft.class_442;
import net.minecraft.class_542;
import net.minecraft.class_638;
import net.minecraft.class_746;
import org.jetbrains.annotations.Nullable;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

/*
 * Uses jvm11+ dynamic constants - pseudocode provided - see https://www.benf.org/other/cfr/dynamic-constants.html
 */
@Environment(value=EnvType.CLIENT)
@Mixin(value={class_310.class})
public abstract class QCYBan
implements lnURa {
    @Shadow
    @Nullable
    public class_746 field_1724;
    @Shadow
    @Nullable
    public class_437 field_1755;
    @Shadow
    @Nullable
    public class_638 field_1687;
    @Unique
    private boolean vd$wasInWorld;

    @Inject(at={@At(value="TAIL")}, method={"<init>"})
    private void onInit(class_542 class_5422, CallbackInfo callbackInfo) {
        Xb.init();
    }

    @Inject(at={@At(value="HEAD")}, method={"stop"})
    private void stop(CallbackInfo callbackInfo) {
        if (LAx.Gh().isInitialized()) {
            try {
                LAx.Gh().getFileController().saveFiles();
            }
            catch (Nl nl2) {
                vB.error((Object)("Error occurred while saving files: " + nl2.getMessage() + " " + String.valueOf(nl2.getCause())));
            }
            finally {
                LAx.Gh().getFileController().stopAutoSave();
            }
        }
    }

    @Inject(method={"setScreen"}, at={@At(value="HEAD")}, cancellable=true)
    public void setScreenHook(class_437 class_4372, CallbackInfo callbackInfo) {
        Mr mr2 = class_4372 instanceof class_442 || class_4372 == null && this.field_1687 == null ? new Mr() : class_4372;
        nt nt2 = new nt((class_437)mr2);
        Up.vh((SyBEH)((Object)nt2));
        LAx.Gh().getDraggableRepository().draggable().forEach(arg_0 -> QCYBan.JaZin(nt2, arg_0));
        class_437 class_4373 = nt2.getScreen();
        if (class_4372 != class_4373) {
            mc.method_1507(class_4373);
            callbackInfo.cancel();
        }
    }

    @Inject(method={"tick"}, at={@At(value="RETURN")})
    private void vd$tickPvePvp(CallbackInfo callbackInfo) {
        Object object = this.field_1687 != null ? ( /* dynamic constant */ (Object)feG.ZQ("MHhErm", MethodHandles.lookup(), "ZQ", QCYBan.class, -578192976, -266341615, -1611830905, 8)) : ( /* dynamic constant */ (Object)feG.ZQ("gjMWp", MethodHandles.lookup(), "ZQ", QCYBan.class, -1367669468, -905983812, 1737301135, 19));
        Object object2 = this.vd$wasInWorld && object == false ? ( /* dynamic constant */ (Object)feG.ZQ("MHhErm", MethodHandles.lookup(), "ZQ", QCYBan.class, -578192976, -266341615, -1611830905, 8)) : ( /* dynamic constant */ (Object)feG.ZQ("gjMWp", MethodHandles.lookup(), "ZQ", QCYBan.class, -1367669468, -905983812, 1737301135, 19));
        this.vd$wasInWorld = object;
        if (this.field_1755 instanceof class_442 || object2 != false && this.field_1755 == null) {
            mc.method_1507((class_437)new Mr());
        }
        Oj.HXo();
    }

    private static void JaZin(nt nt2, Yj yj) {
        yj.setScreen(nt2);
    }
}
