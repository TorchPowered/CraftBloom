package org.bloom.event;

import org.bloom.plugin.Plugin;

/**
 * A event called when a plugin is stopped.
 */
public class PluginStopEvent implements Event {
    private Plugin plugin;

    public PluginStopEvent(Plugin plugin){
        this.plugin = plugin;
    }

    /**
     * Gets the event's plugin object.
     * @return the plugin object
     */
    public Plugin getPlugin() {
        return plugin;
    }
}
