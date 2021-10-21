package club.auth.hydraware.module.modules.combat;

import club.auth.hydraware.module.*;
import club.auth.hydraware.setting.settings.*;
import net.minecraft.util.math.*;
import net.minecraft.block.*;
import club.auth.hydraware.util.*;
import java.util.*;
import net.minecraft.network.play.client.*;
import net.minecraft.network.*;

public class Surround extends Module
{
    SettingBoolean smart;
    SettingBoolean center;
    SettingBoolean rotate;
    private BlockPos startPos;
    private ArrayList<BlockPos> retryPos;
    double posY;
    private static final BlockPos[] surroundPos;
    
    public Surround() {
        super("Surround", "", 0, Module.Category.COMBAT);
        this.smart = this.register("Smart", false);
        this.center = this.register("Center", true);
        this.rotate = this.register("Rotate", false);
    }
    
    public void onEnable() {
        if (this.nullCheck()) {
            return;
        }
        this.startPos = PlayerUtil.getPlayerPos();
        this.retryPos = new ArrayList<BlockPos>();
        if (this.center.getValue()) {
            final double y = Surround.mc.player.getPosition().getY();
            double x = Surround.mc.player.getPosition().getX();
            double z = Surround.mc.player.getPosition().getZ();
            final Vec3d plusPlus = new Vec3d(x + 0.5, y, z + 0.5);
            final Vec3d plusMinus = new Vec3d(x + 0.5, y, z - 0.5);
            final Vec3d minusMinus = new Vec3d(x - 0.5, y, z - 0.5);
            final Vec3d minusPlus = new Vec3d(x - 0.5, y, z + 0.5);
            if (this.getDst(plusPlus) < this.getDst(plusMinus) && this.getDst(plusPlus) < this.getDst(minusMinus) && this.getDst(plusPlus) < this.getDst(minusPlus)) {
                x = Surround.mc.player.getPosition().getX() + 0.5;
                z = Surround.mc.player.getPosition().getZ() + 0.5;
                this.centerPlayer(x, y, z);
            }
            if (this.getDst(plusMinus) < this.getDst(plusPlus) && this.getDst(plusMinus) < this.getDst(minusMinus) && this.getDst(plusMinus) < this.getDst(minusPlus)) {
                x = Surround.mc.player.getPosition().getX() + 0.5;
                z = Surround.mc.player.getPosition().getZ() - 0.5;
                this.centerPlayer(x, y, z);
            }
            if (this.getDst(minusMinus) < this.getDst(plusPlus) && this.getDst(minusMinus) < this.getDst(plusMinus) && this.getDst(minusMinus) < this.getDst(minusPlus)) {
                x = Surround.mc.player.getPosition().getX() - 0.5;
                z = Surround.mc.player.getPosition().getZ() - 0.5;
                this.centerPlayer(x, y, z);
            }
            if (this.getDst(minusPlus) < this.getDst(plusPlus) && this.getDst(minusPlus) < this.getDst(plusMinus) && this.getDst(minusPlus) < this.getDst(minusMinus)) {
                x = Surround.mc.player.getPosition().getX() - 0.5;
                z = Surround.mc.player.getPosition().getZ() + 0.5;
                this.centerPlayer(x, y, z);
            }
        }
        this.posY = Surround.mc.player.posY;
    }
    
    public void update() {
        if (this.nullCheck()) {
            this.toggle();
            return;
        }
        if (this.posY < Surround.mc.player.posY) {
            this.toggle();
            return;
        }
        if (this.startPos != null && !this.startPos.equals((Object)PlayerUtil.getPlayerPos())) {
            this.toggle();
            return;
        }
        if (!this.retryPos.isEmpty() && this.retryPos.size() < Surround.surroundPos.length && this.smart.getValue()) {
            for (final BlockPos pos : this.retryPos) {
                final BlockPos newPos = this.addPos(pos);
                if (BlockUtil.isPositionPlaceable(newPos, false) < 2) {
                    continue;
                }
                final int slot = InventoryUtil.findHotbarBlock(BlockObsidian.class);
                if (slot == -1) {
                    this.toggle();
                }
                if (!BlockUtil.placeBlock(newPos, slot, this.rotate.getValue(), this.rotate.getValue())) {
                    continue;
                }
                this.retryPos.remove(newPos);
            }
            return;
        }
        for (final BlockPos pos2 : Surround.surroundPos) {
            final BlockPos newPos2 = this.addPos(pos2);
            if (BlockUtil.isPositionPlaceable(newPos2, false) >= 2) {
                final int slot2 = InventoryUtil.findHotbarBlock(BlockObsidian.class);
                if (slot2 == -1) {
                    this.toggle();
                }
                if (!BlockUtil.placeBlock(newPos2, slot2, this.rotate.getValue(), this.rotate.getValue())) {
                    this.retryPos.add(newPos2);
                }
            }
        }
    }
    
    private BlockPos addPos(final BlockPos pos) {
        final BlockPos pPos = PlayerUtil.getPlayerPos(0.2);
        return new BlockPos(pPos.getX() + pos.getX(), pPos.getY() + pos.getY(), pPos.getZ() + pos.getZ());
    }
    
    private double getDst(final Vec3d vec) {
        return Surround.mc.player.getPositionVector().distanceTo(vec);
    }
    
    private void centerPlayer(final double x, final double y, final double z) {
        Surround.mc.player.connection.sendPacket((Packet)new CPacketPlayer.Position(x, y, z, true));
        Surround.mc.player.setPosition(x, y, z);
    }
    
    static {
        surroundPos = new BlockPos[] { new BlockPos(0, -1, 0), new BlockPos(1, -1, 0), new BlockPos(-1, -1, 0), new BlockPos(0, -1, 1), new BlockPos(0, -1, -1), new BlockPos(1, 0, 0), new BlockPos(-1, 0, 0), new BlockPos(0, 0, 1), new BlockPos(0, 0, -1) };
    }
}
