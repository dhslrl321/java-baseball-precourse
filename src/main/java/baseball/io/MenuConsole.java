package baseball.io;

import java.util.List;

public class MenuConsole {

    private final InputReader reader = new InputReader();

    public int queryStartGame() {
        return reader.readNumber();
    }

    public int queryRestartGame() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        return reader.readNumber();
    }
}
