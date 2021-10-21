//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Users\User\Desktop\Source\Minecraft-Deobfuscator3000-master\1.12 stable mappings"!

//Decompiled by Procyon!

package club.auth.hydraware.gui;

import club.auth.hydraware.setting.settings.*;
import java.awt.*;
import net.minecraft.util.math.*;

public class SliderInteger extends AbstractComponent
{
    private final SettingInteger setting;
    private boolean sliding;
    
    public SliderInteger(final SettingInteger setting) {
        super(new Rectangle());
        this.sliding = false;
        this.setting = setting;
    }
    
    public void draw() {
        final double Multiplier = (this.setting.getValue() - this.setting.getMin()) / (double)(this.setting.getMax() - this.setting.getMin());
        IComponent.fillRect(this.rect, new Color(70, 70, 70, 140));
        IComponent.fillRect(new Rectangle(this.rect.x, this.rect.y, (int)(this.rect.width * Multiplier), this.rect.height), new Color(42, 28, 50, 200));
        IComponent.drawString(this.setting.getName() + ": " + this.setting.getValue(), new Point(this.rect.x + 1, this.rect.y + 2), Color.WHITE);
        if (this.sliding) {
            final double diff = MathHelper.clamp((Screen.MOUSE.getX() - this.rect.getX()) / (this.rect.getWidth() - 1.0), 0.0, 1.0);
            this.setting.setValue((int)((this.setting.getMax() - this.setting.getMin()) * diff + this.setting.getMin()));
        }
    }
    
    public void handleButton(final int btn) {
        if (btn != -1 && this.rect.contains(Screen.MOUSE)) {
            this.sliding = true;
        }
        else if (this.sliding) {
            this.sliding = false;
        }
    }
}
