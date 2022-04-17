package baseball.presenter;

import baseball.core.Game;

public class Menu {
    private final Game game;

    public static Menu from(GameFinder gameFinder) {
        return new Menu(gameFinder);
    }

    private Menu(GameFinder gameFinder) {
        this.game = gameFinder.findBy(1);
    }

    public boolean loop() {
        while (game.run());
        return false;
    }
}
