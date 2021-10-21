package club.auth.hydraware.module.modules.render;

import club.auth.hydraware.module.*;
import club.auth.hydraware.setting.settings.*;
import net.minecraft.entity.item.*;
import net.minecraft.entity.*;
import java.util.function.*;
import net.minecraftforge.fml.common.eventhandler.*;
import net.minecraftforge.client.event.*;

public class NoRender extends Module
{
    SettingBoolean weather;
    SettingBoolean viewBobbing;
    SettingBoolean items;
    SettingBoolean overlay;
    
    public NoRender() {
        super("NoRender", "No render things", 0, Module.Category.RENDER);
        this.weather = this.register("Weather", false);
        this.viewBobbing = this.register("ViewBobbing", false);
        this.items = this.register("Items", false);
        this.overlay = this.register("Overlay", false);
    }
    
    public void update() {
        if (this.weather.getValue() && NoRender.mc.world.isRaining()) {
            NoRender.mc.world.setRainStrength(0.0f);
        }
        if (this.items.getValue()) {
            NoRender.mc.world.loadedEntityList.stream().filter(EntityItem.class::isInstance).map(EntityItem.class::cast).forEach(Entity::setDead);
        }
    }
    
    public void onEnable() {
        if (this.viewBobbing.getValue()) {
            NoRender.mc.gameSettings.viewBobbing = false;
        }
    }
    
    public void onDisable() {
        if (this.viewBobbing.getValue()) {
            NoRender.mc.gameSettings.viewBobbing = true;
        }
    }
    
    @SubscribeEvent
    public void onRenderBlockOverlay(final RenderBlockOverlayEvent event) {
        if (this.overlay.getValue()) {
            event.setCanceled(true);
        }
    }
    
    @SubscribeEvent
    public void onEvent(final RenderGameOverlayEvent event) {
        if ((this.overlay.getValue() && event.getType().equals((Object)RenderGameOverlayEvent.ElementType.HELMET)) || event.getType().equals((Object)RenderGameOverlayEvent.ElementType.PORTAL)) {
            event.setCanceled(true);
        }
    }
}
