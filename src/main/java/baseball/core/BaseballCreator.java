package baseball.core;

import baseball.domain.Baseball;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;

public class BaseballCreator {

    public Baseball create() {
        List<Integer> randoms = Randoms.pickUniqueNumbersInRange(1, 9, 3);
        return Baseball.from(randoms);
    }
}
