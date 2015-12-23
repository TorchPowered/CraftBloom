package org.bloom.command;

/**
 * Represents a server command
 */
public interface Command {
    /**
     * The name of the command
     * @return the name
     */
    String name();

    /**
     * The usage of the command
     * @return the usage
     */
    String usage();

    /**
     * If the command requires op
     * @return if the command requires op
     */
    boolean opRequired();

    /**
     * Executed when someone executes command
     * @param sender the sender of the command
     * @param args the arguments
     */
    void onExecute(CommandSender sender, String[] args);
}
