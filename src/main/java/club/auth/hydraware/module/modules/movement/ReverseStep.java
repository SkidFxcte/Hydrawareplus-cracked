package club.auth.hydraware.module.modules.movement;

import club.auth.hydraware.module.*;
import club.auth.hydraware.setting.settings.*;
import net.minecraft.client.entity.*;

public class ReverseStep extends Module
{
    SettingDouble speed;
    
    public ReverseStep() {
        super("ReverseStep", "", 0, Module.Category.MOVEMENT);
        this.speed = this.register("Speed", 5.0, 0.0, 20.0);
    }
    
    public void update() {
        if (ReverseStep.mc.player.isInWater() || ReverseStep.mc.player.isInLava()) {
            return;
        }
        if (ReverseStep.mc.player.onGround) {
            final EntityPlayerSP player = ReverseStep.mc.player;
            player.motionY -= this.speed.getValue() / 10.0;
        }
    }
}
