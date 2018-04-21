package net.kitz.starsiege;

import java.util.HashMap;

public enum MapAsteroid {

    SMALL_WORTHLESS(0, 0, 15, 0, 50, 300),
    SMALL_IRON(1, 1, 15, 25, 50, 300),
    SMALL_COBALT(2, 2, 15, 25, 50, 300),
    SMALL_URANIUM(3, 3, 15, 25, 50, 300),
    BACKGROUND(5, 0, 0, 0, 0, 0),
    EMPTY(4, 0, 0, 0, 0, 0);

    private int nAsteroidID;
    private int nOreID;
    private int nOreAmount;
    private double dSize;
    private double dHealth;
    private int nCooldown;

    public static final int ASTEROID_SIZE = 64;

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
        for (MapAsteroid asteroidType : MapAsteroid.values()) {
            AsteroidID.put(asteroidType.getnAsteroidID(), asteroidType);

        }
    }

    public static MapAsteroid getAsteroidbyID(int nID) {
        return AsteroidID.get(nID);

    }
}

