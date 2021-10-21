//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Users\User\Desktop\Source\Minecraft-Deobfuscator3000-master\1.12 stable mappings"!

//Decompiled by Procyon!

package com.lukflug.panelstudio.tabgui;

import com.lukflug.panelstudio.settings.*;
import com.lukflug.panelstudio.*;

public class TabGUIItem implements TabGUIComponent
{
    protected String title;
    protected Toggleable toggle;
    
    public TabGUIItem(final String title, final Toggleable toggle) {
        this.title = title;
        this.toggle = toggle;
    }
    
    public String getTitle() {
        return this.title;
    }
    
    public void render(final Context context) {
    }
    
    public void handleButton(final Context context, final int button) {
    }
    
    public void handleKey(final Context context, final int scancode) {
    }
    
    public void handleScroll(final Context context, final int diff) {
    }
    
    public void getHeight(final Context context) {
    }
    
    public void enter(final Context context) {
    }
    
    public void exit(final Context context) {
    }
    
    public boolean isActive() {
        return this.toggle.isOn();
    }
    
    public boolean select() {
        this.toggle.toggle();
        return false;
    }
    
    public void releaseFocus() {
    }
}
