package org.craftbloom.entity;


import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.network.play.server.S45PacketTitle;
import net.minecraft.util.BlockPos;
import net.minecraft.util.ChatComponentText;
import org.bloom.entity.Entity;
import org.bloom.entity.Player;
import org.bloom.util.Position;
import org.bloom.world.World;
import org.craftbloom.world.CraftWorld;

import java.util.UUID;

public class CraftPlayer implements Player{
    private EntityPlayerMP player;

    public CraftPlayer(EntityPlayerMP playerMP){ this.player = playerMP; }


    @Override
    public String getDisplayName() {
        return player.getDisplayName().toString();
    }

    @Override
    public String getPlayerListName() {
        return player.getTabListDisplayName().toString();
    }

    @Override
    public void sendTitle(String title) {
        S45PacketTitle titlePacket = new S45PacketTitle(S45PacketTitle.Type.TITLE, new ChatComponentText(title));
        player.playerNetServerHandler.sendPacket(titlePacket);
    }

    @Override
    public void sendTitle(String title, String subtitle) {
        S45PacketTitle titlePacket = new S45PacketTitle(S45PacketTitle.Type.TITLE, new ChatComponentText(title));
        S45PacketTitle subtitlePacket = new S45PacketTitle(S45PacketTitle.Type.SUBTITLE, new ChatComponentText(subtitle));
        player.playerNetServerHandler.sendPacket(titlePacket);
        player.playerNetServerHandler.sendPacket(subtitlePacket);
    }

    @Override
    public void sendTitle(String title, int a, int b, int c) {
        sendTitle(title);
        S45PacketTitle transitionPacket = new S45PacketTitle(a, b, c);
        player.playerNetServerHandler.sendPacket(transitionPacket);
    }

    @Override
    public void sendTitle(String title, String subtitle, int a, int b, int c) {
        sendTitle(title, subtitle);
        S45PacketTitle transitionPacket = new S45PacketTitle(a, b, c);
        player.playerNetServerHandler.sendPacket(transitionPacket);
    }

    @Override
    public float getXP() {
        return player.experience;
    }

    @Override
    public int getXPLevels() {
        return player.experienceLevel;
    }

    @Override
    public float getFlySpeed() {
        return player.capabilities.getFlySpeed();
    }

    @Override
    public int getFoodLevel() {
        return player.getFoodStats().getFoodLevel();
    }

    @Override
    public void setFlySpeed(float speed) {
        player.capabilities.flySpeed = speed;
    }

    @Override
    public void setWalkSpeed(float speed) {
        player.capabilities.walkSpeed = speed;
    }

    @Override
    public void addXPLevels(int x) {
        player.experienceLevel = player.experienceLevel + x;
    }

    @Override
    public void addXP(int x) {
        player.experience = player.experience + x;
    }

    @Override
    public void setXP(float x) {
        player.experience = x;
    }

    @Override
    public void setXPLevel(int x) {
        player.experienceLevel = x;
    }

    @Override
    public int getTotalXP() {
        return player.experienceTotal;
    }

    @Override
    public void setTotalXP(int xp) {
        player.experienceTotal = xp;
    }

    @Override
    public void addTotalXP(int xp) {
        player.experienceTotal = player.experienceTotal + xp;
    }

    @Override
    public void sendMessage(String msg) {
        player.addChatMessage(new ChatComponentText(msg));
    }

    @Override
    public UUID getUUID() {
        return player.getUniqueID();
    }

    @Override
    public String getName() {
        return getDisplayName();
    }

    @Override
    public boolean hasCustomName() {
        return player.hasCustomName();
    }

    @Override
    public String getCustomName() {
        return player.getCustomNameTag();
    }

    @Override
    public Position getPosition() {
        BlockPos nmsPosition = player.getPosition();
        Position conPosition = new Position(nmsPosition.getX(), nmsPosition.getY(), nmsPosition.getZ());
        return conPosition;
    }

    @Override
    public void teleport(Entity entity) {
        Position position = entity.getPosition();
        player.setLocationAndAngles(position.getX(), position.getY(), position.getZ(), 0f, 0f);
    }

    @Override
    public void teleport(Position position) {
        player.setLocationAndAngles(position.getX(), position.getY(), position.getZ(), 0f, 0f);
    }

    @Override
    public void remove() {
        net.minecraft.world.World nmsWorld = player.getEntityWorld();
        nmsWorld.removeEntity(player);
    }

    @Override
    public World getWorld() {
        return new CraftWorld(player.getEntityWorld());
    }
}
