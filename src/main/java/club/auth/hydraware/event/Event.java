package club.auth.hydraware.event;

import me.zero.alpine.type.*;
import net.minecraft.client.*;

public class Event extends Cancellable
{
    private Era era;
    private float partialTicks;
    
    public Event() {
        this.partialTicks = Minecraft.getMinecraft().getRenderPartialTicks();
    }
    
    public Event(final Era era) {
        this.era = era;
        this.partialTicks = Minecraft.getMinecraft().getRenderPartialTicks();
    }
    
    public Era getEra() {
        return this.era;
    }
    
    public void setEra(final Era era) {
        this.era = era;
    }
    
    public float getPartialTicks() {
        return this.partialTicks;
    }
    
    public void setPartialTicks(final float partialTicks) {
        this.partialTicks = partialTicks;
    }
    
    public enum Era
    {
        PRE, 
        POST, 
        PERI;
    }
}
