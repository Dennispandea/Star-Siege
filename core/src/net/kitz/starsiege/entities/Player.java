package net.kitz.starsiege.entities;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.MathUtils;

public class Player extends Entity {

    private float arfRotCorrection[] = new float[2];
    private float fDirX, fDirY, fDirAltX, fDirAltY;
    private Sprite SprPlayer, SprHealth, SprVolume, SprSpeed;


    public Player(float x, float y) {
        super(x, y, EntityType.PLAYER);
        InitSpr();
        SprPlayer.setOrigin(62, 54);
        SprPlayer.setScale(0.3f);

    }

    private void InitSpr() {
        Texture txPlayer = new Texture("Ship.png");
        SprPlayer = new Sprite(txPlayer, 124, 108);

        Texture txHP = new Texture("bar.png");
        Texture txVol = new Texture("bar.png");
        Texture txSpeed = new Texture("bar.png");

        SprHealth = new Sprite(txHP, 1, 1);
        SprVolume = new Sprite(txVol, 1, 1);
        SprSpeed = new Sprite(txSpeed, 1, 1);

        SprHealth.setColor(Color.RED);
        SprSpeed.setColor(Color.BLUE);
        SprVolume.setColor(Color.GREEN);

    }


    @Override
    public void update(float fDeltaTime, float fGravity) {

        SprPlayer.setPosition(getPos().x, getPos().y);

        Movement();
        HudPos();
        EdgeDet();
        this.fRot = MathUtils.radiansToDegrees * MathUtils.atan2
                ((720 - Gdx.input.getY()) - arfRotCorrection[1], Gdx.input.getX() - arfRotCorrection[0]);


        if (Gdx.input.isKeyPressed(Input.Keys.LEFT)) getPos().x -= 1;
        if (Gdx.input.isKeyPressed(Input.Keys.RIGHT)) getPos().x += 1;
        if (Gdx.input.isKeyPressed(Input.Keys.UP)) getPos().y += 1;
        if (Gdx.input.isKeyPressed(Input.Keys.DOWN)) getPos().y -= 1;
        if (Gdx.input.isKeyPressed(Input.Keys.R))
            System.out.println(getPos().x + " " + getPos().y);


        SprPlayer.setRotation(this.fRot);


        super.update(fDeltaTime, fGravity);
    }

    private void HudPos() {
        SprHealth.setPosition(getPos().x + 200, getPos().y + 400);
        SprSpeed.setPosition(getPos().x + 400, getPos().y + 400);
        SprVolume.setPosition(getPos().x + 600, getPos().y + 400);

        SprHealth.setScale(30f, 12f);
        SprSpeed.setScale(Math.abs(fVelocityX+fVelocityY)*6, 12f);
        SprVolume.setScale(30f, 12f);
    }

    private void Movement() {
        fDirX = (float) Math.cos(Math.toRadians(SprPlayer.getRotation() + 90));
        fDirY = (float) Math.sin(Math.toRadians(SprPlayer.getRotation() + 90));
        fDirAltX = (float) Math.cos(Math.toRadians(SprPlayer.getRotation() + 180));
        fDirAltY = (float) Math.sin(Math.toRadians(SprPlayer.getRotation() + 180));

        fVelocityX = MathUtils.clamp(fVelocityX, -20, 20);
        fVelocityY = MathUtils.clamp(fVelocityY, -20, 20);

        if (Gdx.input.isKeyPressed(Input.Keys.SPACE)) {
            if (this.fVelocityX < 1 && this.fVelocityY < 1 && this.fVelocityX > -1 && this.fVelocityY > -1) {
                this.fVelocityY = 0;
                this.fVelocityX = 0;
            } else {
                this.fVelocityY *= 0.98;
                this.fVelocityX *= 0.98;
            }
        }
        int nPlayerSpeed = 4;
        if (Gdx.input.isKeyPressed(Input.Keys.A)) {
            this.fVelocityX += fDirX * nPlayerSpeed / (getdMass() * 3);
            this.fVelocityY += fDirY * nPlayerSpeed / (getdMass() * 3);
        }

        if (Gdx.input.isKeyPressed(Input.Keys.D)) {
            this.fVelocityX -= fDirX * nPlayerSpeed / (getdMass() * 3);
            this.fVelocityY -= fDirY * nPlayerSpeed / (getdMass() * 3);
        }

        if (Gdx.input.isKeyPressed(Input.Keys.S)) {
            this.fVelocityX += fDirAltX * nPlayerSpeed / (getdMass() * 3);
            this.fVelocityY += fDirAltY * nPlayerSpeed / (getdMass() * 3);
        }

        if (Gdx.input.isKeyPressed(Input.Keys.W)) {
            this.fVelocityX -= fDirAltX * nPlayerSpeed / (getdMass() * 3);
            this.fVelocityY -= fDirAltY * nPlayerSpeed / (getdMass() * 3);
        }
          }

    private void EdgeDet() {
        if (getPos().x < 640)
            arfRotCorrection[0] = getPos().x - (16380 - 640);
        else arfRotCorrection[0] = 640;
        if (getPos().y < 360)
            arfRotCorrection[1] = getPos().y - (16380 - 360);
        else arfRotCorrection[1] = 360;
        if (getPos().x < 640)
            arfRotCorrection[0] = getPos().x;
        else arfRotCorrection[0] = 640;
        if (getPos().y < 360)
            arfRotCorrection[1] = getPos().y;
        else arfRotCorrection[1] = 360;
    }

    @Override
    public void render(SpriteBatch batch) {
        SprPlayer.draw(batch);

        SprVolume.draw(batch);
        SprSpeed.draw(batch);
        SprHealth.draw(batch);
    }
}