package net.kitz.starsiege.world;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.ui.ProgressBar;


public class Hud {

    Hud(float min, float max, float stepSize, boolean vertical, ProgressBar.ProgressBarStyle background) {

    }

    public Hud() {

    }


    public void update(SpriteBatch batch) {

    }


    public void render(SpriteBatch batch) {
        ProgressBar.draw(batch, 255);


    }

}
