//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Users\User\Desktop\Source\Minecraft-Deobfuscator3000-master\1.12 stable mappings"!

//Decompiled by Procyon!

package com.lukflug.panelstudio.hud;

import com.lukflug.panelstudio.theme.*;
import java.awt.*;
import com.lukflug.panelstudio.*;

public abstract class HUDComponent implements FixedComponent
{
    protected String title;
    protected Renderer renderer;
    protected Point position;
    
    public HUDComponent(final String title, final Renderer renderer, final Point position) {
        this.title = title;
        this.renderer = renderer;
        this.position = position;
    }
    
    public String getTitle() {
        return this.title;
    }
    
    public void render(final Context context) {
        this.getHeight(context);
    }
    
    public void handleButton(final Context context, final int button) {
        this.getHeight(context);
    }
    
    public void handleKey(final Context context, final int scancode) {
        this.getHeight(context);
    }
    
    public void handleScroll(final Context context, final int diff) {
        this.getHeight(context);
    }
    
    public void enter(final Context context) {
        this.getHeight(context);
    }
    
    public void exit(final Context context) {
        this.getHeight(context);
    }
    
    public void releaseFocus() {
    }
    
    public Point getPosition(final Interface inter) {
        return new Point(this.position);
    }
    
    public void setPosition(final Interface inter, final Point position) {
        this.position = position;
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
