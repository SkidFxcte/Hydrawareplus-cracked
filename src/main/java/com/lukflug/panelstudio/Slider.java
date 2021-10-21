//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Users\User\Desktop\Source\Minecraft-Deobfuscator3000-master\1.12 stable mappings"!

//Decompiled by Procyon!

package com.lukflug.panelstudio;

import com.lukflug.panelstudio.theme.*;
import java.awt.*;

public abstract class Slider extends FocusableComponent
{
    protected boolean attached;
    
    public Slider(final String title, final String description, final Renderer renderer) {
        super(title, description, renderer);
        this.attached = false;
    }
    
    public void render(final Context context) {
        super.render(context);
        if (this.attached) {
            double value = (context.getInterface().getMouse().x - context.getPos().x) / (double)(context.getSize().width - 1);
            if (value < 0.0) {
                value = 0.0;
            }
            else if (value > 1.0) {
                value = 1.0;
            }
            this.setValue(value);
        }
        if (!context.getInterface().getButton(0)) {
            this.attached = false;
        }
        this.renderer.renderRect(context, "", this.hasFocus(context), false, new Rectangle(new Point(context.getPos().x + (int)(context.getSize().width * this.getValue()), context.getPos().y), new Dimension((int)(context.getSize().width * (1.0 - this.getValue())), this.renderer.getHeight(false))), false);
        this.renderer.renderRect(context, this.title, this.hasFocus(context), true, new Rectangle(context.getPos(), new Dimension((int)(context.getSize().width * this.getValue()), this.renderer.getHeight(false))), true);
    }
    
    public void handleButton(final Context context, final int button) {
        super.handleButton(context, button);
        if (button == 0 && context.isClicked()) {
            this.attached = true;
        }
    }
    
    protected abstract double getValue();
    
    protected abstract void setValue(final double p0);
}
