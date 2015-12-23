package org.bloom.plugin;

import org.apache.commons.lang3.Validate;
import org.bloom.Bloom;

/**
 * Represents a plugin manager
 */
public class PluginManager {
    public PluginManager(Bloom bloom){
        Validate.notNull(bloom);
    }

    /**
     * Gets the plugins on the server
     * @return the plugins
     */
    public Plugin[] getPlugins(){
        return JavaPluginLoader.getPlugins();
    }

    /**
     * Gets a plugin from a name
     * @param name the plugin name
     * @return the plugin object
     */
    public Plugin getPlugin(String name){
        return JavaPluginLoader.nameToPlugin.get(name);
    }
}
