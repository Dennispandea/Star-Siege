package net.kitz.starsiege.entities;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.MathUtils;

public class Player extends Entity {

    private int nPlayerSpeed = 4;
    private float fRotCorrection[] = new float[2];
    private float fDirX, fDirY, fDirAltX, fDirAltY;
    private Texture txImage = new Texture("Ship.png");
    private Sprite SprPlayer;

    public Player(float x, float y) {
        super(x, y, EntityType.PLAYER);
        SprPlayer = new Sprite(txImage, 124, 108);
        SprPlayer.setOrigin(62, 54);
        SprPlayer.scale(0.2f);

    }

    @Override
    public void update(float fDeltaTime, float fGravity) {

        SprPlayer.setPosition(getPos().x, getPos().y);

        fDirX = (float) Math.cos(Math.toRadians(SprPlayer.getRotation() + 90));
        fDirY = (float) Math.sin(Math.toRadians(SprPlayer.getRotation() + 90));
        fDirAltX = (float) Math.cos(Math.toRadians(SprPlayer.getRotation() + 180));
        fDirAltY = (float) Math.sin(Math.toRadians(SprPlayer.getRotation() + 180));


        if (Gdx.input.isKeyPressed(Input.Keys.D) && fVelocityY < 20) {
            this.fVelocityX += fDirX * nPlayerSpeed / (getdMass() * 3);
            this.fVelocityY += fDirY * nPlayerSpeed / (getdMass() * 3);
        }

        if (Gdx.input.isKeyPressed(Input.Keys.A) && fVelocityY > -20) {
            this.fVelocityX -= fDirX * nPlayerSpeed / (getdMass() * 3);
            this.fVelocityY -= fDirY * nPlayerSpeed / (getdMass() * 3);
        }

        if (Gdx.input.isKeyPressed(Input.Keys.S) && fVelocityY > -20) {
            this.fVelocityX += fDirAltX * nPlayerSpeed / (getdMass() * 3);
            this.fVelocityY += fDirAltY * nPlayerSpeed / (getdMass() * 3);
        }

        if (Gdx.input.isKeyPressed(Input.Keys.W) && fVelocityY > -20) {
            this.fVelocityX -= fDirAltX * nPlayerSpeed / (getdMass() * 3);
            this.fVelocityY -= fDirAltY * nPlayerSpeed / (getdMass() * 3);
        }

        if (getPos().x < 640)
            fRotCorrection[0] = getPos().x - (16380 - 640);
        else fRotCorrection[0] = 640;
        if (getPos().y < 360)
            fRotCorrection[1] = getPos().y - (16380 - 360);
        else fRotCorrection[1] = 360;
        if (getPos().x < 640)
            fRotCorrection[0] = getPos().x;
        else fRotCorrection[0] = 640;
        if (getPos().y < 360)
            fRotCorrection[1] = getPos().y;
        else fRotCorrection[1] = 360;


        this.fRot = MathUtils.radiansToDegrees * MathUtils.atan2
                ((720 - Gdx.input.getY()) - fRotCorrection[1], Gdx.input.getX() - fRotCorrection[0]);


        if (Gdx.input.isKeyPressed(Input.Keys.SPACE)) {
            if (this.fVelocityX < 1 && this.fVelocityY < 1 && this.fVelocityX > -1 && this.fVelocityY > -1) {
                this.fVelocityY = 0;
                this.fVelocityX = 0;
            } else {
                this.fVelocityY *= 0.99;
                this.fVelocityX *= 0.99;
            }
        }
        if (Gdx.input.isKeyPressed(Input.Keys.LEFT)) getPos().x -= 1;
        if (Gdx.input.isKeyPressed(Input.Keys.RIGHT)) getPos().x += 1;
        if (Gdx.input.isKeyPressed(Input.Keys.UP)) getPos().y += 1;
        if (Gdx.input.isKeyPressed(Input.Keys.DOWN)) getPos().y -= 1;
        if (Gdx.input.isKeyPressed(Input.Keys.R))
            System.out.println(getPos().x + " " + getPos().y);


        SprPlayer.setRotation(this.fRot);


        super.update(fDeltaTime, fGravity);
    }

    @Override
    public void render(SpriteBatch batch) {
        SprPlayer.draw(batch);

    }
}