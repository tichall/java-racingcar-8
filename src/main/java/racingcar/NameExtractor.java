package racingcar;

import java.util.List;

public class NameExtractor {
    private static final String delimiter = ",";
    private static final Integer maxLength = 5;

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
            throw new IllegalArgumentException(ExceptionMessage.NAME_CANNOT_BE_EMPTY.getValue());
        }
    }

    private static void validateLength(String name) {
        if(name.length() > maxLength) {
            throw new IllegalArgumentException(ExceptionMessage.NAME_LENGTH_EXCEEDED.getValue());
        }
    }
}
