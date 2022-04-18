package baseball;

import baseball.presenter.GameFinder;
import baseball.presenter.GameManager;

public class Application {
    public static void main(String[] args) {
        GameManager gameManager = GameManager.from(new GameFinder());
        gameManager.start();
    }
}
