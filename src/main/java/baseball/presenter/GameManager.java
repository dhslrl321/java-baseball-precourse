package baseball.presenter;

import baseball.core.Game;

public class GameManager {
    private final Game game;

    private GameManager(GameFinder gameFinder) {
        this.game = gameFinder.findBy(1);
    }

    public static GameManager from(GameFinder gameFinder) {
        return new GameManager(gameFinder);
    }

    public void start() {
        while (game.run())
            ;
    }
}
