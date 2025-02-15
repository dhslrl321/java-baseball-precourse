package baseball.io;

import java.util.List;

public class BaseballConsole {
    private final InputReader reader = new InputReader();

    public List<Integer> queryStartGame() {
        System.out.print("숫자를 입력해주세요 : ");
        return reader.readThreeNumbers();
    }

    public void printResult(String message) {
        System.out.println(message);
    }

    public int queryRestartGame() {
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        return reader.readNumber();
    }
}
