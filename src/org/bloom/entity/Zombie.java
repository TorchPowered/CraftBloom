package org.bloom.entity;

/**
 * Represents a zombie entity
 */
public interface Zombie extends Entity {
    /**
     * Gets if the zombie entity is a baby
     * @return if the zombie is a baby
     */
    boolean isBaby();

    /**
     * Gets if the zombie entity is a villager
     * @return if the zombie is a villager
     */
    boolean isVillager();

    /**
     * Sets the zombie as a villager
     * @param flag the flag
     */
    void setVillager(boolean flag);

    /**
     * Sets the zombie as a baby
     * @param flag the flag
     */
    void setBaby(boolean flag);
}
