package org.bloom.command;

/**
 * Represents a sender of a command
 */
public interface CommandSender {
    /**
     * Sends a message to the sender
     * @param msg the message
     */
    void sendMessage(String msg);
}
