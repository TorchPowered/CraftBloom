package org.craftbloom.cmd.defaults;

import org.bloom.command.Command;
import org.bloom.command.CommandSender;
import org.bloom.plugin.JavaPluginLoader;
import org.bloom.plugin.Plugin;

public class CommandPlugin implements Command {
    @Override
    public String name() {
        return "plugins";
    }

    @Override
    public String usage() {
        return "Usage: /plugins";
    }

    @Override
    public boolean opRequired() {
        return false;
    }

    @Override
    public void onExecute(CommandSender commandSender, String[] strings) {
        StringBuilder builder = new StringBuilder();
        for (Plugin plugin : JavaPluginLoader.getPlugins()){
            builder.append(plugin.getName() + ", ");
        }
        commandSender.sendMessage("Plugins: " + builder.toString());
    }
}
