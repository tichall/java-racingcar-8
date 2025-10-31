package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import racingcar.exception.ExceptionMessage;

public class InputView {
    private InputView() {

    }

    public static String readString(String prompt) {
        System.out.println(prompt);
        return Console.readLine();
    }

    public static int readInteger(String prompt) {
        System.out.println(prompt);
        try {
            return Integer.parseInt(Console.readLine());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ExceptionMessage.PARSE_INT_ERROR.getValue());
        }
    }
}