package org.craftbloom.entity;

import net.minecraft.entity.monster.EntitySkeleton;
import net.minecraft.util.BlockPos;
import org.bloom.entity.Entity;
import org.bloom.entity.Skeleton;
import org.bloom.util.Position;
import org.bloom.world.World;
import org.craftbloom.world.CraftWorld;

import java.util.UUID;

public class CraftSkeleton implements Skeleton{
    private EntitySkeleton skeleton;

    public CraftSkeleton(EntitySkeleton skeleton){
        this.skeleton = skeleton;
    }

    @Override
    public SkeletonType getSkeletonType() {
        if(skeleton.getSkeletonType() == 1){
            return SkeletonType.WITHER;
        }
        return SkeletonType.NORMAL;
    }

    @Override
    public void setSkeletonType(SkeletonType value) {
        int skeletonTypeNumber = 0;
        if(getSkeletonType() == SkeletonType.WITHER){
            skeletonTypeNumber = 1;
        }
        skeleton.setSkeletonType(skeletonTypeNumber);
    }

    @Override
    public UUID getUUID() {
        return skeleton.getUniqueID();
    }

    @Override
    public String getName() {
        return skeleton.getName();
    }

    @Override
    public boolean hasCustomName() {
        return skeleton.hasCustomName();
    }

    @Override
    public String getCustomName() {
        return skeleton.getCustomNameTag();
    }

    @Override
    public Position getPosition() {
        return new Position(skeleton.getPosition().getX(), skeleton.getPosition().getY(), skeleton.getPosition().getZ());
    }

    @Override
    public void teleport(Entity entity) {
        Position entityPosition = entity.getPosition();
        skeleton.setLocationAndAngles(entityPosition.getX(), entityPosition.getY(), entityPosition.getZ(), 0f, 0f);
    }

    @Override
    public void teleport(Position entityPosition) {
        skeleton.setLocationAndAngles(entityPosition.getX(), entityPosition.getY(), entityPosition.getZ(), 0f, 0f);
    }

    @Override
    public void remove() {
        net.minecraft.world.World world = skeleton.getEntityWorld();
        world.removeEntity(skeleton);
    }

    @Override
    public World getWorld() {
        return new CraftWorld(skeleton.getEntityWorld());
    }
}
