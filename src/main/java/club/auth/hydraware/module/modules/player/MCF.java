package club.auth.hydraware.module.modules.player;

import club.auth.hydraware.module.*;
import net.minecraftforge.fml.common.gameevent.*;
import me.zero.alpine.listener.*;
import java.util.function.*;
import net.minecraft.util.math.*;
import net.minecraft.entity.player.*;
import org.lwjgl.input.*;
import club.auth.hydraware.manager.*;
import club.auth.hydraware.command.*;

public class MCF extends Module
{
    @EventHandler
    private final Listener<InputEvent.MouseInputEvent> listener;
    
    public MCF() {
        super("MCF", "Middle click friend.", 0, Module.Category.PLAYER);
        this.listener = (Listener<InputEvent.MouseInputEvent>)new Listener(event -> {
            if (MCF.mc.objectMouseOver.typeOfHit.equals((Object)RayTraceResult.Type.ENTITY) && MCF.mc.objectMouseOver.entityHit instanceof EntityPlayer && Mouse.isButtonDown(2)) {
                if (FriendsManager.isFriend(MCF.mc.objectMouseOver.entityHit.getName())) {
                    FriendsManager.removeFriend(MCF.mc.objectMouseOver.entityHit.getName());
                    Messages.sendClientMessage(new String[] { "removed friend: " + MCF.mc.objectMouseOver.entityHit.getName() });
                }
                else {
                    FriendsManager.addFriend(MCF.mc.objectMouseOver.entityHit.getName());
                    Messages.sendSilentMessage(new String[] { "added friend: " + MCF.mc.objectMouseOver.entityHit.getName() });
                }
            }
        }, new Predicate[0]);
    }
}
