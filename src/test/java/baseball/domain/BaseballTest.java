package baseball.domain;

import static baseball.domain.JudgementType.BALL;
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
        List<Integer> numbersBy = createMockNumbersBy(1, 2, 3);
        sut = Baseball.from(numbersBy);
    }

    @Test
    void 정답과_입력이_모두_다를_경우() {
        List<Integer> numbersBy = createMockNumbersBy(4, 5, 6);

        UserShot userShot = UserShot.from(numbersBy);
        Result result = sut.compareFrom(userShot);

        assertThat(result.judgements().size()).isEqualTo(0);
    }

    @Test
    void 정답중_하나가_위치와_숫자가_같은_경우() {
        List<Integer> numbersBy = createMockNumbersBy(4, 5, 3);

        UserShot userShot = UserShot.from(numbersBy);
        Result result = sut.compareFrom(userShot);

        assertThat(result.judgements()).contains(STRIKE);
        assertThat(result.judgements().size()).isEqualTo(1);
    }

    @Test
    void 정답중_둘이_위치와_숫자가_같은_경우() {
        List<Integer> numbersBy = createMockNumbersBy(1, 4, 3);

        UserShot userShot = UserShot.from(numbersBy);
        Result result = sut.compareFrom(userShot);

        assertThat(result.judgements()).contains(STRIKE, STRIKE);
        assertThat(result.judgements().size()).isEqualTo(2);
    }

    @Test
    void 정답중_셋이_위치와_숫자가_같은_경우() {
        List<Integer> numbersBy = createMockNumbersBy(1, 2, 3);

        UserShot userShot = UserShot.from(numbersBy);
        Result result = sut.compareFrom(userShot);

        assertThat(result.judgements()).contains(STRIKE, STRIKE, STRIKE);
        assertThat(result.judgements().size()).isEqualTo(3);
    }

    @Test
    void 정답중_둘이_숫자만_같은_경우() {
        List<Integer> numbersBy = createMockNumbersBy(3, 1, 5);

        UserShot userShot = UserShot.from(numbersBy);
        Result result = sut.compareFrom(userShot);

        assertThat(result.judgements()).contains(BALL, BALL);
        assertThat(result.judgements().size()).isEqualTo(2);
    }

    private List<Integer> createMockNumbersBy(Integer... integers) {
        return new ArrayList<>(Arrays.asList(integers));
    }
}