package baseball.io;

import java.util.List;

public class MenuConsole {

    private final InputReader reader = new InputReader();

    public int queryStartGame() {
        System.out.println("게임을 시작하시겠습니까?");
        System.out.println("yes(1) / no(2)");
        return reader.readNumber();
    }

    public int queryRestartGame() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        return reader.readNumber();
    }
}
