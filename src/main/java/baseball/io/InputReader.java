package baseball.io;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;

public class InputReader {

    private final String NUMBER_REGEX = "^[0-9]*$";

    public int readNumber() {
        String numberString = Console.readLine();
        validateNumber(numberString);

        return Integer.parseInt(numberString);
    }

    public List<Integer> readThreeNumbers() {

        String input = Console.readLine();
        String[] numberString = input.split("");

        List<Integer> numbers = new ArrayList<>();

        for (String s : numberString) {
            validateNumber(s);

            int number = Integer.parseInt(s);
            numbers.add(number);
        }
        validateThreeNumber(numbers.size());
        return numbers;
    }

    private void validateNumber(String input) {
        if (!input.matches(NUMBER_REGEX)) {
            throw new IllegalArgumentException("입력이 잘못되었습니다. 숫자만 입력할 수 있습니다.");
        }
    }

    private void validateThreeNumber(int size) {
        if (size > 3) {
            throw new IllegalArgumentException("입력이 잘못되었습니다. 3자리 숫자만 입력할 수 있습니다.");
        }
    }
}
