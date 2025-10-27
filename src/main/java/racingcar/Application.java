package racingcar;

import racingcar.controller.RaceController;
import racingcar.model.Race;

public class Application {
    public static void main(String[] args) {
        try {
            RaceController controller = new RaceController();
            controller.run();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            throw e;
        }
    }
}
