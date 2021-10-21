//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Users\User\Desktop\Source\Minecraft-Deobfuscator3000-master\1.12 stable mappings"!

//Decompiled by Procyon!

package com.lukflug.panelstudio.settings;

import com.lukflug.panelstudio.theme.*;
import com.lukflug.panelstudio.*;

public class BooleanComponent extends FocusableComponent
{
    protected Toggleable setting;
    
    public BooleanComponent(final String title, final String description, final Renderer renderer, final Toggleable setting) {
        super(title, description, renderer);
        this.setting = setting;
    }
    
    public void render(final Context context) {
        super.render(context);
        this.renderer.renderTitle(context, this.title, this.hasFocus(context), this.setting.isOn());
    }
    
    public void handleButton(final Context context, final int button) {
        super.handleButton(context, button);
        if (button == 0 && context.isClicked()) {
            this.setting.toggle();
        }
    }
}
