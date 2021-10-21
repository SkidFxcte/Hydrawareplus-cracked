//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Users\User\Desktop\Source\Minecraft-Deobfuscator3000-master\1.12 stable mappings"!

//Decompiled by Procyon!

package club.auth.hydraware.gui;

import club.auth.hydraware.setting.settings.*;
import java.awt.*;

public class ModeComponent extends AbstractComponent
{
    private final SettingMode setting;
    
    public ModeComponent(final SettingMode setting) {
        super(new Rectangle());
        this.setting = setting;
    }
    
    public void draw() {
        IComponent.fillRect(this.rect, new Color(20, 20, 20, 120));
        IComponent.fillRect(new Rectangle(this.rect.x, this.rect.y, 12, this.rect.height), new Color(42, 28, 50, 200));
        IComponent.fillRect(new Rectangle(this.rect.x + this.rect.width - 12, this.rect.y, 12, this.rect.height), new Color(42, 28, 50, 200));
        IComponent.drawString(this.setting.getName() + ": " + this.setting.getValue(), new Point(this.rect.x + 20, this.rect.y + 2), Color.WHITE);
    }
    
    public void handleButton(final int btn) {
        if (this.rect.contains(Screen.MOUSE)) {
            if (btn == 0) {
                this.setting.increment();
            }
            else if (btn == 1) {
                this.setting.decrement();
            }
        }
    }
}
