package baseball.core;

import baseball.domain.Baseball;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class BaseballCreator {

    public Baseball create() {
        Set<Integer> uniqueNumberSet = pickUniqueNumberSet();
        List<Integer> randoms = setToList(uniqueNumberSet);
        return Baseball.from(randoms);
    }

    private List<Integer> setToList(Set<Integer> set) {
        return new ArrayList<>(set);
    }

    private Set<Integer> pickUniqueNumberSet() {
        Set<Integer> uniqueNumbers = new HashSet<>();
        while (uniqueNumbers.size() < 3) {
            uniqueNumbers.add(Randoms.pickNumberInRange(1, 9));
        }
        return uniqueNumbers;
    }
}
