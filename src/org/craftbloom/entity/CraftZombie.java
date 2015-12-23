package org.craftbloom.entity;

import net.minecraft.entity.monster.EntityZombie;
import org.bloom.entity.Entity;
import org.bloom.entity.Zombie;
import org.bloom.util.Position;
import org.bloom.world.World;
import org.craftbloom.world.CraftWorld;

import java.util.UUID;

public class CraftZombie implements Zombie{
    private EntityZombie zombie;
    public CraftZombie(EntityZombie zombie){
        this.zombie = zombie;
    }
    @Override
    public boolean isBaby() {
        return zombie.isChild();
    }

    @Override
    public boolean isVillager() {
        return zombie.isVillager();
    }

    @Override
    public void setVillager(boolean flag) {
        zombie.setVillager(flag);
    }

    @Override
    public void setBaby(boolean flag) {
        zombie.setChild(flag);
    }

    @Override
    public UUID getUUID() {
        return zombie.getUniqueID();
    }

    @Override
    public String getName() {
        return zombie.getName();
    }

    @Override
    public boolean hasCustomName() {
        return zombie.hasCustomName();
    }

    @Override
    public String getCustomName() {
        return zombie.getCustomNameTag();
    }

    @Override
    public Position getPosition() {
        return new Position(zombie.getPosition().getX(), zombie.getPosition().getY(), zombie.getPosition().getZ());
    }

    @Override
    public void teleport(Entity entity) {
        Position position = entity.getPosition();
        zombie.setLocationAndAngles(position.getX(), position.getY(), position.getZ(), 0f, 0f);
    }

    @Override
    public void teleport(Position position) {
        zombie.setLocationAndAngles(position.getX(), position.getY(), position.getZ(), 0f, 0f);
    }

    @Override
    public void remove() {
        net.minecraft.world.World world = zombie.getEntityWorld();
        world.removeEntity(zombie);
    }

    @Override
    public World getWorld() {
        return new CraftWorld(zombie.getEntityWorld());
    }
}
