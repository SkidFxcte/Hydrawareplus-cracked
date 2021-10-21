
package club.auth.hydraware.mixin.mixins;

import org.spongepowered.asm.mixin.*;
import net.minecraft.client.gui.*;
import org.spongepowered.asm.mixin.injection.callback.*;
import club.auth.hydraware.*;
import net.minecraft.util.text.*;
import org.spongepowered.asm.mixin.injection.*;

@Mixin({ GuiMainMenu.class })
public class MixinGuiMainMenu extends GuiScreen
{
    @Inject(method = { "drawScreen" }, at = { @At("TAIL") }, cancellable = true)
    public void drawText(final CallbackInfo ci) {
        HydraWare.fontManager.drawStringWithShadow(TextFormatting.BLACK + "HydraWare " + TextFormatting.GRAY + "++", 1.0f, 1.0f, -51);
    }
}
