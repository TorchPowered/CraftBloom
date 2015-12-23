package org.bloom.event;

import org.bloom.plugin.Plugin;

/**
 * A event called when a plugin is starting
 * @author PizzaCrust
 */
public class PluginStartingEvent implements Event {
    private Plugin plugin;

    public PluginStartingEvent(Plugin plugin){
        this.plugin = plugin;
    }

    public Plugin getPlugin(){
        return this.plugin;
    }
}
