package net.kitz.starsiege.entities;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import net.kitz.starsiege.world.GameMap;

public class Player extends Entity {

    private int nPlayerSpeed = 4;
    private int nPlayerRotMult = 1;
    private float fDirX, fDirY;

    private Texture txImage = new Texture("Ship.png");
    private Sprite SprPlayer;

    public Player(float x, float y, GameMap map) {
        super(x, y, EntityType.PLAYER, map);
        SprPlayer = new Sprite(txImage, 16, 22);
        SprPlayer.scale(1.3f);
        SprPlayer.setSize(getnWidth(), getnLength());

    }

    @Override
    public void update(float fDeltaTime, float fGravity) {

        SprPlayer.setPosition(getPos().x, getPos().y);

        fDirX = (float) Math.cos(Math.toRadians(SprPlayer.getRotation() + 90));
        fDirY = (float) Math.sin(Math.toRadians(SprPlayer.getRotation() + 90));

        if (Gdx.input.isKeyPressed(Input.Keys.W) && dVelocityY < 20) {
            this.dVelocityX += fDirX * nPlayerSpeed / (getdMass() * 3);
            this.dVelocityY += fDirY * nPlayerSpeed / (getdMass() * 3);
        }

        if (Gdx.input.isKeyPressed(Input.Keys.S) && dVelocityY > -20) {
            this.dVelocityX -= fDirX * nPlayerSpeed / (getdMass() * 3);
            this.dVelocityY -= fDirY * nPlayerSpeed / (getdMass() * 3);
        }

        if (Gdx.input.isKeyPressed(Input.Keys.A) && dRot <= 8) {
            this.dRot += 1.5 * (nPlayerRotMult / (getdMass() / getnLength()));
        } else if (!Gdx.input.isKeyPressed(Input.Keys.A)) {
            this.dRot *= 0.65;
        }

        if (Gdx.input.isKeyPressed(Input.Keys.D) && dRot <= 8) {
            this.dRot -= (nPlayerRotMult / (getdMass() / getnLength()));
        } else if (!Gdx.input.isKeyPressed(Input.Keys.D)) {
            this.dRot *= 0.65;
        }


        if (Gdx.input.isKeyPressed(Input.Keys.SPACE)) {
            if (this.dVelocityX < 1 && this.dVelocityY < 1 && this.dVelocityX > -1 && this.dVelocityY > -1) {
                this.dVelocityY = 0;
                this.dVelocityX = 0;
            } else {
                this.dVelocityY *= 0.95;
                this.dVelocityX *= 0.95;
            }
        }

        getPos().y += this.dVelocityY;
        getPos().x += this.dVelocityX;
        SprPlayer.rotate(this.dRot);

        super.update(fDeltaTime, fGravity);
    }

    @Override
    public void render(SpriteBatch batch) {
        //  batch.draw(SprPlayer, getPos().x, getPos().y, getnWidth(), getnLength());
        SprPlayer.draw(batch);

    }
}