package net.kitz.starsiege.entities;

import com.badlogic.gdx.graphics.OrthographicCamera;

public abstract class GameItems {


    public abstract void render(OrthographicCamera camera);

    public abstract void update(float delta);

    public abstract void dispose();

}
