package club.auth.hydraware.module.modules.player;

import club.auth.hydraware.module.*;
import org.lwjgl.input.*;
import net.minecraft.network.play.client.*;
import net.minecraft.network.*;
import net.minecraft.util.*;
import net.minecraft.entity.player.*;
import net.minecraft.world.*;
import net.minecraft.item.*;

public class MCP extends Module
{
    private boolean clicked;
    
    public MCP() {
        super("MCP", "Middle click pearl.", 0, Module.Category.PLAYER);
        this.clicked = false;
    }
    
    public void update() {
        if (Mouse.isButtonDown(2)) {
            if (!this.clicked) {
                this.throwPearl();
            }
            this.clicked = true;
        }
        else {
            this.clicked = false;
        }
    }
    
    private void throwPearl() {
        final int oldslot = MCP.mc.player.inventory.currentItem;
        for (int i = 0; i < 9; ++i) {
            final ItemStack Stack = MCP.mc.player.inventory.getStackInSlot(i);
            if (!MCP.mc.player.inventory.getStackInSlot(i).isEmpty()) {
                if (Stack.getItem() instanceof ItemEnderPearl) {
                    MCP.mc.player.connection.sendPacket((Packet)new CPacketHeldItemChange(i));
                    MCP.mc.playerController.updateController();
                    break;
                }
            }
        }
        MCP.mc.playerController.processRightClick((EntityPlayer)MCP.mc.player, (World)MCP.mc.world, EnumHand.MAIN_HAND);
        MCP.mc.player.connection.sendPacket((Packet)new CPacketHeldItemChange(oldslot));
        MCP.mc.playerController.updateController();
    }
}
