package club.auth.hydraware.event.events;

import club.auth.hydraware.event.*;
import net.minecraft.client.*;
import net.minecraft.entity.*;

public class PushEvent extends Event
{
    public static final Minecraft mc;
    public double x;
    public double y;
    public double z;
    public Entity entity;
    
    public PushEvent(final Entity entity, final double x, final double y, final double z) {
        this.entity = entity;
        this.x = x;
        this.y = y;
        this.z = z;
    }
    
    static {
        mc = Minecraft.getMinecraft();
    }
}
