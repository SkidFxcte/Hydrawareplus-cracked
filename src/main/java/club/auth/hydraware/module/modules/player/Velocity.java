package club.auth.hydraware.module.modules.player;

import club.auth.hydraware.module.*;
import club.auth.hydraware.event.events.*;
import me.zero.alpine.listener.*;
import java.util.function.*;
import net.minecraft.network.play.server.*;

public class Velocity extends Module
{
    @EventHandler
    private final Listener<PacketEvent.Receive> receiveListener;
    
    public Velocity() {
        super("Velocity", "Removes knockback.", 0, Module.Category.PLAYER);
        this.receiveListener = (Listener<PacketEvent.Receive>)new Listener(event -> {
            if (event.getPacket() instanceof SPacketEntityVelocity && ((SPacketEntityVelocity)event.getPacket()).getEntityID() == Velocity.mc.player.getEntityId()) {
                event.cancel();
            }
            if (event.getPacket() instanceof SPacketExplosion) {
                event.cancel();
            }
        }, new Predicate[0]);
    }
}
