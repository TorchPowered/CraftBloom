package org.bloom.util;

import org.bloom.Bloom;
import org.bloom.event.*;

/**
 * Some required components for implementing Bloom.
 * Server class must extend this!
 */
public class BloomComponents {
    public void setupDefaultEvents(){
        Bloom.getEventManager().registerEventClass(PluginStartingEvent.class);
        Bloom.getEventManager().registerEventClass(PlayerJoinEvent.class);
        Bloom.getEventManager().registerEventClass(PlayerLeaveEvent.class);
        Bloom.getEventManager().registerEventClass(PlayerMoveEvent.class);
        Bloom.getEventManager().registerEventClass(PluginStopEvent.class);
    }
}
