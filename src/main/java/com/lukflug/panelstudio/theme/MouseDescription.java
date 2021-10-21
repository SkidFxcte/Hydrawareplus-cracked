//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Users\User\Desktop\Source\Minecraft-Deobfuscator3000-master\1.12 stable mappings"!

//Decompiled by Procyon!

package com.lukflug.panelstudio.theme;

import com.lukflug.panelstudio.*;
import java.awt.*;

public class MouseDescription implements DescriptionRenderer
{
    protected Point offset;
    
    public MouseDescription(final Point offset) {
        this.offset = offset;
    }
    
    public void renderDescription(final Context context) {
        if (context.getDescription() != null) {
            final Point pos = context.getInterface().getMouse();
            pos.translate(this.offset.x, this.offset.y);
            final Rectangle r = new Rectangle(pos, new Dimension(context.getInterface().getFontWidth(context.getDescription()), context.getInterface().getFontHeight()));
            final Color bgcolor = new Color(0, 0, 0);
            context.getInterface().fillRect(r, bgcolor, bgcolor, bgcolor, bgcolor);
            final Color color = new Color(255, 255, 255);
            context.getInterface().drawRect(r, color, color, color, color);
            context.getInterface().drawString(pos, context.getDescription(), color);
        }
    }
}
