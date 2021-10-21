package club.auth.hydraware.module.modules.main;

import club.auth.hydraware.module.*;
import club.auth.hydraware.*;
import net.minecraft.client.gui.*;

public class GUI extends Module
{
    public GUI() {
        super("GUI", "Displays Gui screen.", 54, Module.Category.MAIN);
    }
    
    public void onEnable() {
        GUI.mc.displayGuiScreen((GuiScreen)HydraWare.instance.clickGui);
        this.toggle();
    }
}
