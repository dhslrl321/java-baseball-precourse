package baseball.domain;

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
        Result result = Result.empty();
        List<Integer> numbers = userShot.getNumbers();

        for (int i = 0; i < randoms.size(); i++) {
            Integer randomNumber = randoms.get(i);
            addJudgementToResult(result, randomNumber, numbers, i);
        }
        return result;
    }

    private void addJudgementToResult(Result result,
                                      int randomNumber,
                                      List<Integer> numbers,
                                      int index) {

        for (int i = 0; i < numbers.size(); i++) {
            Integer inputNumber = numbers.get(i);
            addValidJudgementToResult(result, randomNumber, inputNumber, i, index);
        }
    }

    private void addValidJudgementToResult(Result result,
                                           int randomNumber,
                                           int inputNumber,
                                           int index1,
                                           int index2) {
        if (randomNumber == inputNumber) {
            JudgementType judgementByIndex = getValidJudgement(index1, index2);
            result.add(judgementByIndex);
        }
    }

    private JudgementType getValidJudgement(int index1, int index2) {
        if (index1 == index2) {
            return JudgementType.STRIKE;
        }
        return JudgementType.BALL;
    }
}
