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

    public List<Integer> readNumbersWithNoSpace() {

        String input = Console.readLine();
        String[] numberString = input.split("");

        List<Integer> numbers = new ArrayList<>();

        for (String s : numberString) {
            validateNumber(s);

            int number = Integer.parseInt(s);
            numbers.add(number);
        }

        return numbers;
    }

    private void validateNumber(String input) {
        if (!input.matches(NUMBER_REGEX)) {
            throw new IllegalArgumentException("입력이 잘못되었습니다. 숫자만 입력할 수 있습니다.");
        }
    }
}
