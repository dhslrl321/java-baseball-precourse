package baseball.domain;

import java.util.ArrayList;
import java.util.List;

public class Result {
    private final List<JudgementType> judgementTypes = new ArrayList<>();

    public void add(JudgementType type) {
        judgementTypes.add(type);
    }

    public List<JudgementType> judgements() {
        return judgementTypes;
    }
}
