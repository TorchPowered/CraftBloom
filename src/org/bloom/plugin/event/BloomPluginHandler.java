package org.bloom.plugin.event;

import org.apache.commons.lang3.Validate;
import org.bloom.Bloom;
import org.bloom.command.Command;
import org.bloom.plugin.Plugin;

/**
 * Allows access for registering commands, etc.
 * Should not be used by a new statement.
 */
public class BloomPluginHandler {
    private Plugin plugin;

    public BloomPluginHandler(Plugin plugin){
        Validate.notNull(plugin);
        this.plugin = plugin;
    }

    /**
     * Registers a command
     * @param command the command
     */
    public void registerCommand(Command command){
        Bloom.getServer().registerCommand(command);
    }
}
