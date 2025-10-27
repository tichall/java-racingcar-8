package racingcar;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import racingcar.model.Car;

public class CarTest {
    @DisplayName("Car 객체 생성 및 초기 상태 테스트")
    @Test
    void createCarAndInitialState() {
        // given
        String carName = "testCar";

        // when
        Car car = new Car(carName);

        // then
        assertAll(
                () -> assertThat(car.getName()).isEqualTo(carName),
                () -> assertThat(car.getMoveCount()).isEqualTo(0)
        );
    }

    @Nested
    @DisplayName("move는 랜덤 숫자값이 전진 조건값보다 큰 경우, 자동차의 전진횟수를 증가시킨다")
    class Move {
        @DisplayName("전진하는 경우")
        @Test
        void moveForward() {
            // given
            Car car = new Car("carName");

            // when, then
            assertRandomNumberInRangeTest(
                    () -> {
                        car.move();
                        assertThat(car.getMoveCount()).isEqualTo(1);
                    },
                    Car.MOVE_CONDITION + 1
            );
        }

        @DisplayName("전진하지 않는 경우")
        @Test
        void stop() {
            // given
            Car car = new Car("carName");

            // when, then
            assertRandomNumberInRangeTest(
                    () -> {
                        car.move();
                        assertThat(car.getMoveCount()).isEqualTo(0);
                    },
                    Car.MOVE_CONDITION - 1
            );
        }
    }
}
