package org.bloom.event;

import org.bloom.entity.Player;

/**
 * A event called when a player moves.
 */
public class PlayerMoveEvent implements Event {
    private Player player;

    public PlayerMoveEvent(Player player){
        this.player = player;
    }

    /**
     * Gets the player of the event
     * @return the player
     */
    public Player getPlayer() {
        return player;
    }
}
