package org.bloom;

import org.bloom.entity.Player;
import org.bloom.event.EventManager;
import org.bloom.plugin.PluginManager;
import org.bloom.world.World;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * Represents the API core
 */
public class Bloom {
    protected Bloom(){}

    private static Server server;
    private static Map<String, Player> nameToPlayer = new HashMap<String, Player>();
    private static Map<UUID, Player> uuidToPlayer = new HashMap<UUID, Player>();

    /**
     * Set's the API's server implementation
     * @param server the server
     */
    public static void setServer(Server server){
        Bloom.server = server;
        for (Player player : server.getOnlinePlayers()){
            nameToPlayer.put(player.getDisplayName(), player);
            uuidToPlayer.put(player.getUUID(), player);
        }
    }

    /**
     * Gets the online players on the server
     * @return the online players
     */
    public static Player[] getOnlinePlayers(){
        return server.getOnlinePlayers();
    }

    /**
     * Gets all the worlds on the server
     * @return the worlds
     */
    public static World[] getWorlds(){
        return server.getWorlds();
    }

    /**
     * Gets a world from a name
     * @param name the world name
     * @return the world from the name
     */
    public static World getWorld(String name){
        for (World world : server.getWorlds()){
            if(world.getName().equals(name)){
                return world;
            }
        }
        return null;
    }

    /**
     * Gets a player from a name
     * @param name the player name
     * @return the player from the name
     */
    public static Player getPlayer(String name){
        return nameToPlayer.get(name);
    }

    /**
     * Gets a player from a uuid
     * @param uuid the player uuid
     * @return the player from the uuid
     */
    public static Player getPlayer(UUID uuid){
        return uuidToPlayer.get(uuid);
    }

    /**
     * Gets the max player slots of the server
     * @return the max player slots
     */
    public static int getMaxPlayerSlots(){
        return server.getMaxPlayersAmount();
    }

    /**
     * Gets bloom's event manager
     * @return the event manager
     */
    public static EventManager getEventManager(){
        return new EventManager(new Bloom());
    }

    /**
     * Gets the server implemented on bloom
     * @return the server
     */
    public static Server getServer(){
        return server;
    }

    /**
     * Gets bloom's plugin manager
     * @return the plugin manager
     */
    public static PluginManager getPluginManager(){
        return new PluginManager(new Bloom());
    }
}
