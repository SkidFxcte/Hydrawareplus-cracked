package club.auth.hydraware.module;

import net.minecraft.client.*;
import club.auth.hydraware.*;
import net.minecraftforge.common.*;
import com.mojang.realmsclient.gui.*;
import club.auth.hydraware.command.*;
import java.util.*;
import club.auth.hydraware.setting.settings.*;

public class Module
{
    public static final Minecraft mc;
    public String name;
    public String description;
    public int key;
    public Category category;
    public boolean toggled;
    
    public Module(final String name, final String description, final int key, final Category category) {
        this.name = name;
        this.description = description;
        this.key = key;
        this.category = category;
    }
    
    public void enable() {
        HydraWare.EVENT_BUS.subscribe((Object)this);
        MinecraftForge.EVENT_BUS.register((Object)this);
        this.onEnable();
        Messages.sendClientMessage(new String[] { ChatFormatting.BOLD + this.getName() + ChatFormatting.GREEN + " enabled." });
    }
    
    public void disable() {
        HydraWare.EVENT_BUS.unsubscribe((Object)this);
        MinecraftForge.EVENT_BUS.unregister((Object)this);
        this.onDisable();
        Messages.sendClientMessage(new String[] { ChatFormatting.BOLD + this.getName() + ChatFormatting.RED + " disabled." });
    }
    
    public void toggle() {
        this.toggled = !this.toggled;
        if (this.toggled) {
            this.enable();
        }
        else {
            this.disable();
        }
    }
    
    public void update() {
    }
    
    public void render() {
    }
    
    public void onEnable() {
    }
    
    public void onDisable() {
    }
    
    public void onToggle() {
    }
    
    public void onLogin() {
    }
    
    public void onLogout() {
    }
    
    public String getName() {
        return this.name;
    }
    
    public void setName(final String name) {
        this.name = name;
    }
    
    public String getDescription() {
        return this.description;
    }
    
    public void setDescription(final String description) {
        this.description = description;
    }
    
    public int getKey() {
        return this.key;
    }
    
    public void setKey(final int key) {
        this.key = key;
    }
    
    public Category getCategory() {
        return this.category;
    }
    
    public void setCategory(final Category category) {
        this.category = category;
    }
    
    public boolean isToggled() {
        return this.toggled;
    }
    
    public void setToggled(final boolean toggled) {
        this.toggled = toggled;
    }
    
    public SettingBoolean register(final String name, final boolean value) {
        final SettingBoolean set = new SettingBoolean(name, this, value);
        final HydraWare instance = HydraWare.instance;
        HydraWare.settingsManager.settings.add(set);
        return set;
    }
    
    public SettingMode register(final String name, final ArrayList<String> values, final String value) {
        final SettingMode set = new SettingMode(name, this, values, value);
        final HydraWare instance = HydraWare.instance;
        HydraWare.settingsManager.settings.add(set);
        return set;
    }
    
    public SettingInteger register(final String name, final int value, final int min, final int max) {
        final SettingInteger set = new SettingInteger(name, this, value, min, max);
        final HydraWare instance = HydraWare.instance;
        HydraWare.settingsManager.settings.add(set);
        return set;
    }
    
    public SettingDouble register(final String name, final double value, final double min, final double max) {
        final SettingDouble set = new SettingDouble(name, this, (int)value, (int)min, (int)max);
        final HydraWare instance = HydraWare.instance;
        HydraWare.settingsManager.settings.add(set);
        return set;
    }
    
    public boolean nullCheck() {
        return Module.mc.player == null || Module.mc.world == null;
    }
    
    static {
        mc = Minecraft.getMinecraft();
    }
    
    public enum Category
    {
        MAIN, 
        COMBAT, 
        MOVEMENT, 
        RENDER, 
        MISC, 
        PLAYER;
    }
}
