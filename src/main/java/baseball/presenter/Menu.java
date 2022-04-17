package baseball.presenter;

import baseball.core.Game;
import baseball.io.MenuConsole;

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
        return true;
    }

    private void validateStartQueryNumber(int startQueryNumber) {
        if (startQueryNumber != 1 && startQueryNumber != 2) {
            String errorMessage = "메뉴 선택을 다시해주세요 [(1) 시작, (2) 종료] 만 선택할 수 있습니다.";
            throw new IllegalArgumentException(errorMessage);
        }
    }
}
