package baseball.core;

import static baseball.domain.JudgementType.*;

import baseball.domain.JudgementType;
import baseball.domain.Result;
import java.util.List;

public class ResultMessageHandler {

    private int noneCount = 0;
    private int ballCount = 0;
    private int strikeCount = 0;

    public String convertToMessage(Result result) {
        List<JudgementType> judgements = result.judgements();
        for (JudgementType judgement : judgements) {
            counting(judgement);
        }
        if (noneCount == judgements.size()) {
            return "낫싱";
        }

        if (ballCount != 0 && strikeCount != 0) {
            return multipleResult();
        }

        return singleResult();
    }

    private String singleResult() {
        if (ballCount != 0) {
            return String.format("%d볼", ballCount);
        }
        return String.format("%d스트라이크", strikeCount);
    }

    private String multipleResult() {
        return String.format("%d볼 %d스트라이크", ballCount, strikeCount);
    }

    private void counting(JudgementType type) {
        if (NONE.equals(type)) {
            noneCount++;
        }
        if (BALL.equals(type)) {
            ballCount++;
        }
        if (STRIKE.equals(type)) {
            strikeCount++;
        }
    }
}
