package baseball.core;

import baseball.domain.Baseball;
import baseball.domain.Result;
import baseball.domain.UserShot;
import baseball.io.BaseballConsole;
import java.util.List;

public class BaseballGame implements Game {

    private final String EXIT_MESSAGE = "3스트라이크";

    private final BaseballConsole console;
    private final BaseballCreator baseballCreator;
    private final ResultMessageHandler resultHandler;

    private BaseballGame(BaseballConsole console,
                         BaseballCreator baseballCreator,
                         ResultMessageHandler resultHandler) {

        this.console = console;
        this.baseballCreator = baseballCreator;
        this.resultHandler = resultHandler;
    }

    public static BaseballGame of(BaseballConsole console,
                                  BaseballCreator baseballCreator,
                                  ResultMessageHandler handler) {

        return new BaseballGame(console, baseballCreator, handler);
    }

    @Override
    public boolean run() {
        Baseball baseball = baseballCreator.create();
        while (true) {
            UserShot userShot = getUserShot();

            Result result = baseball.compareFrom(userShot);
            String message = resultHandler.convertToMessage(result);

            console.printResult(message);

            if (EXIT_MESSAGE.equals(message)) {
                console.printOutro();
                int restartNumber = console.queryRestartGame();
                if (restartNumber == 2) {
                    return false;
                }
                resultHandler.flush();
                return true;
            }
            resultHandler.flush();
        }
    }

    private UserShot getUserShot() {
        List<Integer> inputs = console.queryStartGame();
        validateUserInput(inputs.size());
        return UserShot.from(inputs);
    }

    private void validateUserInput(int size) {
        if (size > 3) {
            throw new IllegalArgumentException("입력이 잘못되었습니다. 3자리 숫자만 입력할 수 있습니다.");
        }
    }
}
