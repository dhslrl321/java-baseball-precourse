package baseball.io;

import java.util.List;

public class BaseballConsole {
    private final InputReader reader = new InputReader();

    public List<Integer> queryStartGame() {
        System.out.println("숫자를 입력해주세요 : ");
        return reader.readNumbersWithNoSpace();
    }
}
