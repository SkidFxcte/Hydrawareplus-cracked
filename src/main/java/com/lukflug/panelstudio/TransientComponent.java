//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Users\User\Desktop\Source\Minecraft-Deobfuscator3000-master\1.12 stable mappings"!

//Decompiled by Procyon!

package com.lukflug.panelstudio;

import com.lukflug.panelstudio.settings.*;
import com.lukflug.panelstudio.theme.*;

public class TransientComponent extends FocusableComponent
{
    protected Toggleable toggle;
    protected FixedComponent component;
    protected PanelManager manager;
    
    public TransientComponent(final String title, final String description, final Renderer renderer, final Toggleable toggle, final FixedComponent component, final PanelManager manager) {
        super(title, description, renderer);
        this.toggle = toggle;
        this.component = component;
        this.manager = manager;
    }
    
    public void render(final Context context) {
        super.render(context);
        this.renderer.renderTitle(context, this.title, this.hasFocus(context), this.toggle.isOn(), this.manager.getComponentToggleable(this.component).isOn());
    }
    
    public void handleButton(final Context context, final int button) {
        super.handleButton(context, button);
        if (button == 0 && context.isClicked()) {
            this.toggle.toggle();
        }
        else if (context.isHovered() && button == 1 && context.getInterface().getButton(1)) {
            this.manager.getComponentToggleable(this.component).toggle();
            context.releaseFocus();
        }
    }
}
