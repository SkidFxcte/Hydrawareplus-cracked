//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Users\User\Desktop\Source\Minecraft-Deobfuscator3000-master\1.12 stable mappings"!

//Decompiled by Procyon!

package me.zero.alpine.type;

public class Cancellable
{
    private boolean cancelled;
    
    public final void cancel() {
        this.cancelled = true;
    }
    
    public final boolean isCancelled() {
        return this.cancelled;
    }
}
