package club.auth.hydraware.module.modules.combat;

import club.auth.hydraware.module.*;
import club.auth.hydraware.setting.settings.*;
import club.auth.hydraware.event.events.*;
import me.zero.alpine.listener.*;
import java.util.function.*;
import net.minecraft.item.*;
import net.minecraft.entity.player.*;
import net.minecraft.entity.*;
import club.auth.hydraware.manager.*;
import java.util.*;
import club.auth.hydraware.*;
import net.minecraft.util.*;
import net.minecraft.network.play.client.*;
import net.minecraft.network.*;

public class KillAura extends Module
{
    private SettingBoolean onlySword;
    private SettingDouble range;
    private SettingBoolean rotate;
    private SettingBoolean crits;
    private SettingBoolean delay;
    private boolean isAttacking;
    @EventHandler
    private final Listener<PacketEvent.Send> receiveListener;
    
    public KillAura() {
        super("KillAura", "", 0, Module.Category.COMBAT);
        this.onlySword = this.register("OnlySword", true);
        this.range = this.register("Range", 5.5, 0.0, 7.0);
        this.rotate = this.register("Rotate", false);
        this.crits = this.register("Criticals", true);
        this.delay = this.register("Delay", true);
        this.isAttacking = false;
        this.receiveListener = (Listener<PacketEvent.Send>)new Listener(event -> {
            if (event.getPacket() instanceof CPacketUseEntity) {
                final CPacketUseEntity packet = (CPacketUseEntity)event.getPacket();
                if (this.crits.getValue() && packet.getAction().equals((Object)CPacketUseEntity.Action.ATTACK) && KillAura.mc.player != null && KillAura.mc.player.onGround && this.isAttacking) {
                    KillAura.mc.player.connection.sendPacket((Packet)new CPacketPlayer.Position(KillAura.mc.player.posX, KillAura.mc.player.posY + 0.10000000149011612, KillAura.mc.player.posZ, false));
                    KillAura.mc.player.connection.sendPacket((Packet)new CPacketPlayer.Position(KillAura.mc.player.posX, KillAura.mc.player.posY, KillAura.mc.player.posZ, false));
                }
            }
        }, new Predicate[0]);
    }
    
    public void update() {
        if (KillAura.mc.world.playerEntities.isEmpty()) {
            return;
        }
        if (this.onlySword.getValue() && !(KillAura.mc.player.getHeldItemMainhand().getItem() instanceof ItemSword)) {
            return;
        }
        final List<EntityPlayer> list = new ArrayList<EntityPlayer>();
        for (final EntityPlayer player : KillAura.mc.world.playerEntities) {
            if (player == KillAura.mc.player) {
                continue;
            }
            if (KillAura.mc.player.getDistance((Entity)player) > this.range.getValue()) {
                continue;
            }
            if (player.getHealth() <= 0.0f) {
                continue;
            }
            if (player.isDead) {
                continue;
            }
            if (!FriendsManager.isFriend(player.getName())) {
                continue;
            }
            list.add(player);
        }
        if (list.isEmpty()) {
            return;
        }
        this.attack(list.get(0));
    }
    
    private void attack(final EntityPlayer target) {
        if (KillAura.mc.player.getCooledAttackStrength(0.0f) >= 1.0f || !this.delay.getValue()) {
            this.isAttacking = true;
            if (this.rotate.getValue()) {
                final HydraWare instance = HydraWare.instance;
                HydraWare.rotationManager.rotate(target.posX, target.posY, target.posZ);
            }
            KillAura.mc.playerController.attackEntity((EntityPlayer)KillAura.mc.player, (Entity)target);
            KillAura.mc.player.swingArm(EnumHand.MAIN_HAND);
            if (this.rotate.getValue()) {
                final HydraWare instance2 = HydraWare.instance;
                HydraWare.rotationManager.reset();
            }
            this.isAttacking = false;
        }
    }
}
