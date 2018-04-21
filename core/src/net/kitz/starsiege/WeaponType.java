package net.kitz.starsiege;

public enum WeaponType {

    MINING_LASER(1, 2.0, 100.00, 0, "Mining Laser"),
    BASIC_LASER_GUN(1, 15.0, 100.00, 0, "Basic Laser Gun");


    private int nID;
    private double dBaseDamage;
    private double dBaseDurability;
    private int nBaseCost;
    private String sName;

    //WeaponType(int nID, int nBaseDamage, double nBaseDurability, int nBaseCost, String sName) {
    //this(nID, nBaseDamage, dBaseDurability, nBaseCost, sName);
    //}

    WeaponType(int nID, double dBaseDamage, double dBaseDurability, int nBaseCost, String sName) {
        this.nBaseCost = nBaseCost;
        this.dBaseDamage = dBaseDamage;
        this.dBaseDurability = dBaseDurability;
        this.nID = nID;
        this.sName = sName;
    }
}
