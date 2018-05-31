package net.kitz.starsiege.Screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;

public class Button extends Sprite {
    public Button(int nW, int nH, int nX, int nY, String sFileName) {
        super(new Texture(Gdx.files.internal(sFileName)));  //For example "SignB.jpg"
        setPosition(nX, nY);
        setFlip(false, true);
        setSize(nW, nH);
    }
}
