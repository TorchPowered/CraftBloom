package org.craftbloom.entity;

import net.minecraft.entity.monster.EntityCreeper;
import org.bloom.entity.Creeper;

public class CraftCreeper implements Creeper{
    private EntityCreeper creeper;

    public CraftCreeper(EntityCreeper creeper){
        this.creeper = creeper;
    }

    @Override
    public boolean isPowered() {
        return creeper.getPowered();
    }

    @Override
    public void setPowered(boolean flag) {
        creeper.setPowered(flag);
    }
}
