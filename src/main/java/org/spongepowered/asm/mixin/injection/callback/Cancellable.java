//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Users\User\Desktop\Source\Minecraft-Deobfuscator3000-master\1.12 stable mappings"!

//Decompiled by Procyon!

package org.spongepowered.asm.mixin.injection.callback;

public interface Cancellable
{
    boolean isCancellable();
    
    boolean isCancelled();
    
    void cancel() throws CancellationException;
}
