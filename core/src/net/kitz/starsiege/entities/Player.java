package net.kitz.starsiege.entities;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.MathUtils;

public class Player extends Entity {

    private int nPlayerSpeed = 4;
    private int nPlayerRotMult = 1;
    private float fDirX, fDirY, fDirAltX, fDirAltY;
    private Texture txImage = new Texture("Ship.png");
    private Sprite SprPlayer;

    public Player(float x, float y) {
        super(x, y, EntityType.PLAYER);
        SprPlayer = new Sprite(txImage, 16, 22);
        SprPlayer.setOrigin(SprPlayer.getWidth() / 2, SprPlayer.getHeight() / 2);
        SprPlayer.scale(1.3f);
        SprPlayer.setSize(getWidth(), getLength());


    }

    @Override
    public void update(float fDeltaTime, float fGravity) {

        SprPlayer.setPosition(getPos().x, getPos().y);

        fDirX = (float) Math.cos(Math.toRadians(SprPlayer.getRotation() + 90));
        fDirY = (float) Math.sin(Math.toRadians(SprPlayer.getRotation() + 90));
        fDirAltX = (float) Math.cos(Math.toRadians(SprPlayer.getRotation() + 180));
        fDirAltY = (float) Math.sin(Math.toRadians(SprPlayer.getRotation() + 180));


        if (Gdx.input.isKeyPressed(Input.Keys.W) && fVelocityY < 20) {
            this.fVelocityX += fDirX * nPlayerSpeed / (getdMass() * 3);
            this.fVelocityY += fDirY * nPlayerSpeed / (getdMass() * 3);
        }

        if (Gdx.input.isKeyPressed(Input.Keys.S) && fVelocityY > -20) {
            this.fVelocityX -= fDirX * nPlayerSpeed / (getdMass() * 3);
            this.fVelocityY -= fDirY * nPlayerSpeed / (getdMass() * 3);
        }

        if (Gdx.input.isKeyPressed(Input.Keys.A) && fRot <= 8) {
            this.fVelocityX += fDirAltX * nPlayerSpeed / (getdMass() * 3);
            this.fVelocityY += fDirAltY * nPlayerSpeed / (getdMass() * 3);
        }

        if (Gdx.input.isKeyPressed(Input.Keys.D) && fRot <= 8) {
            this.fVelocityX -= fDirAltX * nPlayerSpeed / (getdMass() * 3);
            this.fVelocityY -= fDirAltY * nPlayerSpeed / (getdMass() * 3);
        }

        this.fRot = MathUtils.radiansToDegrees * MathUtils.atan2((720 - Gdx.input.getY()) - 360, Gdx.input.getX() - 640);

        if (Gdx.input.isKeyPressed(Input.Keys.SPACE)) {
            if (this.fVelocityX < 1 && this.fVelocityY < 1 && this.fVelocityX > -1 && this.fVelocityY > -1) {
                this.fVelocityY = 0;
                this.fVelocityX = 0;
            } else {
                this.fVelocityY *= 0.95;
                this.fVelocityX *= 0.95;
            }
        }

        getPos().y += this.fVelocityY;
        getPos().x += this.fVelocityX;
        SprPlayer.setRotation(this.fRot - 90);


        super.update(fDeltaTime, fGravity);
    }

    @Override
    public void render(SpriteBatch batch) {
        SprPlayer.draw(batch);

    }
}