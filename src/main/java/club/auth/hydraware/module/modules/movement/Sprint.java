package club.auth.hydraware.module.modules.movement;

import club.auth.hydraware.module.*;
import java.util.*;
import club.auth.hydraware.setting.settings.*;
import net.minecraft.client.settings.*;

public class Sprint extends Module
{
    ArrayList<String> modes;
    SettingMode mode;
    
    public Sprint() {
        super("Sprint", "Automatic sprints.", 0, Module.Category.MOVEMENT);
        this.modes = new ArrayList<String>();
        this.mode = this.register("Mode", (ArrayList)this.modes, "Rage");
        this.modes.add("Legit");
        this.modes.add("Rage");
    }
    
    public void onDisable() {
        if (Sprint.mc.world != null) {
            Sprint.mc.player.setSprinting(false);
        }
    }
    
    public void update() {
        if (this.mode.getValue().equals("Legit") && Sprint.mc.gameSettings.keyBindForward.isKeyDown() && !Sprint.mc.player.isSneaking() && !Sprint.mc.player.isHandActive() && !Sprint.mc.player.collidedHorizontally && Sprint.mc.currentScreen == null && Sprint.mc.player.getFoodStats().getFoodLevel() > 6.0f) {
            Sprint.mc.player.setSprinting(true);
        }
        if (this.mode.getValue().equals("Rage") && (Sprint.mc.gameSettings.keyBindForward.isKeyDown() || Sprint.mc.gameSettings.keyBindBack.isKeyDown() || Sprint.mc.gameSettings.keyBindLeft.isKeyDown() || Sprint.mc.gameSettings.keyBindRight.isKeyDown()) && !Sprint.mc.player.isSneaking() && !Sprint.mc.player.collidedHorizontally && Sprint.mc.player.getFoodStats().getFoodLevel() > 6.0f) {
            Sprint.mc.player.setSprinting(true);
        }
        KeyBinding.setKeyBindState(Sprint.mc.gameSettings.keyBindSprint.getKeyCode(), true);
    }
}
