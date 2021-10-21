package club.auth.hydraware.module.modules.movement;

import club.auth.hydraware.module.*;
import club.auth.hydraware.setting.settings.*;

public class Step extends Module
{
    SettingDouble height;
    SettingBoolean entity;
    
    public Step() {
        super("Step", "Step up blocks.", 0, Module.Category.MOVEMENT);
        this.height = this.register("Height", 2.5, 0.5, 2.0);
        this.entity = this.register("EntityStep", false);
    }
    
    public void update() {
        if (this.entity.getValue() && Step.mc.player.getRidingEntity() != null) {
            Step.mc.player.getRidingEntity().stepHeight = (float)this.height.getValue();
        }
        Step.mc.player.stepHeight = (float)this.height.getValue();
    }
    
    public void onDisable() {
        Step.mc.player.stepHeight = 0.5f;
    }
}
