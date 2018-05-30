package net.kitz.starsiege.entities;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class SprAsteroid extends Entity {


    private Sprite sprAsteroid;


    public SprAsteroid(float x, float y, float nSize, float fRot_, float fVelx, float fVely, int ntxChoose) {
        super(x, y, EntityType.ASTEROID);
        InitSpr(ntxChoose);
        sprAsteroid.setOrigin(16, 16);
        sprAsteroid.setScale(nSize);
        fRot = fRot_;
    }

    private void InitSpr(int ntxChoose) {
        Texture txAsteroid[] = new Texture[13];
        txAsteroid[0] = new Texture("Asteroids/Asteroid_worthless.png");
        txAsteroid[1] = new Texture("Asteroids/Asteroid_cobalt.png");
        txAsteroid[2] = new Texture("Asteroids/Asteroid_copper.png");
        txAsteroid[3] = new Texture("Asteroids/Asteroid_gold.png");
        txAsteroid[4] = new Texture("Asteroids/Asteroid_iron.png");
        txAsteroid[5] = new Texture("Asteroids/Asteroid_lead.png");
        txAsteroid[6] = new Texture("Asteroids/Asteroid_lithium.png");
        txAsteroid[7] = new Texture("Asteroids/Asteroid_magnesium.png");
        txAsteroid[8] = new Texture("Asteroids/Asteroid_plutonium.png");
        txAsteroid[9] = new Texture("Asteroids/Asteroid_Silicon.png");
        txAsteroid[10] = new Texture("Asteroids/Asteroid_titanium.png");
        txAsteroid[11] = new Texture("Asteroids/Asteroid_uranium.png");
        txAsteroid[12] = new Texture("Asteroids/Asteroid_bauxite.png");
        sprAsteroid = new Sprite(txAsteroid[ntxChoose], 32, 32);
    }


    @Override
    public void update(float fDeltaTime, float fGravity) {
        sprAsteroid.setPosition(getPos().x, getPos().y);
        sprAsteroid.rotate(fRot);
        super.update(fDeltaTime, fGravity);
    }

    @Override
    public void render(SpriteBatch batch) {
        sprAsteroid.draw(batch);

    }
}