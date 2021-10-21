package club.auth.hydraware.gui;

import club.auth.hydraware.module.*;
import java.awt.*;

public class ModuleComponent extends AbstractComponent
{
    private final Module module;
    private final ContainerComponent container;
    private boolean opened;
    
    public ModuleComponent(final Module module) {
        super(new Rectangle());
        this.container = new ContainerComponent(2, 2, 4);
        this.opened = false;
        this.module = module;
    }
    
    public void draw() {
        IComponent.fillRect(this.rect, this.module.isToggled() ? new Color(110, 110, 191, 170) : new Color(78, 65, 119, 120));
        IComponent.drawString(this.module.getName(), new Point(this.rect.x + 1, this.rect.y + 2), Color.WHITE);
        if (this.opened) {
            this.container.setRect(this.rect);
            this.container.draw();
        }
    }
    
    public void handleButton(final int btn) {
        if (this.rect.contains(Screen.MOUSE)) {
            if (btn == 0) {
                this.module.toggle();
            }
            else if (btn == 1) {
                this.opened = !this.opened;
            }
        }
        if (this.opened) {
            this.container.handleButton(btn);
        }
    }
    
    public void keyTyped(final int key, final char ch) {
        if (this.opened) {
            this.container.keyTyped(key, ch);
        }
    }
    
    public int getAbsoluteHeight() {
        return this.rect.height + (this.opened ? this.container.getAbsoluteHeight() : 0);
    }
    
    public void addChild(final IComponent component) {
        this.container.addChild(component);
    }
}
