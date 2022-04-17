package baseball.domain;

import java.util.ArrayList;
import java.util.List;

public class Result {
    private final List<JudgementType> judgementTypes;

    private Result(List<JudgementType> types) {
        judgementTypes = types;
    }

    public static Result empty() {
        return new Result(new ArrayList<>());
    }

    public static Result from(List<JudgementType> types) {
        return new Result(types);
    }

    public void add(JudgementType type) {
        judgementTypes.add(type);
    }

    public List<JudgementType> judgements() {
        return judgementTypes;
    }
}
