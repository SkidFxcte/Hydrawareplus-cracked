//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Users\User\Desktop\Source\Minecraft-Deobfuscator3000-master\1.12 stable mappings"!

//Decompiled by Procyon!

package club.auth.hydraware.gui;

import club.auth.hydraware.module.*;
import org.lwjgl.input.*;
import java.awt.*;

public class KeybindComponent extends AbstractComponent
{
    private final Module module;
    private boolean listening;
    
    public KeybindComponent(final Module module) {
        super(new Rectangle());
        this.listening = false;
        this.module = module;
    }
    
    public void draw() {
        IComponent.fillRect(this.rect, this.listening ? new Color(110, 110, 191, 170) : new Color(78, 65, 119, 120));
        IComponent.drawString("Bind: " + (this.listening ? "..." : Keyboard.getKeyName(this.module.getKey())), new Point(this.rect.x + 1, this.rect.y + 2), Color.WHITE);
    }
    
    public void handleButton(final int btn) {
        if (this.rect.contains(Screen.MOUSE) && btn != -1) {
            this.listening = !this.listening;
        }
    }
    
    public void keyTyped(final int key, final char ch) {
        if (this.listening) {
            if (key == 14 || key == 211) {
                this.module.setKey(0);
                return;
            }
            this.module.setKey(key);
            this.listening = false;
        }
    }
}
