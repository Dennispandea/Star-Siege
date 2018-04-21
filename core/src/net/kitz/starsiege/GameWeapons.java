package net.kitz.starsiege;

import com.badlogic.gdx.graphics.OrthographicCamera;

public abstract class GameWeapons {


    public abstract void render(OrthographicCamera camera);

    public abstract void update(float delta);

    public abstract void dispose();

}
