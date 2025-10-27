package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import racingcar.ExceptionMessage;

public class ConsoleView {
    public static final String CAR_NAME_PROMPT = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    public static final String ATTEMPT_COUNT_PROMPT = "시도할 횟수는 몇 회인가요?";

    public static String readStringInput(String guide) {
        System.out.println(guide);
        return Console.readLine();
    }

    public static int readIntInput(String guide) {
        System.out.println(guide);
        try {
            return Integer.parseInt(Console.readLine());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ExceptionMessage.PARSE_INT_ERROR.getValue());
        }
    }
}
