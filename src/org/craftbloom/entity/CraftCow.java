package org.craftbloom.entity;

import net.minecraft.entity.passive.EntityCow;
import net.minecraft.util.BlockPos;
import org.bloom.entity.Cow;
import org.bloom.entity.Entity;
import org.bloom.util.Position;
import org.bloom.world.World;
import org.craftbloom.world.CraftWorld;

import java.util.UUID;

public class CraftCow implements Cow{
    private EntityCow cow;

    public CraftCow(EntityCow cow){
        this.cow = cow;
    }

    @Override
    public UUID getUUID() {
        return cow.getUniqueID();
    }

    @Override
    public String getName() {
        return cow.getName();
    }

    @Override
    public boolean hasCustomName() {
        return cow.hasCustomName();
    }

    @Override
    public String getCustomName() {
        return cow.getCustomNameTag();
    }

    @Override
    public Position getPosition() {
        return new Position(cow.getPosition().getX(), cow.getPosition().getY(), cow.getPosition().getZ());
    }

    @Override
    public void teleport(Entity entity) {
        cow.setLocationAndAngles(entity.getPosition().getX(), entity.getPosition().getY(), entity.getPosition().getZ(), 0f, 0f);
    }

    @Override
    public void teleport(Position position) {
        cow.setLocationAndAngles(position.getX(), position.getY(), position.getZ(), 0f, 0f);
    }

    @Override
    public void remove() {
        net.minecraft.world.World world = cow.getEntityWorld();
        world.removeEntity(cow);
    }

    @Override
    public World getWorld() {
        return new CraftWorld(cow.getEntityWorld());
    }
}
