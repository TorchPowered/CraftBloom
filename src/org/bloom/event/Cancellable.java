package org.bloom.event;

/**
 * Represents a event that can be cancellable
 */
public class Cancellable {
    private boolean cancelled = false;

    /**
     * Gets if the event is cancelled
     * @return if the event is cancelled
     */
    public boolean isCancelled(){
        return cancelled;
    }

    /**
     * Sets the event if cancelled or not accordingly to the flag
     * @param flag the flag of the event
     */
    public void setCancelled(boolean flag){
        this.cancelled = flag;
    }
}
