package club.auth.hydraware.module.modules.combat;

import club.auth.hydraware.module.*;
import net.minecraft.item.*;
import net.minecraft.util.math.*;
import net.minecraft.network.*;
import net.minecraft.network.play.client.*;

public class Quiver extends Module
{
    public Quiver() {
        super("Quiver", "Shoots Positive Arrow Effects At You!", 0, Module.Category.COMBAT);
    }
    
    public void update() {
        if (Quiver.mc.player.inventory.getCurrentItem().getItem() instanceof ItemBow && Quiver.mc.player.isHandActive() && Quiver.mc.player.getItemInUseMaxCount() >= 3) {
            Quiver.mc.player.connection.sendPacket((Packet)new CPacketPlayerDigging(CPacketPlayerDigging.Action.RELEASE_USE_ITEM, BlockPos.ORIGIN, Quiver.mc.player.getHorizontalFacing()));
            Quiver.mc.player.connection.sendPacket((Packet)new CPacketPlayerTryUseItem(Quiver.mc.player.getActiveHand()));
            Quiver.mc.player.stopActiveHand();
        }
    }
}
