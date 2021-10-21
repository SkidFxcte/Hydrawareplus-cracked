//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Users\User\Desktop\Source\Minecraft-Deobfuscator3000-master\1.12 stable mappings"!

//Decompiled by Procyon!

package com.lukflug.panelstudio.tabgui;

import java.awt.*;
import com.lukflug.panelstudio.*;

public class TabGUI extends TabGUIContainer implements FixedComponent
{
    protected Point position;
    protected int width;
    
    public TabGUI(final String title, final TabGUIRenderer renderer, final Animation animation, final Point position, final int width) {
        super(title, renderer, animation);
        this.position = position;
        this.width = width;
    }
    
    public Point getPosition(final Interface inter) {
        return new Point(this.position);
    }
    
    public void setPosition(final Interface inter, final Point position) {
        this.position = position;
    }
    
    public int getWidth(final Interface inter) {
        return this.width;
    }
    
    public void saveConfig(final Interface inter, final PanelConfig config) {
        config.savePositon(this.position);
    }
    
    public void loadConfig(final Interface inter, final PanelConfig config) {
        final Point pos = config.loadPosition();
        if (pos != null) {
            this.position = pos;
        }
    }
}
