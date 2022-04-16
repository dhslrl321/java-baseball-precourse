package baseball.presenter;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import baseball.core.BaseballGame;
import baseball.core.Game;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class GameFinderTest {
    GameFinder sut;

    @BeforeEach
    void setUp() {
        sut = new GameFinder();
    }

    @Test
    void 숫자야구_게임번호를_입력하면_숫자야구_게임을_반환한다() {
        int baseballGameNumber = 1;
        Game game = sut.findBy(baseballGameNumber);

        assertThat(game).isExactlyInstanceOf(BaseballGame.class);
    }

    @Test
    void 잘못된_게임_번호를_입력하면_예외를_던진다() {
        int notExistGameNumber = 2;

        assertThatThrownBy(() -> sut.findBy(notExistGameNumber))
                .isInstanceOf(IllegalArgumentException.class);
    }
}