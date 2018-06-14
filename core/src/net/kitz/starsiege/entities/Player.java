package net.kitz.starsiege.entities;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.math.Vector3;
import net.kitz.starsiege.world.GameMap;

public class Player extends Entity {

    private float arfRotCorrection[] = new float[2];
    private float fDirX, fDirY, fDirAltX, fDirAltY;
    Vector3 Mousepos = new Vector3(0, 0, 3);
    public Sprite sprPlayer, sprHealth, sprVolume, sprSpeed;


    public Player(float x, float y, GameMap gameMap) {
        super(x, y, EntityType.PLAYER, gameMap);
        InitSpr();
        sprPlayer.setOrigin(62, 54);
        sprPlayer.setScale(0.3f);

    }

    private void InitSpr() {
        Texture txPlayer = new Texture("Ship.png");
        sprPlayer = new Sprite(txPlayer, 124, 108);

        Texture txHP = new Texture("bar.png");
        Texture txVol = new Texture("bar.png"); //initialize the bars
        Texture txSpeed = new Texture("bar.png");

        sprHealth = new Sprite(txHP, 1, 1);
        sprVolume = new Sprite(txVol, 1, 1);
        sprSpeed = new Sprite(txSpeed, 1, 1);

        sprHealth.setColor(Color.RED);
        sprSpeed.setColor(Color.BLUE);
        sprVolume.setColor(Color.GREEN);

    }


    @Override
    public void update(float fDeltaTime) {

        sprPlayer.setPosition(getPos().x, getPos().y);

        Movement();
        HudPos();
        EdgeDet();
        this.fRot = MathUtils.radiansToDegrees * MathUtils.atan2
                ((720 - Gdx.input.getY()) - arfRotCorrection[1],
                        Gdx.input.getX() - arfRotCorrection[0]);


        if (Gdx.input.isKeyPressed(Input.Keys.LEFT)) getPos().x -= 1;
        if (Gdx.input.isKeyPressed(Input.Keys.RIGHT)) getPos().x += 1;
        if (Gdx.input.isKeyPressed(Input.Keys.UP)) getPos().y += 1;
        if (Gdx.input.isKeyPressed(Input.Keys.DOWN)) getPos().y -= 1;
        if (Gdx.input.isKeyPressed(Input.Keys.R))
            System.out.println(getPos().x + " " + getPos().y);


        sprPlayer.setRotation(this.fRot);


        super.update(fDeltaTime);
    }


    private void HudPos() {

        sprHealth.setPosition(MathUtils.clamp(getPos().x + 200, 0, 15656),
                MathUtils.clamp(getPos().y + 400, 0, 16350));

        sprSpeed.setPosition(MathUtils.clamp(getPos().x + 400, 0, 15856),
                MathUtils.clamp(getPos().y + 400, 0, 16350));
        sprVolume.setPosition(MathUtils.clamp(getPos().x + 600, 0, 16056),
                MathUtils.clamp(getPos().y + 400, 0, 16350));
//x16256.109 y16313.005

        sprHealth.setScale(30f, 12f);
        sprSpeed.setScale(Math.abs(fVelocityX + fVelocityY) * 6, 12f);
        sprVolume.setScale(30f, 12f);
    }

    private void Movement() {
        fDirX = (float) Math.cos(Math.toRadians(sprPlayer.getRotation() + 90));
        fDirY = (float) Math.sin(Math.toRadians(sprPlayer.getRotation() + 90));
        fDirAltX = (float) Math.cos(Math.toRadians(sprPlayer.getRotation() + 180));
        fDirAltY = (float) Math.sin(Math.toRadians(sprPlayer.getRotation() + 180));

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
        if (getPos().x > 15684)
            arfRotCorrection[0] = getPos().x + (16380);
        else arfRotCorrection[0] = 640;
        if (getPos().y > 15684)
            arfRotCorrection[1] = getPos().y + (16380);
        else arfRotCorrection[1] = 360;
        if (getPos().x < 640)
            arfRotCorrection[0] = getPos().x + 60;
        else arfRotCorrection[0] = 640;
        if (getPos().y < 360)
            arfRotCorrection[1] = getPos().y + 60;
        else arfRotCorrection[1] = 360;
    }

    @Override
    public void render(SpriteBatch batch) {
        sprPlayer.draw(batch);

        sprVolume.draw(batch);
        sprSpeed.draw(batch);
        sprHealth.draw(batch);
    }

}