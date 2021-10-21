package club.auth.hydraware.module.modules.combat;

import club.auth.hydraware.module.*;
import net.minecraft.network.*;
import net.minecraft.util.*;
import net.minecraft.network.play.client.*;
import net.minecraft.init.*;

public class SilentEXP extends Module
{
    int prvSlot;
    
    public SilentEXP() {
        super("SilentEXP", "", 0, Module.Category.COMBAT);
    }
    
    public void update() {
        if (SilentEXP.mc.currentScreen == null) {
            this.prvSlot = SilentEXP.mc.player.inventory.currentItem;
            SilentEXP.mc.player.connection.sendPacket((Packet)new CPacketHeldItemChange(this.findExpInHotbar()));
            SilentEXP.mc.player.connection.sendPacket((Packet)new CPacketPlayerTryUseItem(EnumHand.MAIN_HAND));
            SilentEXP.mc.player.inventory.currentItem = this.prvSlot;
            SilentEXP.mc.player.connection.sendPacket((Packet)new CPacketHeldItemChange(this.prvSlot));
        }
    }
    
    private int findExpInHotbar() {
        int slot = 0;
        for (int i = 0; i < 9; ++i) {
            if (SilentEXP.mc.player.inventory.getStackInSlot(i).getItem() == Items.EXPERIENCE_BOTTLE) {
                slot = i;
                break;
            }
        }
        return slot;
    }
}
