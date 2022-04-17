package baseball.presenter;

import baseball.core.BaseballCreator;
import baseball.core.BaseballGame;
import baseball.core.Game;
import baseball.core.ResultMessageHandler;
import baseball.io.BaseballConsole;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

public class GameFinder {

    private final Map<Integer, Game> games = new LinkedHashMap<>();

    public GameFinder() {
        games.put(1, BaseballGame.of(new BaseballConsole(), new BaseballCreator(), new ResultMessageHandler()));
    }

    public Game findBy(int gameNumber) {
        if (!isValidGameNumber(gameNumber)) {
            throw new IllegalArgumentException("게임이 존재하지 않습니다");
        }
        return games.get(gameNumber);
    }

    private boolean isValidGameNumber(int gameNumber) {
        Set<Integer> keys = games.keySet();
        return keys.contains(gameNumber);
    }
}
