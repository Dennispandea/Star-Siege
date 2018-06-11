package net.kitz.starsiege.entities;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import net.kitz.starsiege.world.GameMap;


public abstract class Entity {
    GameMap gameMap;
    private Vector2 pos;
    private EntityType type;
    float fVelocityY = 0;
    float fRot;
    float fVelocityX = 0;

    Entity(float x, float y, EntityType type, GameMap gameMap) {
        this.setPos(new Vector2(x, y));
        this.type = type;
        this.gameMap = gameMap;
    }

    public void update(float fDeltaTime) {
        if (getPos().x < 0) {
            getPos().x += 1;
            this.fVelocityX = 0;
        } else if (getPos().x + getWidth() > 16380) {
            getPos().x -= 1;
            this.fVelocityX = 0;
        } else if (getPos().y < 0) {
            this.fVelocityY = 0;
            getPos().y += 1;
        } else if (getPos().y + getLength() > 16380) {
            this.fVelocityY = 0;
            getPos().y -= 1;
        } else {
            getPos().y += this.fVelocityY;
            getPos().x += this.fVelocityX;
        }

    }

    public abstract void render(SpriteBatch batch);



    private void setPos(Vector2 pos) {
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
        return this.pos;
    }
}
