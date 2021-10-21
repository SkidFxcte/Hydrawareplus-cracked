package club.auth.hydraware.manager;

import club.auth.hydraware.util.*;
import club.auth.hydraware.event.events.*;
import me.zero.alpine.listener.*;
import java.util.function.*;
import net.minecraftforge.common.*;
import net.minecraft.entity.player.*;
import net.minecraft.network.play.client.*;

public class RotationManager implements Global
{
    private float yaw;
    private float pitch;
    private boolean shouldRotate;
    @EventHandler
    private final Listener<PacketEvent.Send> receiveListener;
    
    public RotationManager() {
        this.yaw = 0.0f;
        this.pitch = 0.0f;
        this.shouldRotate = false;
        this.receiveListener = (Listener<PacketEvent.Send>)new Listener(event -> {
            if (event.getPacket() instanceof CPacketPlayer) {
                final CPacketPlayer packet = (CPacketPlayer)event.getPacket();
                if (this.shouldRotate) {
                    packet.yaw = this.yaw;
                    packet.pitch = this.pitch;
                }
            }
        }, new Predicate[0]);
        MinecraftForge.EVENT_BUS.register((Object)this);
    }
    
    public void reset() {
        this.shouldRotate = false;
        if (RotationManager.mc.player == null) {
            return;
        }
        this.yaw = RotationManager.mc.player.rotationYaw;
        this.pitch = RotationManager.mc.player.rotationPitch;
    }
    
    public void rotate(final double x, final double y, final double z) {
        if (RotationManager.mc.player == null) {
            return;
        }
        final Double[] v = this.calculateLookAt(x, y, z, (EntityPlayer)RotationManager.mc.player);
        this.shouldRotate = true;
        this.yaw = v[0].floatValue();
        this.pitch = v[1].floatValue();
    }
    
    private Double[] calculateLookAt(final double px, final double py, final double pz, final EntityPlayer me) {
        double dirx = me.posX - px;
        double diry = me.posY - py;
        double dirz = me.posZ - pz;
        final double len = Math.sqrt(dirx * dirx + diry * diry + dirz * dirz);
        dirx /= len;
        diry /= len;
        dirz /= len;
        double pitch = Math.asin(diry);
        double yaw = Math.atan2(dirz, dirx);
        pitch = pitch * 180.0 / 3.141592653589793;
        yaw = yaw * 180.0 / 3.141592653589793;
        yaw += 90.0;
        return new Double[] { yaw, pitch };
    }
}
