//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Users\User\Desktop\Source\Minecraft-Deobfuscator3000-master\1.12 stable mappings"!

//Decompiled by Procyon!

package com.lukflug.panelstudio.theme;

import com.lukflug.panelstudio.settings.*;
import java.awt.*;

public class SettingsColorScheme implements ColorScheme
{
    protected final ColorSetting activeColor;
    protected final ColorSetting inactiveColor;
    protected final ColorSetting backgroundColor;
    protected final ColorSetting outlineColor;
    protected final ColorSetting fontColor;
    protected final NumberSetting opacity;
    
    public SettingsColorScheme(final ColorSetting activeColor, final ColorSetting inactiveColor, final ColorSetting backgroundColor, final ColorSetting outlineColor, final ColorSetting fontColor, final NumberSetting opacity) {
        this.activeColor = activeColor;
        this.inactiveColor = inactiveColor;
        this.backgroundColor = backgroundColor;
        this.outlineColor = outlineColor;
        this.fontColor = fontColor;
        this.opacity = opacity;
    }
    
    public Color getActiveColor() {
        return this.activeColor.getValue();
    }
    
    public Color getInactiveColor() {
        return this.inactiveColor.getValue();
    }
    
    public Color getBackgroundColor() {
        return this.backgroundColor.getValue();
    }
    
    public Color getOutlineColor() {
        return this.outlineColor.getValue();
    }
    
    public Color getFontColor() {
        return this.fontColor.getValue();
    }
    
    public int getOpacity() {
        return (int)this.opacity.getNumber();
    }
}
