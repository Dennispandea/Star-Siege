package net.kitz.starsiege.entities;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import net.kitz.starsiege.world.GameMap;

public class Asteroid extends Entity {
    float fsRot, fAstx, fAsty;


    private Sprite sprAsteroid;
    Player player;


    public Asteroid(float x, float y, float nSize, float fRot, int ntxChoose, GameMap gameMap) {
        super(x, y, EntityType.ASTEROID, gameMap);
        InitSpr();
        sprAsteroid.setOrigin(16, 16);
        sprAsteroid.setScale(nSize);
        fsRot = fRot;
        InitSpr(ntxChoose);
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

    private void isHit() {

        player = (Player) gameMap.entities.get(0);
        if (sprAsteroid.getBoundingRectangle().overlaps(player.sprPlayer.getBoundingRectangle())||(Gdx.input.isKeyPressed(Input.Keys.L))) {
            player.fVelocityX *= 3;
            player.fVelocityY *= 3;
        }
    }

    @Override
    public void render(SpriteBatch batch) {
        sprAsteroid.draw(batch);
    }
}