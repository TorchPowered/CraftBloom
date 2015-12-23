package org.bloom.entity;

import org.bloom.util.Position;
import org.bloom.world.World;

import java.util.UUID;

/**
 * Represents the base of all entities
 */
public interface Entity {
    /**
     * Gets the UUID of the entity
     * @return the UUID
     */
    UUID getUUID();

    /**
     * Gets the name of the entity
     * @return the name
     */
    String getName();

    /**
     * Gets if the entity has a custom name
     * @return gets if the entity has a custom name
     */
    boolean hasCustomName();

    /**
     * Gets the entity's custom name
     * @return the name
     */
    String getCustomName();

    /**
     * Gets the entity's position
     * @return the position
     */
    Position getPosition();

    /**
     * Teleports to another entity
     * @param entity the another entity
     */
    void teleport(Entity entity);

    /**
     * Teleports the entity to the position
     * @param position the position
     */
    void teleport(Position position);

    /**
     * Removes the entity
     */
    void remove();

    /**
     * Get's the entity's world.
     * @return the world
     */
    World getWorld();
}
