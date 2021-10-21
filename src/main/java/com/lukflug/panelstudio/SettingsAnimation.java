//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Users\User\Desktop\Source\Minecraft-Deobfuscator3000-master\1.12 stable mappings"!

//Decompiled by Procyon!

package com.lukflug.panelstudio;

import com.lukflug.panelstudio.settings.*;

public class SettingsAnimation extends Animation
{
    protected final NumberSetting speed;
    
    public SettingsAnimation(final NumberSetting speed) {
        this.speed = speed;
    }
    
    protected int getSpeed() {
        return (int)this.speed.getNumber();
    }
}
