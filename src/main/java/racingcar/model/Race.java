package racingcar.model;

import java.util.ArrayList;
import java.util.List;
import racingcar.exception.ExceptionMessage;
import racingcar.view.OutputView;

public class Race {
    private final List<Car> cars;
    private final int attemptCount;

    public Race(String carNamesInput, int attemptCount) {
        validatePositiveInteger(attemptCount);

        this.cars = CarFactory.generateCars(carNamesInput);
        this.attemptCount = attemptCount;
    }

    private void validatePositiveInteger(int attemptCount) {
        if (attemptCount <= 0) {
            throw new IllegalArgumentException(ExceptionMessage.ATTEMPT_COUNT_MUST_BE_POSITIVE.getValue());
        }
    }

    public void start() {
        OutputView.printStartMessage();
        for (int i = attemptCount; i > 0; i--) {
            moveCars();
            OutputView.printMoveResult(cars);
        }
    }

    private void moveCars() {
        for (Car car : cars) {
            car.move();
        }
    }

    public List<Car> findRaceWinner() {
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
