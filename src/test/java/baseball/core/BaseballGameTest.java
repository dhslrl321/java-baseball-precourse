package baseball.core;

import static baseball.domain.JudgementType.*;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import baseball.domain.Baseball;
import baseball.domain.JudgementType;
import baseball.domain.Result;
import baseball.domain.UserShot;
import baseball.io.BaseballConsole;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class BaseballGameTest {

    BaseballGame sut;

    BaseballConsole console = mock(BaseballConsole.class);
    BaseballCreator baseballCreator = mock(BaseballCreator.class);
    ResultMessageHandler handler = mock(ResultMessageHandler.class);

    @BeforeEach
    void setUp() {
        sut = BaseballGame.of(console, baseballCreator, handler);
    }

    @Test
    void 스트라이크3_이후_사용자가_2를_누르면_종료된다() {
        Baseball baseball = mock(Baseball.class);

        given(baseballCreator.create()).willReturn(baseball);
        given(handler.convertToMessage(any())).willReturn("3스트라이크");
        given(console.queryRestartGame()).willReturn(2);

        boolean run = sut.run();

        assertThat(run).isFalse();
    }
}