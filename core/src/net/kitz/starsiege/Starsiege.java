package net.kitz.starsiege;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Starsiege extends ApplicationAdapter {
    SpriteBatch batch;
    Texture img;

    OrthographicCamera cam;
    GameMap gameMap;

    @Override
    public void create() {
        batch = new SpriteBatch();
        img = new Texture("badlogic.jpg");

        cam = new OrthographicCamera();
        cam.setToOrtho(false, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        cam.update();

        gameMap = new TiledGameMap();
    }

    @Override
    public void render() {
        Gdx.gl.glClearColor(1, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        if (Gdx.input.isTouched()) {
            cam.translate(-Gdx.input.getDeltaX(), Gdx.input.getDeltaY());
            cam.update();
        }

        gameMap.render(cam);
    }

    @Override
    public void dispose() {
        batch.dispose();
        img.dispose();
    }
}
