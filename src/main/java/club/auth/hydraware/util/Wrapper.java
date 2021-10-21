//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Users\User\Desktop\Source\Minecraft-Deobfuscator3000-master\1.12 stable mappings"!

//Decompiled by Procyon!

package club.auth.hydraware.util;

import net.minecraft.client.*;
import net.minecraft.client.entity.*;
import javax.annotation.*;
import net.minecraft.client.multiplayer.*;
import net.minecraft.client.gui.*;
import net.minecraft.network.*;

public class Wrapper
{
    public static final Minecraft mc;
    public static volatile Wrapper INSTANCE;
    
    @Nullable
    public static EntityPlayerSP getPlayer() {
        return Wrapper.mc.player;
    }
    
    @Nullable
    public static WorldClient getWorld() {
        return Wrapper.mc.world;
    }
    
    public static FontRenderer getFontRenderer() {
        return Wrapper.mc.fontRenderer;
    }
    
    public void sendPacket(final Packet packet) {
        getPlayer().connection.sendPacket(packet);
    }
    
    static {
        mc = Minecraft.getMinecraft();
        Wrapper.INSTANCE = new Wrapper();
    }
}
