package net.kitz.starsiege.entities;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import net.kitz.starsiege.world.GameMap;

public abstract class Entity {

    private Vector2 pos;
    protected EntityType type;
    protected float dVelocityY = 0;
    protected float dRot = 0;
    protected float dVelocityX = 0;
    protected GameMap map;

    Entity(float x, float y, EntityType type, GameMap map) {
        this.setPos(new Vector2(x, y));
        this.dRot = dRot;
        this.type = type;
        this.map = map;
    }

    public void update(float fDeltaTime, float fGravity) {

    }

    public abstract void render(SpriteBatch batch);


    public void setPos(Vector2 pos) {
        this.pos = pos;
    }

    public void setType(EntityType type) {
        this.type = type;
    }

    public float getX() {
        return getPos().x;
    }

    public float getdRot() {
        return dRot;
    }

    public float getY() {
        return getPos().y;
    }

    public int getnWidth() {
        return type.getnWidth();
    }

    public int getnLength() {
        return type.getnLength();
    }

    public double getdMass() {
        return type.getdMass();
    }

    public Vector2 getPos() {
        return pos;
    }
}
