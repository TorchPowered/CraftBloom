package org.bloom.world;

import org.bloom.entity.EntityType;
import org.bloom.util.Position;

/**
 * Represents a world inside of the server
 */
public interface World {
    /**
     * Gets the name of the world
     * @return the name of the world
     */
    String getName();

    /**
     * Spawns a entity in the world
     * @param entity the entitytype enum
     * @param pos the position
     */
    void spawnEntityInWorld(EntityType entity, Position pos);

    /**
     * Creates a explosion at the specified position
     * @param pos the position
     * @param strength the strength of the explosion
     * @param isSmoking if the explosion creates smoke
     */
    void createExplosion(Position pos, float strength, boolean isSmoking);
}
