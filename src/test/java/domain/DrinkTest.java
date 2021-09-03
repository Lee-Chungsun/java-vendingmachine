package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

@DisplayName("음료수 객체 생성 관련 테스트")
public class DrinkTest {

    @Test
    void 음료수_객체_생성_테스트() {
        Drink expectedDrink = new Drink("콜라", 20, 2000);

        assertThat(expectedDrink).isEqualTo(new Drink("콜라", 20, 2000));
    }

    @Test
    @DisplayName("상품의 최소 금액 100원 이하 예외 처리")
    void 음료수_가격이_100원_이하_예외() {
        assertThatThrownBy(() -> new Drink("콜라", 20, 50))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("상품의 최소 금액 10원단위 예외")
    void 음료수_가격단위가_10원_아닌_예외() {
        assertThatThrownBy(() -> new Drink("콜라", 20, 151))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
