package baseball.core;

import static org.assertj.core.api.Assertions.assertThat;

import baseball.domain.Baseball;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class BaseballCreatorTest {

    BaseballCreator sut;

    @BeforeEach
    void setUp() {
        sut = new BaseballCreator();
    }

    @Test
    void 랜덤한_3개의_숫자를_생성한다() {
        Baseball baseball = sut.create();

        assertThat(baseball.size()).isEqualTo(3);
    }
}