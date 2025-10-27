package racingcar;

import java.util.ArrayList;
import java.util.List;
import racingcar.model.Car;

public class CarFactory {
    private CarFactory() {
    }

    public static List<Car> generateCars(String carNamesInput) {
        List<String> names = NameExtractor.extractName(carNamesInput);
        List<Car> cars = new ArrayList<>();

        for (String name : names) {
            cars.add(new Car(name));
        }

        return cars;
    }
}