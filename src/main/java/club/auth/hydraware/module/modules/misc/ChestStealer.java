package club.auth.hydraware.module.modules.misc;

import club.auth.hydraware.module.*;
import net.minecraft.inventory.*;
import net.minecraft.entity.player.*;
import net.minecraft.item.*;

public class ChestStealer extends Module
{
    public ChestStealer() {
        super("ChestStealer", "", 0, Module.Category.MISC);
    }
    
    public void update() {
        if (ChestStealer.mc.player.openContainer instanceof ContainerChest) {
            final ContainerChest chest = (ContainerChest)ChestStealer.mc.player.openContainer;
            for (int items = 0; items < chest.getLowerChestInventory().getSizeInventory(); ++items) {
                final ItemStack stack = chest.getLowerChestInventory().getStackInSlot(items);
                ChestStealer.mc.playerController.windowClick(chest.windowId, items, 0, ClickType.QUICK_MOVE, (EntityPlayer)ChestStealer.mc.player);
                if (this.isChestEmpty(chest)) {
                    ChestStealer.mc.player.closeScreen();
                }
            }
        }
    }
    
    private boolean isChestEmpty(final ContainerChest chest) {
        final int items = 0;
        if (items < chest.getLowerChestInventory().getSizeInventory()) {
            final ItemStack slot = chest.getLowerChestInventory().getStackInSlot(items);
            return false;
        }
        return true;
    }
}
