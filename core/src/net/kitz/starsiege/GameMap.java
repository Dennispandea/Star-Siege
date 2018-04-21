package net.kitz.starsiege;

import com.badlogic.gdx.graphics.OrthographicCamera;

public abstract class GameMap {

    public abstract class AsteroidMap {


    }

    public abstract void render(OrthographicCamera camera);

    public abstract void update(float delta);

    public abstract void dispose();


    /**
     * Gets asteroid by position within space at layer selected.
     *
     * @param layer
     * @param x
     * @param y
     * @return
     */
    public MapAsteroid getAsteroidbyLocation(int layer, float x, float y) {
        return this.getAsteroidbyCoordinate(layer, (int) (x / MapAsteroid.ASTEROID_SIZE), (int) (y / MapAsteroid.ASTEROID_SIZE));
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


    public abstract int getWidth();

    public abstract int getHeight();

    public abstract int getLayers();
}
