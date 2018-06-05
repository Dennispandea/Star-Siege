package net.kitz.starsiege.entities;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import net.kitz.starsiege.world.GameMap;


public abstract class Entity {
    GameMap gameMap;
    Player player;

    private Vector2 pos;
    private EntityType type;
    float fVelocityY = 0;
    float fRot;
    float fVelocityX = 0;

    Entity(float x, float y, EntityType type) {
        this.setPos(new Vector2(x, y));
        this.type = type;
    }

    public void update(float fDeltaTime, float fGravity) {
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
        isHit();
    }

    public abstract void render(SpriteBatch batch);

    public void isHit() {
        player = (Player) gameMap.entities.get(0);
        for (int i = 1; i < 500; i++) {
            if (player.getX() + player.getWidth() == gameMap.entities.get(i).getX() + gameMap.entities.get(i).getLength()
                    || player.getY() + player.getLength() == gameMap.entities.get(i).getY() + gameMap.entities.get(i).getLength()) {
                player.fVelocityX *= -.8;
                player.fVelocityY *= -.8;
            }
        }
    }

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
