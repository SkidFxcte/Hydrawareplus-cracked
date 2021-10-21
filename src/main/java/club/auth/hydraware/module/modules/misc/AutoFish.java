package club.auth.hydraware.module.modules.misc;

import club.auth.hydraware.module.*;
import club.auth.hydraware.event.events.*;
import me.zero.alpine.listener.*;
import java.util.function.*;
import net.minecraft.network.play.server.*;
import net.minecraft.init.*;
import net.minecraft.item.*;
import net.minecraft.util.*;
import net.minecraft.network.play.client.*;
import net.minecraft.network.*;

public class AutoFish extends Module
{
    @EventHandler
    private final Listener<PacketEvent.Receive> receiveListener;
    
    public AutoFish() {
        super("AutoFish", "Fishes automatically.", 0, Module.Category.MISC);
        this.receiveListener = (Listener<PacketEvent.Receive>)new Listener(event -> {
            if (event.getPacket() instanceof SPacketSoundEffect) {
                final SPacketSoundEffect packet = (SPacketSoundEffect)event.getPacket();
                if (packet.getSound().equals(SoundEvents.ENTITY_BOBBER_SPLASH)) {
                    if (AutoFish.mc.player.getHeldItemMainhand().getItem() instanceof ItemFishingRod) {
                        AutoFish.mc.player.connection.sendPacket((Packet)new CPacketPlayerTryUseItem(EnumHand.MAIN_HAND));
                        AutoFish.mc.player.swingArm(EnumHand.MAIN_HAND);
                        AutoFish.mc.player.connection.sendPacket((Packet)new CPacketPlayerTryUseItem(EnumHand.MAIN_HAND));
                        AutoFish.mc.player.swingArm(EnumHand.MAIN_HAND);
                    }
                    if (AutoFish.mc.player.getHeldItemOffhand().getItem() instanceof ItemFishingRod) {
                        AutoFish.mc.player.connection.sendPacket((Packet)new CPacketPlayerTryUseItem(EnumHand.OFF_HAND));
                        AutoFish.mc.player.swingArm(EnumHand.OFF_HAND);
                        AutoFish.mc.player.connection.sendPacket((Packet)new CPacketPlayerTryUseItem(EnumHand.OFF_HAND));
                        AutoFish.mc.player.swingArm(EnumHand.OFF_HAND);
                    }
                }
            }
        }, new Predicate[0]);
    }
}
