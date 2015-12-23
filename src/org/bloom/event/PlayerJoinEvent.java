package org.bloom.event;

import org.bloom.entity.Player;

/**
 * A event called when a player joins
 */
public class PlayerJoinEvent extends Cancellable implements Event{
    private Player player;

    public PlayerJoinEvent(Player player){
        this.player = player;
    }

    /**
     * Gets the player of the event
     * @return the player
     */
    public Player getPlayer(){
        return this.player;
    }
}
