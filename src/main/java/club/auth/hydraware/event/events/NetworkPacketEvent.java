package club.auth.hydraware.event.events;

import club.auth.hydraware.event.*;
import net.minecraft.network.*;

public class NetworkPacketEvent extends Event
{
    public Packet m_Packet;
    
    public NetworkPacketEvent(final Packet p_Packet) {
        this.m_Packet = p_Packet;
    }
    
    public Packet GetPacket() {
        return this.m_Packet;
    }
    
    public Packet getPacket() {
        return this.m_Packet;
    }
}
