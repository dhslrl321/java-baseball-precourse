package baseball.presenter;

import baseball.core.Game;

public class Menu {
    private final Game game;

    private Menu(GameFinder gameFinder) {
        this.game = gameFinder.findBy(1);
    }

    public static Menu from(GameFinder gameFinder) {
        return new Menu(gameFinder);
    }

    public boolean loop() {
        while (game.run())
            ;
        return false;
    }
}
