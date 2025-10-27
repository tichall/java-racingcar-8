package racingcar.model;

import camp.nextstep.edu.missionutils.Randoms;

public class Car {
    private static final int MOVE_CONDITION = 4;
    private final String name;
    private int moveCount;

    public Car(String name) {
        this.name = name;
        this.moveCount = 0;
    }

    public String getName() {
        return name;
    }

    public int getMoveCount() {
        return moveCount;
    }

    public void move() {
        int randomNumber = Randoms.pickNumberInRange(0, 9);
        if (randomNumber >= MOVE_CONDITION) {
            moveCount++;
        }
    }
}
