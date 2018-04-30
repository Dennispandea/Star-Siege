package net.kitz.starsiege.entities;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

public abstract class Entity {

    private Vector2 pos;
    protected EntityType type;
    protected float fVelocityY = 0;
    protected float fRot;
    protected float fVelocityX = 0;

    Entity(float x, float y, EntityType type) {
        this.setPos(new Vector2(x, y));
        this.type = type;
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

    public float getY() {
        return getPos().y;
    }

    public int getWidth() {
        return type.getnWidth();
    }

    public int getLength() {
        return type.getLength();
    }

    public double getdMass() {
        return type.getdMass();
    }

    public Vector2 getPos() {
        return pos;
    }
}
