package club.auth.hydraware.module.modules.movement;

import club.auth.hydraware.module.*;
import net.minecraft.init.*;

public class IceSpeed extends Module
{
    public IceSpeed() {
        super("IceSpeed", "", 0, Module.Category.MOVEMENT);
    }
    
    public void update() {
        Blocks.ICE.slipperiness = 0.4f;
        Blocks.PACKED_ICE.slipperiness = 0.4f;
        Blocks.FROSTED_ICE.slipperiness = 0.4f;
    }
    
    public void onDisable() {
        Blocks.ICE.slipperiness = 0.98f;
        Blocks.PACKED_ICE.slipperiness = 0.98f;
        Blocks.FROSTED_ICE.slipperiness = 0.98f;
    }
}
