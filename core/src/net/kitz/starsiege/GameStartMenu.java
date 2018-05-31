package net.kitz.starsiege;

import com.badlogic.gdx.Game;
import net.kitz.starsiege.Screens.GamStarsiege;
import net.kitz.starsiege.Screens.ScrMenu;

//thanks to scott and nicole for the code im stealing :)

public class GameStartMenu extends Game {
    GamStarsiege gamStarsiege;
    ScrMenu scrMenu;

    int nScreen; // 0 for menu, 1 for play, 2 for Sign, 3 for Animation, 4 for AniHit, 5 for Game, 6 for GameOver, 7 for
    // AnimalChoice, 8 for AnimalChoice2, 9 for Game2, 10 for Rules, 11 for Game3

    public void updateState(int _nScreen) {
        nScreen = _nScreen;
        if (nScreen == 0) {
            setScreen(scrMenu);
        } else if (nScreen == 1) {
            setScreen(gamStarsiege);
        }

    }

    @Override
    public void create() {
        nScreen = 0;
        // notice that "this" is passed to each screen. Each screen now has access to methods within the "game" master program
        scrMenu = new ScrMenu(this);
        gamStarsiege = new GamStarsiege(this);
        updateState(0);
    }

    @Override
    public void render() {
        super.render();
    }

    @Override
    public void dispose() {
        super.dispose();
    }
}

