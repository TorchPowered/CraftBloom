package org.bloom.entity;

/**
 * Represents a rabbit
 */
public interface Rabbit extends Entity {
    /**
     * Gets the rabbit type
     * @return the rabbit type
     */
    Rabbit.Type getRabbitType();

    /**
     * Sets the rabbit type
     * @param type the rabbit type
     */
    void setRabbitType(Rabbit.Type type);

    /**
     * Represents a type of rabbit
     */
    enum Type {
        /**
         * A black rabbit
         */
        BLACK,
        /**
         * A rabbit with black and white patches or white and black patches.
         */
        BLACK_AND_WHITE,
        /**
         * A brown colored rabbit.
         */
        BROWN,
        /**
         * A golden bunny.
         */
        GOLD,
        /**
         * Salt and peppered colored rabbit
         */
        SALT_AND_PEPPER,
        /**
         * A white fur aggressive rabbit with red eyes
         */
        THE_KILLER_BUNNY,
        /**
         * A white rabbit
         */
        WHITE,
    }
}
