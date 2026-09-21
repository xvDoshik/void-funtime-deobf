/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.fabricmc.api.EnvType
 *  net.fabricmc.api.Environment
 *  net.minecraft.MinecraftClient
 *  net.minecraft.Screen
 *  net.minecraft.TitleScreen
 *  net.minecraft.RunArgs
 *  net.minecraft.ClientWorld
 *  net.minecraft.ClientPlayerEntity
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
import net.minecraft.MinecraftClient;
import net.minecraft.Screen;
import net.minecraft.TitleScreen;
import net.minecraft.RunArgs;
import net.minecraft.ClientWorld;
import net.minecraft.ClientPlayerEntity;
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
@Mixin(value={MinecraftClient.class})
public abstract class QCYBan
implements lnURa {
    @Shadow
    @Nullable
    public ClientPlayerEntity field_1724;
    @Shadow
    @Nullable
    public Screen field_1755;
    @Shadow
    @Nullable
    public ClientWorld field_1687;
    @Unique
    private boolean vd$wasInWorld;

    @Inject(at={@At(value="TAIL")}, method={"<init>"})
    private void onInit(RunArgs class_5422, CallbackInfo callbackInfo) {
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
    public void setScreenHook(Screen class_4372, CallbackInfo callbackInfo) {
        Mr mr2 = class_4372 instanceof TitleScreen || class_4372 == null && this.field_1687 == null ? new Mr() : class_4372;
        nt nt2 = new nt((Screen)mr2);
        Up.vh((SyBEH)((Object)nt2));
        LAx.Gh().getDraggableRepository().draggable().forEach(arg_0 -> QCYBan.JaZin(nt2, arg_0));
        Screen class_4373 = nt2.getScreen();
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
        if (this.field_1755 instanceof TitleScreen || object2 != false && this.field_1755 == null) {
            mc.method_1507((Screen)new Mr());
        }
        Oj.HXo();
    }

    private static void JaZin(nt nt2, Yj yj) {
        yj.setScreen(nt2);
    }
}
