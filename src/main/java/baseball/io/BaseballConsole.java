package baseball.io;

import java.util.List;

public class BaseballConsole {
    private final InputReader reader = new InputReader();

    public List<Integer> queryStartGame() {
        System.out.print("숫자를 입력해주세요 : ");
        return reader.readNumbersWithNoSpace();
    }

    public void printResult(String message) {
        System.out.println(message);
    }

    public void printOutro() {
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
    }
}
