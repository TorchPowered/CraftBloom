package org.bloom.entity;

import org.bloom.command.CommandSender;

/**
 * Represents a player on the server
 */
public interface Player extends Entity, CommandSender {
    /**
     * Gets the display name of the player
     * @return the display name
     */
    String getDisplayName();

    /**
     * Gets the playerlist name of the player
     * @return the playerlist name
     */
    String getPlayerListName();

    /**
     * Sends a title
     * @param title the title message
     */
    void sendTitle(String title);

    /**
     * Sends a title with a subtitle
     * @param title the title
     * @param subtitle the subtitle
     */
    void sendTitle(String title, String subtitle);

    /**
     * Sends a title with fade in, time till fade out, fade out
     * @param title the title
     * @param a the fade in time
     * @param b the time until fade out
     * @param c the fade out time
     */
    void sendTitle(String title, int a, int b, int c);

    /**
     * Sends a title with a subtitle and fade in, time till fade out, fade out
     * @param title the title
     * @param subtitle
     * @param a the fade in time
     * @param b the time until fade out
     * @param c the fade out time
     */
    void sendTitle(String title, String subtitle, int a, int b, int c);

    /**
     * Gets the xp in the xp bar
     * @return the xp in the xp bar
     */
    float getXP();

    /**
     * Gets how many levels the player has
     * @return the levels
     */
    int getXPLevels();

    /**
     * Gets the flyspeed of the player
     * @return the flyspeed
     */
    float getFlySpeed();

    /**
     * Gets the foodlevel of the player
     * @return the foodlevel
     */
    int getFoodLevel();

    /**
     * Sets the flyspeed of the player
     * @param speed the speed
     */
    void setFlySpeed(float speed);

    /**
     * Sets the walkspeed of the player
     * @param speed the speed
     */
    void setWalkSpeed(float speed);

    /**
     * Adds XP levels to the player's current amount
     * @param x the levels to be added
     */
    void addXPLevels(int x);

    /**
     * Adds XP to the current amount in the xp bar.
     * @param x the xp amount to be added
     */
    void addXP(int x);

    /**
     * Sets the amount of XP in the xp bar
     * @param x the amount of XP
     */
    void setXP(float x);

    /**
     * Sets the XP levels of the player
     * @param x the xp levels
     */
    void setXPLevel(int x);

    /**
     * Gets the total XP of the player
     * @return the total XP
     */
    int getTotalXP();

    /**
     * Sets the total XP
     * @param xp the total XP
     */
    void setTotalXP(int xp);

    /**
     * Adds to the total XP
     * @param xp the amount
     */
    void addTotalXP(int xp);
}
