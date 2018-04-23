package net.kitz.starsiege.entities;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import net.kitz.starsiege.world.GameMap;

public abstract class Entity {

    protected Vector2 pos;
    protected EntityType type;
    protected double dVelocityY = 0;
    protected double dVelocityX = 0;
    protected GameMap map;

    public Entity(float x, float y, Vector2 pos, EntityType type, GameMap map) {
        this.pos = new Vector2(x, y);
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
        return pos.x;
    }

    public float getY() {
        return pos.y;
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


}
