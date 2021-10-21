//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Users\User\Desktop\Source\Minecraft-Deobfuscator3000-master\1.12 stable mappings"!

//Decompiled by Procyon!

package com.lukflug.panelstudio.settings;

import com.lukflug.panelstudio.theme.*;
import com.lukflug.panelstudio.*;

public class NumberComponent extends Slider
{
    protected NumberSetting setting;
    protected String text;
    
    public NumberComponent(final String text, final String description, final Renderer renderer, final NumberSetting setting, final double min, final double max) {
        super("", description, renderer);
        this.setting = setting;
        this.text = text;
    }
    
    @Override
    public void render(final Context context) {
        if (this.setting.getPrecision() == 0) {
            this.title = String.format("%s: ¡ì7%d", this.text, (int)this.setting.getNumber());
        }
        else {
            this.title = String.format("%s: ¡ì7%." + this.setting.getPrecision() + "f", this.text, this.setting.getNumber());
        }
        super.render(context);
    }
    
    @Override
    protected double getValue() {
        return (this.setting.getNumber() - this.setting.getMinimumValue()) / (this.setting.getMaximumValue() - this.setting.getMinimumValue());
    }
    
    @Override
    protected void setValue(final double value) {
        this.setting.setNumber(value * (this.setting.getMaximumValue() - this.setting.getMinimumValue()) + this.setting.getMinimumValue());
    }
}
