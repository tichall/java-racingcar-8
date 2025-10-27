package racingcar;

import java.util.ArrayList;
import java.util.List;

public class CarFactory {

    public List<Car> generateCars(List<String> names) {
        List<Car> cars = new ArrayList<>();

        for (String name : names) {
            cars.add(new Car(name));
        }

        return cars;
    }
}