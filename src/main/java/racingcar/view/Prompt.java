package racingcar.view;

public enum Prompt {
    INPUT_CAR_NAME("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)"),
    INPUT_ATTEMPT_COUNT("시도할 횟수는 몇 회인가요?");

    private final String value;

    Prompt(String value) {
        this.value = value;
    }

    public String getValue() {
        return this.value;
    }
}