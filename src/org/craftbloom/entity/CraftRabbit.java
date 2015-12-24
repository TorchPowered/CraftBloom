package org.craftbloom.entity;

import net.minecraft.entity.passive.EntityRabbit;
import org.bloom.entity.Entity;
import org.bloom.entity.Rabbit;
import org.bloom.util.Position;
import org.bloom.world.World;
import org.craftbloom.world.CraftWorld;

import java.util.UUID;

public class CraftRabbit implements Rabbit{
    private EntityRabbit rabbit;

    public CraftRabbit(EntityRabbit rabbit){
        this.rabbit = rabbit;
    }

    @Override
    public Type getRabbitType() {
        int type = rabbit.getRabbitType();
        if(type == 0){
            return Type.BROWN;
        }
        if(type == 1){
            return Type.WHITE;
        }
        if(type == 2){
            return Type.BLACK;
        }
        if(type == 3){
            return Type.BLACK_AND_WHITE;
        }
        if(type == 4){
            return Type.GOLD;
        }
        if(type == 5){
            return Type.SALT_AND_PEPPER;
        }
        return Type.THE_KILLER_BUNNY;
    }

    @Override
    public void setRabbitType(Type type) {
        switch (getRabbitType()){
            case BROWN:
                rabbit.setRabbitType(0);
                break;
            case WHITE:
                rabbit.setRabbitType(1);
                break;
            case BLACK:
                rabbit.setRabbitType(2);
                break;
            case BLACK_AND_WHITE:
                rabbit.setRabbitType(3);
                break;
            case GOLD:
                rabbit.setRabbitType(4);
                break;
            case SALT_AND_PEPPER:
                rabbit.setRabbitType(5);
                break;
            case THE_KILLER_BUNNY:
                rabbit.setRabbitType(99);
                break;
        }
    }

    @Override
    public UUID getUUID() {
        return rabbit.getUniqueID();
    }

    @Override
    public String getName() {
        return rabbit.getName();
    }

    @Override
    public boolean hasCustomName() {
        return rabbit.hasCustomName();
    }

    @Override
    public String getCustomName() {
        return rabbit.getCustomNameTag();
    }

    @Override
    public Position getPosition() {
        return new Position(rabbit.getPosition().getX(), rabbit.getPosition().getY(), rabbit.getPosition().getZ());
    }

    @Override
    public void teleport(Entity entity) {
        rabbit.setLocationAndAngles(entity.getPosition().getX(), entity.getPosition().getY(), entity.getPosition().getZ(), 0f, 0f);
    }

    @Override
    public void teleport(Position position) {
        rabbit.setLocationAndAngles(position.getX(), position.getY(), position.getZ(), 0f, 0f);
    }

    @Override
    public void remove() {
        rabbit.getEntityWorld().removeEntity(rabbit);
    }

    @Override
    public World getWorld() {
        return new CraftWorld(rabbit.getEntityWorld());
    }
}
