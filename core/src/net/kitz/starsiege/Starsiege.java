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

        music = Gdx.audio.newMusic(Gdx.files.internal("data/music/music.mp3"));
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

        cam.position.set(MathUtils.round(player.getPos().x + (player.getWidth() / 2)), MathUtils.round(player.getPos().y + (player.getLength() / 2)), 0);
        cam.position.x = MathUtils.clamp(cam.position.x, 640, 15744);
        cam.position.y = MathUtils.clamp(cam.position.y, 360, 16024);


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
