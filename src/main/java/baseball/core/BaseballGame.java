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
            List<Integer> inputs = console.queryStartGame();
            UserShot userShot = UserShot.from(inputs);

            Result result = baseball.compareFrom(userShot);
            String message = resultHandler.convertToMessage(result);

            console.printResult(message);

            if (EXIT_MESSAGE.equals(message)) {
                console.printOutro();
                int restartNumber = console.queryRestartGame();
                if (restartNumber == 2) {
                    return false;
                } else {
                    resultHandler.flush();
                    return true;
                }
            }
            resultHandler.flush();
        }
    }
}
