package racingcar;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import racingcar.exception.ExceptionMessage;
import racingcar.model.NameExtractor;

public class NameExtractorTest {
    @DisplayName("extractName은 쉼표를 기준으로 이름을 추출하고 이름 리스트를 반환한다")
    @Test
    void extractName() {
        // given
        String input = "car1,car2,car3";
        // when
        List<String> result = NameExtractor.extractName(input);

        // then
        assertThat(result).isEqualTo(List.of("car1", "car2", "car3"));
    }

    @Nested
    @DisplayName("extractName 예외 : ")
    class Failure {
        @DisplayName("쉼표가 마지막에 온 경우")
        @Test
        void endsWithDelimiter() {
            // given
            String input = "car1,car2,car3,";

            // when, then
            assertThatThrownBy(() -> NameExtractor.extractName(input))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessageContaining(ExceptionMessage.DELIMITER_CANNOT_END_WITH.getValue());
        }

        @DisplayName("이름이 비어있는 경우")
        @Test
        void emptyName() {
            // given
            String input = "car1,,car3";

            // when, then
            assertThatThrownBy(() -> NameExtractor.extractName(input))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessageContaining(ExceptionMessage.NAME_CANNOT_BE_BLANK.getValue());
        }

        @DisplayName("이름이 비어있는 경우")
        @Test
        void blankName() {
            // given
            String input = "car1, ,car3";

            // when, then
            assertThatThrownBy(() -> NameExtractor.extractName(input))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessageContaining(ExceptionMessage.NAME_CANNOT_BE_BLANK.getValue());
        }

        @DisplayName("이름이 5자를 초과하는 경우")
        @Test
        void exceedsMaxLength() {
            // given
            String input = "car1,longCar2,car3";

            // when, then
            assertThatThrownBy(() -> NameExtractor.extractName(input))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessageContaining(ExceptionMessage.NAME_LENGTH_EXCEEDED.getValue());
        }
    }
}
