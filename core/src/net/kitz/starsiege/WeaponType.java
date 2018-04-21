package net.kitz.starsiege;

public enum WeaponType {

    MINING_LASER(1, 2.0, 0, "Mining Laser"),
    BASIC_LASER_GUN(1, 15.0, 0, "Basic Laser Gun");


    private int nID;
    private double dBaseDamage;
    private int nBaseCost;
    private String sName;

    // WeaponType(int nID, int nBaseDamage, int nBaseCost, String sName) {
    //     this(nID, nBaseDamage, nBaseCost, sName);}

    WeaponType(int nID, double dBaseDamage, int nBaseCost, String sName) {
        this.nBaseCost = nBaseCost;
        this.dBaseDamage = dBaseDamage;
        this.nID = nID;
        this.sName = sName;
    }
}
