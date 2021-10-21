package club.auth.hydraware.module.modules.combat;

import club.auth.hydraware.module.*;
import club.auth.hydraware.util.*;
import net.minecraft.client.entity.*;

public class BlockLag extends Module
{
    public BlockLag() {
        super("Burrow", "Its just burrow in the name of blocklag.", 0, Module.Category.COMBAT);
    }
    
    public void onEnable() {
        Wrapper.getPlayer().jump();
        final EntityPlayerSP player = Wrapper.getPlayer();
        --player.motionY;
    }
}
