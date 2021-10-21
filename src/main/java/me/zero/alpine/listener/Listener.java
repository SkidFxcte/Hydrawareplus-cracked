//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Users\User\Desktop\Source\Minecraft-Deobfuscator3000-master\1.12 stable mappings"!

//Decompiled by Procyon!

package me.zero.alpine.listener;

import java.util.function.*;
import net.jodah.typetools.*;

public final class Listener<T> implements EventHook<T>
{
    private final Class<T> target;
    private final EventHook<T> hook;
    private final Predicate<T>[] filters;
    private final byte priority;
    
    @SafeVarargs
    public Listener(final EventHook<T> hook, final Predicate<T>... filters) {
        this(hook, (byte)3, (Predicate[])filters);
    }
    
    @SafeVarargs
    public Listener(final EventHook<T> hook, final byte priority, final Predicate<T>... filters) {
        this.hook = hook;
        this.priority = priority;
        this.target = (Class<T>)TypeResolver.resolveRawArgument((Class)EventHook.class, (Class)hook.getClass());
        this.filters = filters;
    }
    
    public final Class<T> getTarget() {
        return this.target;
    }
    
    public final byte getPriority() {
        return this.priority;
    }
    
    public final void invoke(final T event) {
        if (this.filters.length > 0) {
            for (final Predicate<T> filter : this.filters) {
                if (!filter.test(event)) {
                    return;
                }
            }
        }
        this.hook.invoke((Object)event);
    }
}
