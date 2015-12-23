package org.bloom.entity;

import org.bloom.event.Event;

/**
 * Represents a creeper
 */
public interface Creeper extends Event{
    /**
     * Gets if the creeper is powered
     * @return if the creeper is powered
     */
    boolean isPowered();

    /**
     * Sets the powered status of the creeper accordingly to the flag.
     * @param flag the boolean
     */
    void setPowered(boolean flag);
}
