package baseball;

import baseball.presenter.GameFinder;
import baseball.presenter.Menu;

public class Application {
    public static void main(String[] args) {
        Menu menu = Menu.from(new GameFinder());
        menu.loop();
    }
}
