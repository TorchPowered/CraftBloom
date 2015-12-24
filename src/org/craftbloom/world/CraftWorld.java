package org.craftbloom.world;

import net.minecraft.entity.monster.EntityCreeper;
import net.minecraft.entity.monster.EntitySkeleton;
import net.minecraft.entity.monster.EntityZombie;
import net.minecraft.entity.passive.EntityRabbit;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.WorldServer;
import org.bloom.entity.Entity;
import org.bloom.entity.EntityType;
import org.bloom.entity.Player;
import org.bloom.util.Position;
import org.craftbloom.entity.CraftCreeper;

public class CraftWorld implements org.bloom.world.World{
    private World world;

    public CraftWorld(World world){
        this.world = world;
    }

    @Override
    public String getName() {
        return world.getWorldInfo().getWorldName();
    }

    protected World getWorld(String name){
        WorldServer[] worlds = MinecraftServer.getServer().worldServers;
        for (WorldServer world : worlds){
            if(world.getWorldInfo().getWorldName().equals(name)){
                return world;
            }
        }
        return null;
    }

    @Override
    public void spawnEntityInWorld(EntityType type, Position pos) {
        BlockPos entityPosition = new BlockPos(pos.getX(), pos.getY(), pos.getZ());
        net.minecraft.entity.Entity entity;
        switch (type){
            case CREEPER:
                entity = new EntityCreeper(world);
                break;
            case SKELETON:
                entity = new EntitySkeleton(world);
                break;
            case ZOMBIE:
                entity = new EntityZombie(world);
                break;
            case RABBIT:
                entity = new EntityRabbit(world);
                break;
            default:
                return;
        }
        world.spawnEntityInWorld(entity);
    }

    @Override
    public void createExplosion(Position pos, float strength, boolean isSmoking) {
        world.createExplosion(null, pos.getX(), pos.getY(), pos.getZ(), strength, isSmoking);
    }
}
