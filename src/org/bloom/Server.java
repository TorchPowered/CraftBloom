package org.bloom;

import org.bloom.command.Command;
import org.bloom.entity.Player;
import org.bloom.world.World;

import java.net.SocketAddress;

/**
 * Represents a server implementation of Bloom
 */
public interface Server {
    /**
     * Gets the socket address of the server
     * @return the socket address
     */
    SocketAddress getAddress();

    /**
     * Gets the players online
     * @return the players online
     */
    Player[] getOnlinePlayers();

    /**
     * Gets what the max player amount is
     * @return the max player amount
     */
    int getMaxPlayersAmount();

    /**
     * Gets the worlds on the server
     * @return the worlds
     */
    World[] getWorlds();

    /**
     * Registers a command
     * @param command the command
     */
    void registerCommand(Command command);
}
