//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Users\User\Desktop\Source\Minecraft-Deobfuscator3000-master\1.12 stable mappings"!

//Decompiled by Procyon!

package com.lukflug.panelstudio.settings;

import com.lukflug.panelstudio.theme.*;
import com.lukflug.panelstudio.*;

public class KeybindComponent extends FocusableComponent
{
    protected KeybindSetting keybind;
    
    public KeybindComponent(final Renderer renderer, final KeybindSetting keybind) {
        super("Keybind: ¡ì7", (String)null, renderer);
        this.keybind = keybind;
    }
    
    public void render(final Context context) {
        super.render(context);
        String text = this.title + this.keybind.getKeyName();
        if (this.hasFocus(context)) {
            text = this.title + "...";
        }
        this.renderer.renderTitle(context, text, this.hasFocus(context));
    }
    
    public void handleButton(final Context context, final int button) {
        super.handleButton(context, button);
        context.setHeight(this.renderer.getHeight(false));
        final boolean isSelected = this.hasFocus(context);
        super.handleButton(context, button);
        if (isSelected && !this.hasFocus(context)) {
            this.keybind.setKey(0);
        }
    }
    
    public void handleKey(final Context context, final int scancode) {
        super.handleKey(context, scancode);
        if (this.hasFocus(context)) {
            this.keybind.setKey(scancode);
            this.releaseFocus();
        }
    }
    
    public void exit(final Context context) {
        super.exit(context);
        if (this.hasFocus(context)) {
            this.keybind.setKey(0);
            this.releaseFocus();
        }
    }
}
