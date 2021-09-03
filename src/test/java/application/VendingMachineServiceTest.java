package application;

import domain.VendingMachine;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

@DisplayName("자판기 기능 관련 테스트")
public class VendingMachineServiceTest {

    private VendingMachineService vendingMachineService;
    private DrinkService drinkService;

    @BeforeEach
    void setUp() {
        vendingMachineService = new VendingMachineService();
        drinkService = new DrinkService();
    }

    @Test
    @DisplayName("자판기가 보유할 금액을 입력")
    void 자판기_보유_금액_입력() {
        VendingMachine vendingMachine = new VendingMachine();

        vendingMachineService.chargeHoldingAmount(vendingMachine, 450);

        assertThat(vendingMachine.isRemainingAmount(450)).isTrue();
    }

    @Test
    @DisplayName("음료를 주문한다.")
    void 자판기_음료_주문() {
        VendingMachine vendingMachine = new VendingMachine();
        drinkService.createDrinks(vendingMachine, "[콜라,20,1500];[사이다,10,1000]");

        assertThat(vendingMachine.getDrinkCount("콜라")).isEqualTo(20);
        vendingMachine.orderDrink(3000, "콜라");
        assertThat(vendingMachine.getDrinkCount("콜라")).isEqualTo(19);
    }

    @Test
    @DisplayName("비싼 음료를 주문한다.")
    void 자판기_투입금액_보다_비싼_음료_주문_예외() {
        VendingMachine vendingMachine = new VendingMachine();
        drinkService.createDrinks(vendingMachine, "[콜라,20,1500];[사이다,10,1000]");

        assertThatThrownBy(() -> vendingMachine.orderDrink(1000, "콜라"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("없는 음료를 주문한다.")
    void 자판기_없는_음료_주문_예외() {
        VendingMachine vendingMachine = new VendingMachine();
        drinkService.createDrinks(vendingMachine, "[콜라,20,1500];[사이다,10,1000]");

        assertThatThrownBy(() -> vendingMachine.orderDrink(1000, "환타"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("남은 금액 테스트")
    void 자판기_남은_금액() {
        VendingMachine vendingMachine = new VendingMachine();
        drinkService.createDrinks(vendingMachine, "[콜라,20,1500];[사이다,10,1000]");

        int remainingPay = vendingMachine.orderDrink(3000, "콜라");
        assertThat(remainingPay).isEqualTo(1500);

    }
}
