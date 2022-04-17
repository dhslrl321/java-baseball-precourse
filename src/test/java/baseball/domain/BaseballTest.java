package baseball.domain;

import static baseball.domain.JudgementType.BALL;
import static baseball.domain.JudgementType.NONE;
import static baseball.domain.JudgementType.STRIKE;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class BaseballTest {

    Baseball sut;

    @BeforeEach
    void setUp() {
        List<Integer> numbersBy = createNumbersBy(1, 2, 3);
        sut = Baseball.from(numbersBy);
    }

    @Test
    void 정답과_입력이_모두_다를_경우() {
        List<Integer> numbersBy = createNumbersBy(4, 5, 6);

        UserShot userShot = UserShot.from(numbersBy);
        Result result = sut.compareFrom(userShot);

        assertThat(result.judgements()).contains(NONE, NONE, NONE);
    }

    @Test
    void 정답중_하나가_위치와_숫자가_같은_경우() {
        List<Integer> numbersBy = createNumbersBy(4, 5, 3);

        UserShot userShot = UserShot.from(numbersBy);
        Result result = sut.compareFrom(userShot);

        assertThat(result.judgements()).contains(STRIKE, NONE, NONE);
    }

    @Test
    void 정답중_둘이_위치와_숫자가_같은_경우() {
        List<Integer> numbersBy = createNumbersBy(1, 4, 3);

        UserShot userShot = UserShot.from(numbersBy);
        Result result = sut.compareFrom(userShot);

        assertThat(result.judgements()).contains(STRIKE, NONE, STRIKE);
    }

    @Test
    void 정답중_셋이_위치와_숫자가_같은_경우() {
        List<Integer> numbersBy = createNumbersBy(1, 2, 3);

        UserShot userShot = UserShot.from(numbersBy);
        Result result = sut.compareFrom(userShot);

        assertThat(result.judgements()).contains(STRIKE, STRIKE, STRIKE);
    }

    @Test
    void 정답중_둘이_숫자만_같은_경우() {
        List<Integer> numbersBy = createNumbersBy(3, 1, 5);

        UserShot userShot = UserShot.from(numbersBy);
        Result result = sut.compareFrom(userShot);

        assertThat(result.judgements()).contains(NONE, BALL, BALL);
    }

    private List<Integer> createNumbersBy(Integer ...integers) {
        List<Integer> numbers = new ArrayList<>(Arrays.asList(integers));
        return numbers;
    }
}