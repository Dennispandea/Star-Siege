package net.kitz.starsiege.world;

import java.util.HashMap;

public enum MapAsteroid {
    //                id,ore,size,amount,health,cooldown
    ASTEROID_WORTHLESS(0, 0, 15, 0, 50, 300),
    //BASE METALS
    ASTEROID_IRON(1, 1, 15, 25, 50, 300),
    ASTEROID_BAUXITE(2, 1, 15, 25, 50, 300),
    ASTEROID_COPPER(3, 3, 15, 25, 50, 300),
    ASTEROID_TITANIUM(4, 3, 15, 25, 50, 300),
    ASTEROID_LEAD(5, 3, 15, 25, 50, 300),
    //FUEL
    ASTEROID_URANIUM(6, 3, 15, 25, 50, 300),
    ASTEROID_PLUTONIUM(7, 3, 15, 25, 50, 300),
    ASTEROID_LITHIUM(8, 3, 15, 25, 50, 300),
    //PRECIOUS
    ASTEROID_COBALT(9, 2, 15, 25, 50, 300),
    ASTEROID_MAGNESIUM(10, 2, 15, 25, 50, 300),
    ASTEROID_GOLD(11, 2, 15, 25, 50, 300),
    ASTEROID_SILICON(12, 2, 15, 25, 50, 300);



    private int nAsteroidID;
    private int nOreID;
    private int nOreAmount;
    private double dSize;
    private double dHealth;
    private int nCooldown;

    public static final int ASTEROID_SIZE = 32;

    MapAsteroid(int nAsteroidID, int nOreID, double dSize, int nOreAmount, double dHealth, int nCooldown) {

        this.nAsteroidID = nAsteroidID;
        this.nOreID = nOreID;
        this.nOreAmount = nOreAmount;
        this.dHealth = dHealth;
        this.dSize = dSize;
        this.nCooldown = nCooldown;

    }

    public int getnAsteroidID() {
        return nAsteroidID;
    }

    public int getnOreID() {
        return nOreID;
    }

    public int getnOreAmount() {
        return nOreAmount;
    }

    public double getdSize() {
        return dSize;
    }

    public double getdHealth() {
        return dHealth;
    }

    public int getnCooldown() {
        return nCooldown;
    }

    private static HashMap<Integer, MapAsteroid> AsteroidID;

    static {
        AsteroidID = new HashMap<Integer, MapAsteroid>();
        for (MapAsteroid asteroidType : MapAsteroid.values()) {
            AsteroidID.put(asteroidType.getnAsteroidID(), asteroidType);

        }
    }

    public static MapAsteroid getAsteroidbyID(int nID) {
        return AsteroidID.get(nID);

    }
}

