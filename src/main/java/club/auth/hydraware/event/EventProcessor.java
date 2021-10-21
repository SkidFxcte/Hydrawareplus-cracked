package club.auth.hydraware.event;

import net.minecraftforge.common.*;
import net.minecraftforge.fml.common.eventhandler.*;
import net.minecraftforge.fml.common.gameevent.*;
import net.minecraftforge.client.event.*;
import club.auth.hydraware.*;

public class EventProcessor
{
    public EventProcessor() {
        MinecraftForge.EVENT_BUS.register((Object)this);
    }
    
    @SubscribeEvent
    public void onKey(final InputEvent.KeyInputEvent event) {
    }
    
    @SubscribeEvent
    public void onTick(final TickEvent.ClientTickEvent event) {
    }
    
    @SubscribeEvent
    public void onRender(final RenderGameOverlayEvent event) {
    }
    
    @SubscribeEvent
    public void onRenderWorld(final RenderWorldLastEvent event) {
        HydraWare.EVENT_BUS.post((Object)event);
    }
}
