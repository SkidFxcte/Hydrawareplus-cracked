
package club.auth.hydraware.manager;

import club.auth.hydraware.util.*;
import net.minecraft.network.play.client.*;
import net.minecraft.network.*;

public class PositionManager implements Global
{
    public void updatePosition() {
        final double x = PositionManager.mc.player.posX;
        final double y = PositionManager.mc.player.posY;
        final double z = PositionManager.mc.player.posZ;
        final boolean onground = PositionManager.mc.player.onGround;
    }
    
    public void setPositionPacket(final double x, final double y, final double z, final boolean onGround, final boolean setPos, final boolean noLagBack) {
        PositionManager.mc.player.connection.sendPacket((Packet)new CPacketPlayer.Position(x, y, z, onGround));
        if (setPos) {
            PositionManager.mc.player.setPosition(x, y, z);
            if (noLagBack) {
                this.updatePosition();
            }
        }
    }
}
