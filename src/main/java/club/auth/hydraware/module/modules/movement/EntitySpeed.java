package club.auth.hydraware.module.modules.movement;

import club.auth.hydraware.module.*;
import club.auth.hydraware.setting.settings.*;
import net.minecraft.entity.*;
import net.minecraft.entity.passive.*;
import net.minecraft.entity.item.*;
import net.minecraft.util.*;

public class EntitySpeed extends Module
{
    SettingDouble speed;
    
    public EntitySpeed() {
        super("EntitySpeed", "", 0, Module.Category.MOVEMENT);
        this.speed = this.register("Speed", 1.0, 0.1, 5.0);
    }
    
    public void update() {
        try {
            if (EntitySpeed.mc.player.getRidingEntity() != null) {
                final Entity theEntity = EntitySpeed.mc.player.getRidingEntity();
                speedEntity(theEntity, this.speed.getValue());
            }
        }
        catch (Exception ex) {}
    }
    
    private static void speedEntity(final Entity entity, final Double speed) {
        if (entity instanceof EntityLlama) {
            entity.rotationYaw = EntitySpeed.mc.player.rotationYaw;
            ((EntityLlama)entity).rotationYawHead = EntitySpeed.mc.player.rotationYawHead;
        }
        final MovementInput movementInput = EntitySpeed.mc.player.movementInput;
        double forward = movementInput.moveForward;
        double strafe = movementInput.moveStrafe;
        float yaw = EntitySpeed.mc.player.rotationYaw;
        if (forward == 0.0 && strafe == 0.0) {
            entity.motionX = 0.0;
            entity.motionZ = 0.0;
        }
        else {
            if (forward != 0.0) {
                if (strafe > 0.0) {
                    yaw += ((forward > 0.0) ? -45 : 45);
                }
                else if (strafe < 0.0) {
                    yaw += ((forward > 0.0) ? 45 : -45);
                }
                strafe = 0.0;
                if (forward > 0.0) {
                    forward = 1.0;
                }
                else if (forward < 0.0) {
                    forward = -1.0;
                }
            }
            entity.motionX = forward * speed * Math.cos(Math.toRadians(yaw + 90.0f)) + strafe * speed * Math.sin(Math.toRadians(yaw + 90.0f));
            entity.motionZ = forward * speed * Math.sin(Math.toRadians(yaw + 90.0f)) - strafe * speed * Math.cos(Math.toRadians(yaw + 90.0f));
            if (entity instanceof EntityMinecart) {
                final EntityMinecart em = (EntityMinecart)entity;
                em.setVelocity(forward * speed * Math.cos(Math.toRadians(yaw + 90.0f)) + strafe * speed * Math.sin(Math.toRadians(yaw + 90.0f)), em.motionY, forward * speed * Math.sin(Math.toRadians(yaw + 90.0f)) - strafe * speed * Math.cos(Math.toRadians(yaw + 90.0f)));
            }
        }
    }
}
