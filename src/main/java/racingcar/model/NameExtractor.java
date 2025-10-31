package racingcar.model;

import java.util.List;
import racingcar.exception.ExceptionMessage;

public class NameExtractor {
    private static final String delimiter = ",";
    private static final int maxLength = 5;

    private NameExtractor() {

    }

    public static List<String> extractName(String input) {
        validateNotEndWithDelimiter(input);

        List<String> nameList = List.of(input.split(delimiter));

        for (String name : nameList) {
            validateNotBlank(name);
            validateLength(name);
        }

        return nameList;
    }

    private static void validateNotEndWithDelimiter(String input) {
        if (input.endsWith(delimiter)) {
            throw new IllegalArgumentException(ExceptionMessage.DELIMITER_CANNOT_END_WITH.getValue());
        }
    }

    private static void validateNotBlank(String name) {
        if (name.isBlank()) {
            throw new IllegalArgumentException(ExceptionMessage.NAME_CANNOT_BE_BLANK.getValue());
        }
    }

    private static void validateLength(String name) {
        if (name.length() > maxLength) {
            throw new IllegalArgumentException(ExceptionMessage.NAME_LENGTH_EXCEEDED.getValue());
        }
    }
}
