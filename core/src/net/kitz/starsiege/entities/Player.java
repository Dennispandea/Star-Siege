package net.kitz.starsiege.entities;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import net.kitz.starsiege.world.GameMap;

public class Player extends Entity {

    private int nPlayerSpeed = 4;
    private int nPlayerRotSpeed;

    Texture image;

    public Player(float x, float y, Vector2 pos, GameMap map) {
        super(x, y, pos, EntityType.PLAYER, map);
        image = new Texture("Ship.png");
    }

    @Override
    public void update(float fDeltaTime, float fGravity) {

        if (Gdx.input.isKeyPressed(Input.Keys.W) && dVelocityY < 100)
            this.dVelocityY += nPlayerSpeed / getdMass();

        if (Gdx.input.isKeyPressed(Input.Keys.S) && dVelocityY < -100)
            this.dVelocityY -= nPlayerSpeed / getdMass();

        if (Gdx.input.isKeyPressed(Input.Keys.D) && dVelocityX < 100)
            this.dVelocityX += nPlayerSpeed / getdMass();

        if (Gdx.input.isKeyPressed(Input.Keys.A) && dVelocityX < -100)
            this.dVelocityX -= nPlayerSpeed / getdMass();

        super.update(fDeltaTime, fGravity);
    }

    @Override
    public void render(SpriteBatch batch) {
        batch.draw(image, pos.x, pos.y, getnWidth(), getnLength());
    }
}
