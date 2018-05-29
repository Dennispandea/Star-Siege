package net.kitz.starsiege.entities;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Asteroid extends Entity {
    float fsRot, fAstx, fAsty;

    private Sprite sprAsteroid;


    public Asteroid(float x, float y, float nSize, float fRot, float fVelx, float fVely) {
        super(x, y, EntityType.ASTEROID);
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
    public void update(float fDeltaTime, float fGravity) {
        sprAsteroid.setPosition(getPos().x, getPos().y);
        sprAsteroid.rotate(fsRot);
        super.update(fDeltaTime, fGravity);
    }

    @Override
    public void render(SpriteBatch batch) {
        sprAsteroid.draw(batch);

    }
}