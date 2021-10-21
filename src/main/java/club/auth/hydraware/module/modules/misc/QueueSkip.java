package club.auth.hydraware.module.modules.misc;

import club.auth.hydraware.module.*;
import club.auth.hydraware.event.events.*;
import me.zero.alpine.listener.*;
import java.util.function.*;
import net.minecraft.network.play.server.*;

public class QueueSkip extends Module
{
    @EventHandler
    private final Listener<PacketEvent.Receive> receiveListener;
    
    public QueueSkip() {
        super("QueueSkip", "Makes Hausemaster Cry!", 0, Module.Category.MISC);
        this.receiveListener = (Listener<PacketEvent.Receive>)new Listener(event -> {
            if (event.getPacket() instanceof SPacketEntityVelocity && ((SPacketEntityVelocity)event.getPacket()).getEntityID() == QueueSkip.mc.player.getEntityId()) {
                event.cancel();
            }
            if (event.getPacket() instanceof SPacketExplosion) {
                event.cancel();
            }
        }, new Predicate[0]);
    }
}
