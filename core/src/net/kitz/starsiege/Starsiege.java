package net.kitz.starsiege;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.MathUtils;
import net.kitz.starsiege.entities.Player;
import net.kitz.starsiege.world.GameMap;
import net.kitz.starsiege.world.TiledGameMap;

public class Starsiege extends ApplicationAdapter {

    private SpriteBatch batch;
    private OrthographicCamera cam;
    GameMap gameMap;
    Player player;
    Music music;


    @Override
    public void create() {
        batch = new SpriteBatch();

        music = Gdx.audio.newMusic(Gdx.files.internal("data/music.mp3"));
        music.play();
        music.setVolume(0.1f);
        music.setLooping(true);

        cam = new OrthographicCamera();
        cam.setToOrtho(false, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());

        cam.update();
        gameMap = new TiledGameMap();

        player = (Player) gameMap.entities.get(0);
    }

    @Override
    public void render() {
        Gdx.gl.glClearColor(1, 0, 0, 1);
        Gdx.gl.glBlendFunc(GL20.GL_SRC_ALPHA, GL20.GL_ONE_MINUS_SRC_ALPHA);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        if (player.getPos().x >= 640 && player.getPos().y >= 360 && player.getPos().x <= 15744 && player.getPos().y <= 16024) {
            cam.position.set(MathUtils.round(player.getPos().x), MathUtils.round(player.getPos().y), 0);
        } else if (player.getPos().x >= 640 && player.getPos().y <= 360) {
            cam.position.set(MathUtils.round(player.getPos().x), 360, 0);
        } else if (player.getPos().x <= 640 && player.getPos().y >= 360) {
            cam.position.set(640, MathUtils.round(player.getPos().y), 0);
        } else if (player.getPos().x >= 15744 && player.getPos().y >= 16024) {
            cam.position.set(15744, 16024, 0);
        } else if (player.getPos().x >= 15744 && player.getPos().y <= 16024) {
            cam.position.set(15744, MathUtils.round(player.getPos().y), 0);
        } else if (player.getPos().x <= 15744 && player.getPos().y >= 16024) {
            cam.position.set(MathUtils.round(player.getPos().x), 16024, 0);
        }


        cam.update();
        gameMap.update(Gdx.graphics.getDeltaTime());
        gameMap.render(cam, batch);
    }

    @Override
    public void dispose() {
        batch.dispose();
        music.dispose();
    }
}
