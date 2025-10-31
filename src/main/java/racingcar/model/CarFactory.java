package racingcar.model;

import java.util.ArrayList;
import java.util.List;

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