//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Users\User\Desktop\Source\Minecraft-Deobfuscator3000-master\1.12 stable mappings"!

//Decompiled by Procyon!

package com.lukflug.panelstudio.hud;

import java.awt.*;

public interface HUDList
{
    int getSize();
    
    String getItem(final int p0);
    
    Color getItemColor(final int p0);
    
    boolean sortUp();
    
    boolean sortRight();
}
