package org.craftbloom.cmd;

import net.minecraft.command.ICommandSender;
import net.minecraft.util.ChatComponentText;
import org.bloom.command.CommandSender;

public class CraftSender implements CommandSender{
    private ICommandSender sender;

    public CraftSender(ICommandSender sender){
        this.sender = sender;
    }

    @Override
    public void sendMessage(String msg) {
        sender.addChatMessage(new ChatComponentText(msg));
    }
}
