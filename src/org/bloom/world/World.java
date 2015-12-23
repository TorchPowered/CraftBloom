package org.bloom.world;

import org.bloom.entity.Entity;
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
     * @param entity the entity
     * @param pos the position
     */
    void spawnEntityInWorld(Entity entity, Position pos);
}
