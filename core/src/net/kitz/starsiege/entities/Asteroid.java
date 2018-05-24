package net.kitz.starsiege.entities;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.MathUtils;

public class Asteroid extends Entity {

    private float arfRotCorrection[] = new float[2];
    private int nCurActive;
    private Sprite sprAsteroid;


    public Asteroid(float x, float y) {
        super(x, y, EntityType.PLAYER);
        InitSpr();
        sprAsteroid.setOrigin(62, 54);
        sprAsteroid.setScale(0.3f);

    }

    private void InitSpr() {
        Texture txPlayer = new Texture("Ship.png");
        sprAsteroid = new Sprite(txPlayer, 124, 108);
    }


    @Override
    public void update(float fDeltaTime, float fGravity) {

        sprAsteroid.setPosition(getPos().x, getPos().y);

        EdgeDet();
        this.fRot = MathUtils.radiansToDegrees * MathUtils.atan2
                ((720 - Gdx.input.getY()) - arfRotCorrection[1],
                        Gdx.input.getX() - arfRotCorrection[0]);

        if (Gdx.input.isKeyPressed(Input.Keys.LEFT)) getPos().x -= 1;
        if (Gdx.input.isKeyPressed(Input.Keys.RIGHT)) getPos().x += 1;
        if (Gdx.input.isKeyPressed(Input.Keys.UP)) getPos().y += 1;
        if (Gdx.input.isKeyPressed(Input.Keys.DOWN)) getPos().y -= 1;
        if (Gdx.input.isKeyPressed(Input.Keys.R)) System.out.println(getPos().x + " " + getPos().y);

        sprAsteroid.rotate((float) Math.abs(Math.random() + 12));

        super.update(fDeltaTime, fGravity);
    }

    private void EdgeDet() {
        if (getPos().x > 16000)
            arfRotCorrection[0] = getPos().x - (16380);
        if (getPos().y > 16000)
            arfRotCorrection[1] = getPos().y - (16380);
        if (getPos().x < 0)
            arfRotCorrection[0] = getPos().x + 60;
        if (getPos().y < 0)
            arfRotCorrection[1] = getPos().y + 60;
    }

    @Override
    public void render(SpriteBatch batch) {
        sprAsteroid.draw(batch);

    }
}