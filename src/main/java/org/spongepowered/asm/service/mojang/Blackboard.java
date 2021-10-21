package org.spongepowered.asm.service.mojang;

import org.spongepowered.asm.service.*;
import net.minecraft.launchwrapper.*;

public class Blackboard implements IGlobalPropertyService
{
    public final <T> T getProperty(final String key) {
        return Launch.blackboard.get(key);
    }
    
    public final void setProperty(final String key, final Object value) {
        Launch.blackboard.put(key, value);
    }
    
    public final <T> T getProperty(final String key, final T defaultValue) {
        final Object value = Launch.blackboard.get(key);
        return (T)((value != null) ? value : defaultValue);
    }
    
    public final String getPropertyString(final String key, final String defaultValue) {
        final Object value = Launch.blackboard.get(key);
        return (value != null) ? value.toString() : defaultValue;
    }
}
