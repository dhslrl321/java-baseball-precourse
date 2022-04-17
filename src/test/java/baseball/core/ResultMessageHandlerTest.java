package baseball.core;

import static baseball.domain.JudgementType.*;
import static org.assertj.core.api.Assertions.assertThat;

import baseball.domain.JudgementType;
import baseball.domain.Result;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ResultMessageHandlerTest {
    ResultMessageHandler sut;

    @BeforeEach
    void setUp() {
        sut = new ResultMessageHandler();
    }

    @Test
    void 낫싱을_출력한다() {
        Result result = Result.from(new ArrayList<>());
        String message = sut.convertToMessage(result);

        assertThat(message).isEqualTo("낫싱");
    }

    @Test
    void 볼1_스트라이크2를_출력한다() {
        Result result = Result.from(createMockResultBy(STRIKE, STRIKE, BALL));
        String message = sut.convertToMessage(result);

        assertThat(message).isEqualTo("1볼 2스트라이크");
    }

    @Test
    void 볼1_스트라이크1를_출력한다() {
        Result result = Result.from(createMockResultBy(STRIKE, BALL));
        String message = sut.convertToMessage(result);

        assertThat(message).isEqualTo("1볼 1스트라이크");
    }

    @Test
    void 스트라이크3_을_출력한다() {
        Result result = Result.from(createMockResultBy(STRIKE, STRIKE, STRIKE));
        String message = sut.convertToMessage(result);

        assertThat(message).isEqualTo("3스트라이크");
    }

    @Test
    void 볼3_을_출력한다() {
        Result result = Result.from(createMockResultBy(BALL, BALL, BALL));
        String message = sut.convertToMessage(result);

        assertThat(message).isEqualTo("3볼");
    }

    private List<JudgementType> createMockResultBy(JudgementType ...types) {
        return new ArrayList<>(Arrays.asList(types));
    }
}