package racingcar;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import racingcar.view.InputView;
import racingcar.view.OutputView;
import racingcar.view.Prompt;

public class Race {
    private static final String MOVE_INDICATOR = "-";

    private List<Car> cars;
    private int attemptCount;

    public Race() {
        initializeRace();
        startRace();
        printRaceResult();
    }

    private void initializeRace() {
        String input = InputView.readString(Prompt.INPUT_CAR_NAME.getValue());
        List<String> names = NameExtractor.extractName(input);

        CarFactory carFactory = new CarFactory();
        this.cars = carFactory.generateCars(names);
        this.attemptCount = InputView.readInteger(Prompt.INPUT_ATTEMPT_COUNT.getValue());
        validatePositiveInteger(attemptCount);
    }

    private void validatePositiveInteger(int attemptCount) {
        if(attemptCount <= 0) {
            throw new IllegalArgumentException(ExceptionMessage.ATTEMPT_COUNT_MUST_BE_POSITIVE.getValue());
        }
    }

    private void startRace() {
        System.out.println("\n실행 결과");
        for (int i = attemptCount; i > 0; i--) {
            moveCars();
            printMoveResult();
        }
    }

    private void moveCars() {
        for (Car car : cars) {
            attemptMove(car);
        }
    }

    private void attemptMove(Car car) {
        int randomNumber = Randoms.pickNumberInRange(0, 9);
        if (randomNumber >= 4) {
            car.move();
        }
    }

    private void printMoveResult() {
        for (Car car : cars) {
            System.out.printf("%s : %s", car.getName(), MOVE_INDICATOR.repeat(car.getMoveCount()));
            System.out.println();
        }
        System.out.println();
    }

    private void printRaceResult() {
        OutputView.printRaceWinner(findRaceWinner());
    }

    private List<Car> findRaceWinner() {
        List<Car> winners = new ArrayList<>();
        int maxMoveCount = 0;

        for (Car car : cars) {
            if (maxMoveCount == car.getMoveCount()) {
                winners.add(car);
            } else if (maxMoveCount < car.getMoveCount()) {
                maxMoveCount = car.getMoveCount();
                winners.clear();
                winners.add(car);
            }
        }

        return winners;
    }
}
