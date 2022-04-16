package baseball;

import baseball.io.MenuConsole;
import baseball.presenter.GameFinder;
import baseball.presenter.Menu;

public class Application {
    public static void main(String[] args) {
        Menu menu = Menu.of(new MenuConsole(), new GameFinder());
        while(menu.loop());
    }
}
