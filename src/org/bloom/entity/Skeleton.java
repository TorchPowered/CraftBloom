package org.bloom.entity;

/**
 * Represents a skeleton entity
 */
public interface Skeleton extends Entity{
    /**
     * Gets the skeleton's type
     * @return the skeleton's type
     */
    SkeletonType getSkeletonType();

    /**
     * Sets the skeleton's type
     * @param value the skeleton's type
     */
    void setSkeletonType(SkeletonType value);

    /**
     * The enumerations of skeleton types
     */
    enum SkeletonType {
        /**
         * Represents a normal skeleton
         */
        NORMAL,
        /**
         * Represents a wither skeleton
         */
        WITHER
    }
}
