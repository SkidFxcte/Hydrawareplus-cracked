package club.auth.hydraware.module.modules.movement;

import club.auth.hydraware.module.*;
import net.minecraft.client.settings.*;

public class AutoWalk extends Module
{
    public AutoWalk() {
        super("AutoWalk", "Presses the move forward key.", 0, Module.Category.MOVEMENT);
    }
    
    public void update() {
        KeyBinding.setKeyBindState(AutoWalk.mc.gameSettings.keyBindForward.getKeyCode(), true);
    }
}
