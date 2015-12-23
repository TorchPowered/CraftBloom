package org.bloom.util;

/**
 * Represents a position inside of the world
 */
public class Position {
    private double accurateX;
    private double accurateY;
    private double accurateZ;
    private int x;
    private int y;
    private int z;

    public Position(double x, double y, double z){
        this.accurateX = x;
        this.accurateY = y;
        this.accurateZ = z;
        this.x = new Double(x).intValue();
        this.y = new Double(y).intValue();
        this.z = new Double(z).intValue();
    }

    public Position(int x, int y, int z){
        this.x = x;
        this.y = y;
        this.z = z;
        this.accurateX = (double) x;
        this.accurateY = (double) y;
        this.accurateZ = (double) z;
    }

    public int getBlockX(){
        return this.x;
    }

    public int getBlockY(){
        return this.y;
    }

    public int getBlockZ(){
        return this.z;
    }

    public double getX(){
        return this.x;
    }

    public double getY(){
        return this.y;
    }

    public double getZ(){
        return this.z;
    }
}
