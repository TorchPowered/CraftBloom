package org.craftbloom.entity;

import net.minecraft.entity.monster.EntityGuardian;
import org.bloom.entity.Entity;
import org.bloom.entity.Guardian;
import org.bloom.util.Position;
import org.bloom.world.World;
import org.craftbloom.world.CraftWorld;

import java.util.UUID;

public class CraftGuardian implements Guardian{
    private EntityGuardian guardian;

    public CraftGuardian(EntityGuardian guardian){
        this.guardian = guardian;
    }

    @Override
    public boolean isElder() {
        return guardian.isElder();
    }

    @Override
    public void setElder(boolean b) {
        guardian.setElder(b);
    }

    @Override
    public UUID getUUID() {
        return guardian.getUniqueID();
    }

    @Override
    public String getName() {
        return guardian.getName();
    }

    @Override
    public boolean hasCustomName() {
        return guardian.hasCustomName();
    }

    @Override
    public String getCustomName() {
        return guardian.getCustomNameTag();
    }

    @Override
    public Position getPosition() {
        return new Position(guardian.getPosition().getX(), guardian.getPosition().getY(), guardian.getPosition().getZ());
    }

    @Override
    public void teleport(Entity entity) {
        guardian.setLocationAndAngles(entity.getPosition().getX(), entity.getPosition().getY(), entity.getPosition().getZ(), 0f, 0f);
    }

    @Override
    public void teleport(Position position) {
        guardian.setLocationAndAngles(position.getX(), position.getY(), position.getZ(), 0f, 0f);
    }

    @Override
    public void remove() {
        guardian.getEntityWorld().removeEntity(guardian);
    }

    @Override
    public World getWorld() {
        return new CraftWorld(guardian.getEntityWorld());
    }
}
