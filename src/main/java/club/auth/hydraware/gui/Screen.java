//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Users\User\Desktop\Source\Minecraft-Deobfuscator3000-master\1.12 stable mappings"!

//Decompiled by Procyon!

package club.auth.hydraware.gui;

import net.minecraft.client.gui.*;
import java.util.*;
import club.auth.hydraware.module.*;
import java.awt.*;
import club.auth.hydraware.*;
import club.auth.hydraware.setting.settings.*;
import club.auth.hydraware.setting.*;

public class Screen extends GuiScreen
{
    public static final Point MOUSE;
    private final List<IComponent> PANELS;
    
    public Screen() {
        this.PANELS = new ArrayList<IComponent>();
        final Point offset = new Point(10, 10);
        for (final Module.Category cat : Module.Category.values()) {
            final PanelComponent panel = new PanelComponent(new Rectangle(new Point(offset), new Dimension(100, 10)), cat.name());
            final HydraWare instance = HydraWare.instance;
            final ModuleComponent module;
            final HydraWare instance2;
            final ModuleComponent moduleComponent;
            final PanelComponent panelComponent;
            HydraWare.moduleManager.getModsInCategory(cat).forEach(m -> {
                module = new ModuleComponent(m);
                instance2 = HydraWare.instance;
                HydraWare.settingsManager.getSettingsInMod(m).forEach(s -> {
                    switch (s.getType()) {
                        case INTEGER: {
                            moduleComponent.addChild((IComponent)new SliderInteger((SettingInteger)s));
                            break;
                        }
                        case BOOLEAN: {
                            moduleComponent.addChild((IComponent)new BooleanComponent((SettingBoolean)s));
                            break;
                        }
                        case DOUBLE: {
                            moduleComponent.addChild((IComponent)new SliderDouble((SettingDouble)s));
                            break;
                        }
                        case MODE: {
                            moduleComponent.addChild((IComponent)new ModeComponent((SettingMode)s));
                            break;
                        }
                    }
                    return;
                });
                module.addChild((IComponent)new KeybindComponent(m));
                panelComponent.addChild((IComponent)module);
                return;
            });
            this.PANELS.add((IComponent)panel);
            offset.translate(120, 0);
        }
    }
    
    public void drawScreen(final int mouseX, final int mouseY, final float partialTicks) {
        Screen.MOUSE.setLocation(mouseX, mouseY);
        this.PANELS.forEach(IComponent::draw);
    }
    
    protected void mouseClicked(final int mouseX, final int mouseY, final int mouseButton) {
        Screen.MOUSE.setLocation(mouseX, mouseY);
        this.PANELS.forEach(p -> p.handleButton(mouseButton));
    }
    
    protected void mouseReleased(final int mouseX, final int mouseY, final int state) {
        Screen.MOUSE.setLocation(mouseX, mouseY);
        this.PANELS.forEach(p -> p.handleButton(-1));
    }
    
    protected void keyTyped(final char typedChar, final int keyCode) {
        if (keyCode == 1) {
            this.mc.displayGuiScreen((GuiScreen)null);
        }
        this.PANELS.forEach(p -> p.keyTyped(keyCode, typedChar));
    }
    
    static {
        MOUSE = new Point();
    }
}
