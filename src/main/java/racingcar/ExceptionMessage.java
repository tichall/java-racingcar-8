package racingcar;

public enum ExceptionMessage {
    PARSE_INT_ERROR("유효한 정수값을 입력해주세요."),
    ATTEMPT_COUNT_MUST_BE_POSITIVE("시도 횟수는 양수여야 합니다."),
    DELIMITER_CANNOT_END_WITH("구분자로 끝나면 안됩니다."),
    NAME_CANNOT_BE_EMPTY("이름은 비어있으면 안됩니다."),
    NAME_LENGTH_EXCEEDED("이름 길이는 5자를 초과할 수 없습니다.")
    ;

    private final String value;

    ExceptionMessage(String value) {
        this.value = value;
    }

    public String getValue() {
        return this.value;
    }
}
