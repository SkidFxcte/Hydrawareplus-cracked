package club.auth.hydraware.module.modules.combat;

import club.auth.hydraware.module.*;
import club.auth.hydraware.setting.settings.*;
import net.minecraft.client.entity.*;

public class Anchor extends Module
{
    SettingDouble speed;
    
    public Anchor() {
        super("Anchor", "", 0, Module.Category.MOVEMENT);
        this.speed = this.register("Speed", 3.0, 0.0, 20.0);
    }
    
    public void update() {
        if (Anchor.mc.player.isInWater() || Anchor.mc.player.isInLava()) {
            return;
        }
        if (Anchor.mc.player.onGround) {
            final EntityPlayerSP player = Anchor.mc.player;
            player.motionY -= this.speed.getValue() / 5.0;
        }
    }
}
