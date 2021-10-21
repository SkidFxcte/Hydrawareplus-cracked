//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Users\User\Desktop\Source\Minecraft-Deobfuscator3000-master\1.12 stable mappings"!

//Decompiled by Procyon!

package club.auth.hydraware.gui;

import java.awt.*;
import java.util.*;

public class ContainerComponent implements IComponent
{
    private final Rectangle rect;
    private final int offsetX;
    private final int offsetY;
    private final int componentGap;
    private final List<IComponent> children;
    
    public ContainerComponent(final int offsetX, final int offsetY, final int componentGap) {
        this.rect = new Rectangle();
        this.children = new ArrayList<IComponent>();
        this.offsetX = offsetX;
        this.offsetY = offsetY;
        this.componentGap = componentGap;
    }
    
    @Override
    public void draw() {
        IComponent.fillRect(this.rect, new Color(42, 28, 50, 200));
        this.children.forEach(IComponent::draw);
    }
    
    @Override
    public void handleButton(final int btn) {
        this.children.forEach(c -> c.handleButton(btn));
    }
    
    @Override
    public void keyTyped(final int key, final char ch) {
        this.children.forEach(c -> c.keyTyped(key, ch));
    }
    
    @Override
    public int getAbsoluteHeight() {
        return (this.children.size() > 0) ? (this.children.stream().mapToInt(c -> c.getAbsoluteHeight() + this.componentGap).sum() - this.componentGap) : 0;
    }
    
    @Override
    public void addChild(final IComponent component) {
        this.children.add(component);
    }
    
    @Override
    public Rectangle getRect() {
        return this.rect;
    }
    
    @Override
    public void setRect(final Rectangle rect1) {
        int offset = this.offsetY;
        for (final IComponent comp : this.children) {
            final Rectangle rect2 = new Rectangle(rect1.x + this.offsetX, rect1.y + rect1.height + offset, rect1.width - this.offsetX * 2, rect1.height);
            comp.setRect(rect2);
            offset += comp.getAbsoluteHeight() + this.componentGap;
        }
        this.rect.setRect(rect1.x, rect1.y + rect1.height, rect1.width, offset - this.componentGap + this.offsetY);
    }
}
