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

            String message = getResultMessage(baseball, userShot);

            if (EXIT_MESSAGE.equals(message)) {
                console.printOutro();
                int restartNumber = console.queryRestartGame();
                return restartNumber != 2;
            }
        }
    }

    private String getResultMessage(Baseball baseball, UserShot userShot) {
        Result result = baseball.compareFrom(userShot);
        String message = resultHandler.convertToMessage(result);

        console.printResult(message);
        return message;
    }

    private UserShot getUserShot() {
        List<Integer> inputs = console.queryStartGame();
        return UserShot.from(inputs);
    }

}
