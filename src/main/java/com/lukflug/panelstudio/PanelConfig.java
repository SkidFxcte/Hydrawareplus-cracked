//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Users\User\Desktop\Source\Minecraft-Deobfuscator3000-master\1.12 stable mappings"!

//Decompiled by Procyon!

package com.lukflug.panelstudio;

import java.awt.*;

public interface PanelConfig
{
    void savePositon(final Point p0);
    
    Point loadPosition();
    
    void saveState(final boolean p0);
    
    boolean loadState();
}
