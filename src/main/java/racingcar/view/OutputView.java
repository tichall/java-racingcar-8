package racingcar.view;

import java.util.List;
import racingcar.Car;

public class OutputView {
    public static void printRaceWinner(List<Car> winners) {
        String result = String.join(", ", winners.stream().map(Car::getName).toList());
        System.out.printf("최종 우승자 : %s", result);
    }
}