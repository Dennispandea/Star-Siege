package net.kitz.starsiege.entities;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import net.kitz.starsiege.world.GameMap;

public class Player extends Entity {

    private int nPlayerSpeed = 4;
    private int nPlayerRotSpeed;

    Texture txImage;
    Sprite SprPlayer;

    public Player(float x, float y, GameMap map) {
        super(x, y, EntityType.PLAYER, map);
        SprPlayer = new Sprite(txImage, 16, 22);
        txImage = new Texture("Ship.png");
    }

    @Override
    public void update(float fDeltaTime, float fGravity) {

        if (Gdx.input.isKeyPressed(Input.Keys.W) && dVelocityY < 100) {
            this.dVelocityY += nPlayerSpeed / getdMass();
        }

        if (Gdx.input.isKeyPressed(Input.Keys.S) && dVelocityY > -100) {
            this.dVelocityY += -nPlayerSpeed / getdMass();
        }

        if (Gdx.input.isKeyPressed(Input.Keys.D) && dVelocityX < 100) {
            this.dVelocityX += nPlayerSpeed / getdMass();
        }

        if (Gdx.input.isKeyPressed(Input.Keys.A) && dVelocityX > -100) {
            this.dVelocityX += -nPlayerSpeed / getdMass();
        }
        if (Gdx.input.isKeyPressed(Input.Keys.SPACE)) {
            if (this.dVelocityX < 1 && this.dVelocityY < 1) {
                this.dVelocityY = 0;
                this.dVelocityX = 0;
            } else {
                this.dVelocityY *= 0.95;
                this.dVelocityX *= 0.95;
            }
        }
        super.update(fDeltaTime, fGravity);
    }

    @Override
    public void render(SpriteBatch batch) {
        batch.draw(SprPlayer, getPos().x, getPos().y, getnWidth(), getnLength());


    }

}
