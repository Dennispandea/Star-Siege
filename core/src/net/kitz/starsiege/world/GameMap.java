package net.kitz.starsiege.world;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import net.kitz.starsiege.entities.Entity;
import net.kitz.starsiege.entities.Player;

import java.util.ArrayList;

import static net.kitz.starsiege.world.MapAsteroid.ASTEROID_SIZE;

public abstract class GameMap {

    protected ArrayList<Entity> entities;

    public GameMap() {
        entities = new ArrayList<Entity>();
        entities.add(new Player(20, 20, this));

    }


    public void render(OrthographicCamera camera, SpriteBatch batch) {
        for (Entity entity : entities) {
            entity.render(batch);
        }
    }

    public void update(float delta) {
        for (Entity entity : entities) {
            entity.update(delta, -9.8f);

        }
    }

    public abstract void dispose();


    /**
     * Gets asteroid by position within space at layer selected.
     *
     * @param nLayer
     * @param x
     * @param y
     * @return
     */
    public MapAsteroid getAsteroidbyLocation(int nLayer, float x, float y) {
        return this.getAsteroidbyCoordinate(nLayer, (int) (x / ASTEROID_SIZE), (int) (y / ASTEROID_SIZE));
    }

    /**
     * Gets asteroid at it's coordinate location within space at layer selected.
     *
     * @param layer
     * @param col
     * @param row
     * @return
     */
    public abstract MapAsteroid getAsteroidbyCoordinate(int layer, int col, int row);

    public boolean isColliding(float x, float y, int nWidth, int nLength) {
        if (x < 0 || y < 0 || x + nWidth > nPixelWidth() || y + nLength > nPixelHeight())
            return true;
        for (int row = (int) (y / ASTEROID_SIZE); row < Math.ceil((y + nLength) / ASTEROID_SIZE); row++) {
            for (int col = (int) (y / ASTEROID_SIZE); col < Math.ceil((y + nWidth) / ASTEROID_SIZE); col++) {
                for (int layer = 0; layer < getLayers(); layer++) {
                    MapAsteroid type = getAsteroidbyCoordinate(layer, col, row);
                    if (type != null) return true;
                }
            }
        }
        return false;
    }

    public abstract int getWidth();

    public abstract int getHeight();

    public abstract int getLayers();

    public int nPixelWidth() {
        return this.getWidth() * ASTEROID_SIZE;
    }

    public int nPixelHeight() {
        return this.getHeight() * ASTEROID_SIZE;
    }
}
