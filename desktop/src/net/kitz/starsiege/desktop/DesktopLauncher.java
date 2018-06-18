package net.kitz.starsiege.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import net.kitz.starsiege.Starsiege;

public class DesktopLauncher {
    public static void main(String[] arg) {
        LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
        config.height = 720;
        config.width = 1280;
        config.resizable=false;
        config.foregroundFPS=800;
        new LwjglApplication(new Starsiege(), config);
    }
}
