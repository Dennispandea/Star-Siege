package net.kitz.starsiege;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import net.kitz.starsiege.world.GameMap;
import net.kitz.starsiege.world.TiledGameMap;

public class Starsiege extends ApplicationAdapter {

    private SpriteBatch batch;
    private OrthographicCamera cam;
    GameMap gameMap;
    //Player player;

    @Override
    public void create() {
        batch = new SpriteBatch();

        cam = new OrthographicCamera();
        cam.setToOrtho(false, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());

        cam.update();
        gameMap = new TiledGameMap();

    }

    @Override
    public void render() {
        Gdx.gl.glClearColor(1, 0, 0, 1);
        Gdx.gl.glBlendFunc(GL20.GL_SRC_ALPHA, GL20.GL_ONE_MINUS_SRC_ALPHA);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        // cam.position.set(0, 0, 0);
        cam.update();
        gameMap.update(Gdx.graphics.getDeltaTime());
        gameMap.render(cam, batch);
    }

    @Override
    public void dispose() {
        batch.dispose();
    }
}
