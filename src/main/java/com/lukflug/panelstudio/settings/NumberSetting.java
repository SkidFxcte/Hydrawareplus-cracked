//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Users\User\Desktop\Source\Minecraft-Deobfuscator3000-master\1.12 stable mappings"!

//Decompiled by Procyon!

package com.lukflug.panelstudio.settings;

public interface NumberSetting
{
    double getNumber();
    
    void setNumber(final double p0);
    
    double getMaximumValue();
    
    double getMinimumValue();
    
    int getPrecision();
}
