//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Users\User\Desktop\Source\Minecraft-Deobfuscator3000-master\1.12 stable mappings"!

//Decompiled by Procyon!

package com.lukflug.panelstudio.mc12;

import net.minecraft.client.*;
import net.minecraft.client.gui.*;
import com.lukflug.panelstudio.hud.*;
import com.lukflug.panelstudio.*;

public abstract class MinecraftHUDGUI extends MinecraftGUI
{
    protected boolean hudEditor;
    
    public MinecraftHUDGUI() {
        this.hudEditor = false;
    }
    
    public void enterGUI() {
        this.hudEditor = false;
        super.enterGUI();
    }
    
    public void exitGUI() {
        this.hudEditor = false;
        super.exitGUI();
    }
    
    public void enterHUDEditor() {
        this.hudEditor = true;
        if (this.getHUDGUI().isOn()) {
            this.getHUDGUI().toggle();
        }
        Minecraft.getMinecraft().displayGuiScreen((GuiScreen)this);
    }
    
    public void render() {
        if (!this.getHUDGUI().isOn() && !this.hudEditor) {
            this.renderGUI();
        }
    }
    
    public void handleKeyEvent(final int scancode) {
        if (scancode != 1 && !this.getHUDGUI().isOn() && !this.hudEditor) {
            this.getHUDGUI().handleKey(scancode);
        }
    }
    
    protected abstract HUDClickGUI getHUDGUI();
    
    protected ClickGUI getGUI() {
        return (ClickGUI)this.getHUDGUI();
    }
}
