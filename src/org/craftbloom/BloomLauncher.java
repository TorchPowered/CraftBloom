package org.craftbloom;

import net.minecraft.server.MinecraftServer;
import org.bloom.Bloom;

public class BloomLauncher {
    public static void main(String[] args){
        CraftServer server = new CraftServer();
        server.setupLogging();
        Bloom.setServer(server);
        server.setupCodedEvents();
        MinecraftServer.main(args);
    }
}
