package baseball.domain;

import java.util.ArrayList;
import java.util.List;

public class Baseball {

    private final List<Integer> randoms;

    private Baseball(List<Integer> randoms) {
        this.randoms = randoms;
    }

    public static Baseball from(List<Integer> randoms) {
        return new Baseball(randoms);
    }

    public int size() {
        return randoms.size();
    }

    public Result compareFrom(UserShot userShot) {
        Result result = new Result();

        List<Integer> numbers = userShot.getNumbers();

        for (int i = 0; i < randoms.size(); i++) {
            Integer randomNumber = randoms.get(i);
            for (int j = 0; j < numbers.size(); j++) {
                Integer inputNumber = numbers.get(j);

                if (randomNumber.equals(inputNumber)) {
                    if (i == j) {
                        result.add(JudgementType.STRIKE);
                        continue;
                    }
                    result.add(JudgementType.BALL);
                }
            }
            result.add(JudgementType.NONE);
        }
        return result;
    }
}
