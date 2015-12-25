package org.craftbloom;

import net.minecraft.command.CommandException;
import net.minecraft.command.CommandHandler;
import net.minecraft.command.ICommand;
import net.minecraft.command.ICommandSender;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.BlockPos;
import org.bloom.Server;
import org.bloom.command.Command;
import org.bloom.entity.Player;
import org.bloom.util.BloomComponents;
import org.bloom.world.World;
import org.craftbloom.cmd.CraftSender;
import org.craftbloom.entity.CraftPlayer;
import org.craftbloom.world.CraftWorld;

import java.net.InetSocketAddress;
import java.net.SocketAddress;
import java.util.ArrayList;
import java.util.List;

public class CraftServer extends BloomComponents implements Server {
    public void setupCodedEvents(){
        setupDefaultEvents();
    }

    @Override
    public SocketAddress getAddress() {
        String hostname = MinecraftServer.getServer().getHostname();
        int port = MinecraftServer.getServer().getPort();
        return new InetSocketAddress(hostname, port);
    }

    @Override
    public Player[] getOnlinePlayers() {
        ArrayList<Player> players = new ArrayList<Player>();
        for (String onlineUsername : MinecraftServer.getServer().getConfigurationManager().getAllUsernames()){
            EntityPlayerMP player = MinecraftServer.getServer().getConfigurationManager().getPlayerByUsername(onlineUsername);
            CraftPlayer player1 = new CraftPlayer(player);
            players.add(player1);
        }
        return players.toArray(new Player[players.size()]);
    }

    @Override
    public int getMaxPlayersAmount() {
        return MinecraftServer.getServer().getMaxPlayers();
    }

    @Override
    public World[] getWorlds() {
        net.minecraft.world.World[] world = MinecraftServer.getServer().worldServers;
        ArrayList<World> worlds = new ArrayList<World>();
        for (net.minecraft.world.World world1 : world){
            worlds.add(new CraftWorld(world1));
        }
        return worlds.toArray(new World[worlds.size()]);
    }

    @Override
    public void registerCommand(final Command command) {
        ICommand convertedCommand = new ICommand() {
            @Override
            public String getCommandName() {
                return command.name();
            }

            @Override
            public String getCommandUsage(ICommandSender sender) {
                return command.usage();
            }

            @Override
            public List<String> getCommandAliases() {
                return new ArrayList<String>();
            }

            @Override
            public void processCommand(ICommandSender sender, String[] args) throws CommandException {
                CraftSender craftSender = new CraftSender(sender);
                command.onExecute(craftSender, args);
            }

            @Override
            public boolean canCommandSenderUseCommand(ICommandSender sender) {
                if(!(sender instanceof Player)){
                    return true;
                }
                return ((EntityPlayerMP) sender).isOp();
            }

            @Override
            public List<String> addTabCompletionOptions(ICommandSender sender, String[] args, BlockPos pos) {
                return null;
            }

            @Override
            public boolean isUsernameIndex(String[] args, int index) {
                return false;
            }

            @Override
            public int compareTo(ICommand o) {
                return 0;
            }
        };
        CommandHandler handler = (CommandHandler) MinecraftServer.getServer().getCommandManager();
        handler.registerCommand(convertedCommand);
    }

    @Override
    public void kickPlayer(Player player, String s) {
        EntityPlayerMP playerMP = MinecraftServer.getServer().getConfigurationManager().getPlayerByUUID(player.getUUID());
        playerMP.playerNetServerHandler.kickPlayerFromServer(s);
    }
}
