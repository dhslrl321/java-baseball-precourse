package baseball.core;

import static baseball.domain.JudgementType.BALL;
import static baseball.domain.JudgementType.STRIKE;

import baseball.domain.JudgementType;
import baseball.domain.Result;
import java.util.List;

public class ResultMessageHandler {

    private int ballCount;
    private int strikeCount;

    public String convertToMessage(Result result) {
        flush();
        List<JudgementType> judgements = result.judgements();
        for (JudgementType judgement : judgements) {
            counting(judgement);
        }
        if (judgements.size() == 0) {
            return "낫싱";
        }

        if (ballCount != 0 && strikeCount != 0) {
            return multipleResult();
        }

        return singleResult();
    }

    private void flush() {
        ballCount = 0;
        strikeCount = 0;
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
        if (BALL.equals(type)) {
            ballCount++;
        }
        if (STRIKE.equals(type)) {
            strikeCount++;
        }
    }
}
