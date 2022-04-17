package baseball.core;

import baseball.domain.Baseball;
import baseball.domain.Result;
import baseball.domain.UserShot;
import baseball.io.BaseballConsole;
import java.util.List;

public class BaseballGame implements Game {

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
        while (!loopWithJudge(baseball))
            ;
        int restartNumber = console.queryRestartGame();
        return restartNumber != 2;
    }

    private boolean loopWithJudge(Baseball baseball) {
        UserShot userShot = getUserShot();
        String message = judge(baseball, userShot);
        return isEnd(message);
    }

    private boolean isEnd(String message) {
        return "3스트라이크".equals(message);
    }

    private String judge(Baseball baseball, UserShot userShot) {
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
