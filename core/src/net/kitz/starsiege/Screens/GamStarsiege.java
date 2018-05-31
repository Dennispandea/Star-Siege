package net.kitz.starsiege.Screens;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.MathUtils;
import net.kitz.starsiege.GameStartMenu;
import net.kitz.starsiege.entities.SprPlayer;
import net.kitz.starsiege.world.GameMap;
import net.kitz.starsiege.world.TiledGameMap;

public class GamStarsiege extends ApplicationAdapter implements Screen {

    private SpriteBatch batch;
    private OrthographicCamera cam;
    GameMap gameMap;
    SprPlayer sprPlayer;
    Music music;

    public GamStarsiege(GameStartMenu _gameStartMenu) {
        GameStartMenu gameStartMenu = _gameStartMenu;
    }

    @Override
    public void create() {
        batch = new SpriteBatch();

        music = Gdx.audio.newMusic(Gdx.files.internal("data/music/music.mp3"));
        music.play();
        music.setVolume(0.1f);
        music.setLooping(true);

        cam = new OrthographicCamera();
        cam.setToOrtho(false, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());

        gameMap = new TiledGameMap();

        sprPlayer = (SprPlayer) gameMap.entities.get(0);
    }

    @Override
    public void render() {
        Gdx.gl.glClearColor(1, 0, 0, 1);
        Gdx.gl.glBlendFunc(GL20.GL_SRC_ALPHA, GL20.GL_ONE_MINUS_SRC_ALPHA);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        cam.position.set(MathUtils.round(sprPlayer.getPos().x + (sprPlayer.getWidth() / 2)), MathUtils.round(sprPlayer.getPos().y + (sprPlayer.getLength() / 2)), 0);
        cam.position.x = MathUtils.clamp(cam.position.x, 640, 15744);
        cam.position.y = MathUtils.clamp(cam.position.y, 360, 16024);


        cam.update();
        gameMap.update(Gdx.graphics.getDeltaTime());
        gameMap.render(cam, batch);
    }

    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {
        batch.dispose();
        music.dispose();
    }
}
