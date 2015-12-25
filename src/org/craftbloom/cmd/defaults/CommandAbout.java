package org.craftbloom.cmd.defaults;

import org.bloom.command.Command;
import org.bloom.command.CommandSender;

public class CommandAbout implements Command{
    @Override
    public String name() {
        return "about";
    }

    @Override
    public String usage() {
        return "Usage: /about";
    }

    @Override
    public boolean opRequired() {
        return false;
    }

    @Override
    public void onExecute(CommandSender commandSender, String[] strings) {
        commandSender.sendMessage("CraftBloom (Minecraft Server 1.8.8 implementing Bloom API 0.1-SNAPSHOT)");
    }
}
