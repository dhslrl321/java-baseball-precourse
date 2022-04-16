package baseball.presenter;

import baseball.core.Game;
import baseball.io.MenuConsole;

public class Menu {
    private final MenuConsole console;
    private final Game game;

    public Menu(MenuConsole console, GameFinder gameFinder) {
        this.console = console;
        this.game = gameFinder.findBy(1);
    }

    public boolean loop() {
        int startQueryNumber = console.queryStartGame();

        validateStartQueryNumber(startQueryNumber);

        if (startQueryNumber != 1) {
            return false;
        }

        while (game.run());
        return true;
    }

    private void validateStartQueryNumber(int startQueryNumber) {
        if (startQueryNumber != 1 && startQueryNumber != 2) {
            String errorMessage = "메뉴 선택을 다시해주세요 [(1) 시작, (2) 종료] 만 선택할 수 있습니다.";
            throw new IllegalArgumentException(errorMessage);
        }
    }
}
