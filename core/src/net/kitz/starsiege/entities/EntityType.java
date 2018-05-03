package net.kitz.starsiege.entities;

public enum EntityType {

    PLAYER("PlayerShip", 124, 108, 20);

    private String sID;
    private int nWidth, nLength;
    private double dMass;

    EntityType(String sID, int nWidth, int nLength, double dMass) {
        this.sID = sID;
        this.nWidth = nWidth;
        this.nLength = nLength;
        this.dMass = dMass;
    }

    public String getsID() {
        return sID;
    }

    public int getnWidth() {
        return nWidth;
    }

    public int getLength() {
        return nLength;
    }

    public double getdMass() {
        return dMass;
    }
}
