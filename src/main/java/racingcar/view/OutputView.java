package racingcar.view;

import java.util.List;
import racingcar.model.Car;

public class OutputView {
    private static final String MOVE_INDICATOR = "-";

    public static void printStartMessage() {
        System.out.println("\n실행 결과");
    }

    public static void printMoveResult(List<Car> cars) {
        for (Car car : cars) {
            System.out.printf("%s : %s", car.getName(), MOVE_INDICATOR.repeat(car.getMoveCount()));
            System.out.println();
        }
        System.out.println();
    }

    public static void printWinners(List<Car> winners) {
        String result = String.join(", ", winners.stream().map(Car::getName).toList());
        System.out.printf("최종 우승자 : %s", result);
    }
}