//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Users\User\Desktop\Source\Minecraft-Deobfuscator3000-master\1.12 stable mappings"!

//Decompiled by Procyon!

package club.auth.hydraware.gui;

import java.awt.*;

public class PanelComponent extends AbstractComponent
{
    private final String name;
    private final ContainerComponent cont;
    private final Point attachPoint;
    private boolean dragging;
    
    public PanelComponent(final Rectangle rect, final String name) {
        super(rect);
        this.cont = new ContainerComponent(4, 2, 5);
        this.attachPoint = new Point();
        this.dragging = false;
        this.name = name;
    }
    
    public void draw() {
        IComponent.fillRect(this.rect, new Color(62, 80, 112, 200));
        IComponent.drawString(this.name, new Point(this.rect.x + 1, this.rect.y + 2), Color.WHITE);
        this.cont.setRect(this.rect);
        this.cont.draw();
        if (this.dragging) {
            this.rect.translate(Screen.MOUSE.x - this.attachPoint.x, Screen.MOUSE.y - this.attachPoint.y);
            this.attachPoint.setLocation(Screen.MOUSE);
        }
    }
    
    public void handleButton(final int btn) {
        if (this.rect.contains(Screen.MOUSE) && btn != -1) {
            this.dragging = true;
            this.attachPoint.setLocation(Screen.MOUSE);
        }
        else if (this.dragging) {
            this.dragging = false;
        }
        this.cont.handleButton(btn);
    }
    
    public void keyTyped(final int key, final char ch) {
        this.cont.keyTyped(key, ch);
    }
    
    public int getAbsoluteHeight() {
        return this.rect.height + this.cont.getAbsoluteHeight();
    }
    
    public void addChild(final IComponent component) {
        this.cont.addChild(component);
    }
}
