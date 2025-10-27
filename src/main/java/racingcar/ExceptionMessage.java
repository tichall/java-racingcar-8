package racingcar;

public enum ExceptionMessage {
    PARSE_INT_ERROR("유효한 정수값을 입력해주세요.");

    private final String value;

    ExceptionMessage(String value) {
        this.value = value;
    }

    public String getValue() {
        return this.value;
    }
}
