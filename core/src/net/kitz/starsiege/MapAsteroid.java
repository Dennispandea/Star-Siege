package net.kitz.starsiege;

public enum MapAsteroid {

    SMALL_WORTHLESS(0, 0, 25, 50, 300);


    private int nAsteroidID;
    private int nOreID;
    private double dSize;
    private double dHealth;
    private int nCooldown;


    MapAsteroid(int nAsteroidID, int nOreID, double dSize, double dHealth, int nCooldown) {

        this.nAsteroidID = nAsteroidID;
        this.nOreID = nOreID;
        this.dHealth = dHealth;
        this.dSize = dSize;
        this.nCooldown = nCooldown;

    }

    private enum OreType {

        NONE(0, 4, ""),
        IRON(1, 4, "Iron Ore");

        private int nID;
        private int nRarity;    // 1 = rare 2 = very uncommon, 3 = uncommon, 4 = common
        private String sName;

        OreType(int nID, int nRarity, String sName) {
            this.nID = nID;
            this.nRarity = nRarity;
            this.sName = sName;

        }


    }
}

