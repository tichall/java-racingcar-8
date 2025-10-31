package racingcar.controller;

import java.util.List;
import racingcar.model.Car;
import racingcar.model.Race;
import racingcar.view.InputView;
import racingcar.view.OutputView;
import racingcar.view.Prompt;

public class RaceController {
    public void run() {
        String carNamesInput = InputView.readString(Prompt.INPUT_CAR_NAME.getValue());
        int attemptCount = InputView.readInteger(Prompt.INPUT_ATTEMPT_COUNT.getValue());

        Race race = new Race(carNamesInput, attemptCount);
        race.start();

        List<Car> winners = race.findRaceWinner();
        OutputView.printWinners(winners);
    }
}
