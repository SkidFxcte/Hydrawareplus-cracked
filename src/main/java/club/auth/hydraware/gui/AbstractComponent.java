//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Users\User\Desktop\Source\Minecraft-Deobfuscator3000-master\1.12 stable mappings"!

//Decompiled by Procyon!

package club.auth.hydraware.gui;

import java.awt.*;
import java.awt.geom.*;

public abstract class AbstractComponent implements IComponent
{
    protected final Rectangle rect;
    
    public AbstractComponent(final Rectangle rect) {
        this.rect = rect;
    }
    
    @Override
    public void handleButton(final int btn) {
    }
    
    @Override
    public void keyTyped(final int key, final char ch) {
    }
    
    @Override
    public int getAbsoluteHeight() {
        return this.rect.height;
    }
    
    @Override
    public void addChild(final IComponent component) {
    }
    
    @Override
    public Rectangle getRect() {
        return this.rect;
    }
    
    @Override
    public void setRect(final Rectangle rect1) {
        this.rect.setRect(rect1);
    }
}
