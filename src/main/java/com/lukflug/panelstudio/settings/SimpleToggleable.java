//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Users\User\Desktop\Source\Minecraft-Deobfuscator3000-master\1.12 stable mappings"!

//Decompiled by Procyon!

package com.lukflug.panelstudio.settings;

public class SimpleToggleable implements Toggleable
{
    private boolean value;
    
    public SimpleToggleable(final boolean value) {
        this.value = value;
    }
    
    @Override
    public void toggle() {
        this.value = !this.value;
    }
    
    @Override
    public boolean isOn() {
        return this.value;
    }
}
