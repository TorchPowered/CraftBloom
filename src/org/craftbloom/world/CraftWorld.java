package org.craftbloom.world;

import net.minecraft.util.BlockPos;
import net.minecraft.world.World;
import org.bloom.entity.Entity;
import org.bloom.entity.Player;
import org.bloom.util.Position;

public class CraftWorld implements org.bloom.world.World{
    private World world;

    public CraftWorld(World world){
        this.world = world;
    }

    @Override
    public String getName() {
        return world.getWorldInfo().getWorldName();
    }

    @Override
    public void spawnEntityInWorld(Entity entity, Position pos) {
        BlockPos entityPosition = new BlockPos(pos.getX(), pos.getY(), pos.getZ());
        if(entity instanceof Player){
            return;
        }
    }
}
