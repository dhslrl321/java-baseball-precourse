package baseball.domain;

import java.util.List;

public class UserShot {
    private final List<Integer> numbers;

    private UserShot(List<Integer> numbers) {
        this.numbers = numbers;
    }

    public static UserShot from(List<Integer> numbers) {
        return new UserShot(numbers);
    }
}
