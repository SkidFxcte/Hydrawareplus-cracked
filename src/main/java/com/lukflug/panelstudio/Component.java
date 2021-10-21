//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Users\User\Desktop\Source\Minecraft-Deobfuscator3000-master\1.12 stable mappings"!

//Decompiled by Procyon!

package com.lukflug.panelstudio;

public interface Component
{
    String getTitle();
    
    void render(final Context p0);
    
    void handleButton(final Context p0, final int p1);
    
    void handleKey(final Context p0, final int p1);
    
    void handleScroll(final Context p0, final int p1);
    
    void getHeight(final Context p0);
    
    void enter(final Context p0);
    
    void exit(final Context p0);
    
    void releaseFocus();
}
