package application;

import domain.VendingMachine;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

@DisplayName("음료수 생성 기능 관련 테스트")
public class DrinkServiceTest {
    private DrinkService drinkService;

    @BeforeEach
    void setUp() {
        drinkService = new DrinkService();
    }

    @ParameterizedTest
    @CsvSource(value = {"[콜라,20,1500];[사이다,10,1000]:2", "[콜라,20,1500];[사이다,10,1000];[환타,10,1000]:3"}, delimiter = ':')
    @DisplayName("입력값을 받아 음료수 목록을 생성한다.")
    void 음료수_목록_생성(String inputDrinkInforms, int expectedSize) {
        VendingMachine vendingMachine = new VendingMachine();

        drinkService.createDrinks(vendingMachine, inputDrinkInforms);

        assertThat(vendingMachine.countDrinks()).isEqualTo(expectedSize);
    }

    @ParameterizedTest
    @CsvSource(value = {"[콜라,20];[사이다,10,1000]:2"}, delimiter = ':')
    @DisplayName("잘못 된 입력값을 받아 음료수 목록을 생성한다.")
    void 음료수_목록_생성_예외(String inputDrinkInforms, int expectedSize) {
        VendingMachine vendingMachine = new VendingMachine();

        assertThatThrownBy(() ->drinkService.createDrinks(vendingMachine, inputDrinkInforms))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @CsvSource(value = {"[콜라,20,1001];[사이다,10,1000]:2"}, delimiter = ':')
    @DisplayName("잘못 된 입력값을 받아 음료수 목록을 생성한다.")
    void 음료수_목록_가격_예외(String inputDrinkInforms, int expectedSize) {
        VendingMachine vendingMachine = new VendingMachine();

        assertThatThrownBy(() ->drinkService.createDrinks(vendingMachine, inputDrinkInforms))
                .isInstanceOf(IllegalArgumentException.class);
    }

}
