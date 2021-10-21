//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Users\User\Desktop\Source\Minecraft-Deobfuscator3000-master\1.12 stable mappings"!

//Decompiled by Procyon!

package com.lukflug.panelstudio.hud;

import com.lukflug.panelstudio.settings.*;
import com.lukflug.panelstudio.theme.*;
import java.util.*;
import com.lukflug.panelstudio.*;

public class HUDClickGUI extends ClickGUI implements Toggleable
{
    protected List<FixedComponent> allComponents;
    protected List<FixedComponent> hudComponents;
    protected boolean guiOpen;
    
    public HUDClickGUI(final Interface inter, final DescriptionRenderer descriptionRenderer) {
        super(inter, descriptionRenderer);
        this.allComponents = new ArrayList<FixedComponent>();
        this.hudComponents = new ArrayList<FixedComponent>();
        this.guiOpen = false;
        this.components = this.hudComponents;
    }
    
    public void addComponent(final FixedComponent component) {
        this.allComponents.add(component);
        this.permanentComponents.add(component);
    }
    
    public void showComponent(final FixedComponent component) {
        if (!this.allComponents.contains(component)) {
            this.allComponents.add(component);
            if (this.guiOpen) {
                component.enter(this.getContext(component, false));
            }
        }
    }
    
    public void hideComponent(final FixedComponent component) {
        if (!this.permanentComponents.contains(component) && this.allComponents.remove(component) && this.guiOpen) {
            component.exit(this.getContext(component, false));
        }
    }
    
    public void addHUDComponent(final FixedComponent component) {
        this.hudComponents.add(component);
        this.allComponents.add(component);
        this.permanentComponents.add(component);
    }
    
    public void enter() {
        this.components = this.allComponents;
        this.guiOpen = true;
        this.doComponentLoop((context, component) -> {
            if (!this.hudComponents.contains(component)) {
                component.enter(context);
            }
        });
    }
    
    public void exit() {
        this.guiOpen = false;
        this.doComponentLoop((context, component) -> {
            if (!this.hudComponents.contains(component)) {
                component.exit(context);
            }
        });
        this.components = this.hudComponents;
    }
    
    public void toggle() {
        if (!this.guiOpen) {
            this.enter();
        }
        else {
            this.exit();
        }
    }
    
    public boolean isOn() {
        return this.guiOpen;
    }
    
    public Toggleable getComponentToggleable(final FixedComponent component) {
        return new Toggleable() {
            @Override
            public void toggle() {
                if (this.isOn()) {
                    HUDClickGUI.this.hideComponent(component);
                }
                else {
                    HUDClickGUI.this.showComponent(component);
                }
            }
            
            @Override
            public boolean isOn() {
                return HUDClickGUI.this.allComponents.contains(component);
            }
        };
    }
}
