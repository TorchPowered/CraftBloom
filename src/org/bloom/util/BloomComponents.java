package org.bloom.util;

import org.bloom.Bloom;
import org.bloom.event.PluginStartingEvent;

/**
 * Some required components for implementing Bloom.
 * Server class must extend this!
 */
public class BloomComponents {
    public void setupDefaultEvents(){
        Bloom.getEventManager().registerEventClass(PluginStartingEvent.class);
    }
}
