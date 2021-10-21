//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Users\User\Desktop\Source\Minecraft-Deobfuscator3000-master\1.12 stable mappings"!

//Decompiled by Procyon!

package me.zero.alpine;

public interface EventBus
{
    void subscribe(final Object p0);
    
    void subscribe(final Object... p0);
    
    void subscribe(final Iterable<Object> p0);
    
    void unsubscribe(final Object p0);
    
    void unsubscribe(final Object... p0);
    
    void unsubscribe(final Iterable<Object> p0);
    
    void post(final Object p0);
    
    void attach(final EventBus p0);
    
    void detach(final EventBus p0);
}
