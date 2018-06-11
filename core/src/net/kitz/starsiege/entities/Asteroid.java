package net.kitz.starsiege.entities;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import net.kitz.starsiege.world.GameMap;

public class Asteroid extends Entity {
    float fsRot, fAstx, fAsty;


    private Sprite sprAsteroid;
    Player player;


    public Asteroid(float x, float y, float nSize, float fRot, GameMap gameMap) {
        super(x, y, EntityType.ASTEROID, gameMap);
        InitSpr();
        sprAsteroid.setOrigin(16, 16);
        sprAsteroid.setScale(nSize);
        fsRot = fRot;
        fAstx = x;
        fAsty = y;
    }

    private void InitSpr() {
        Texture txAsteroid = new Texture("Asteroids/Asteroid_worthless.png");
        sprAsteroid = new Sprite(txAsteroid, 32, 32);
    }


    @Override
    public void update(float fDeltaTime) {
        sprAsteroid.setPosition(getPos().x, getPos().y);
        sprAsteroid.rotate(fsRot);
        isHit();
        super.update(fDeltaTime);
    }

    private void isHit() {

        player = (Player) gameMap.entities.get(0);
        if (getX() + getWidth() == player.getX() + player.getWidth()
                || getY() + getLength() == player.getY() + player.getLength()) {
            player.fVelocityX *= -0.3;
            player.fVelocityY *= -0.3;
        }
    }

    @Override
    public void render(SpriteBatch batch) {
        sprAsteroid.draw(batch);
    }
}