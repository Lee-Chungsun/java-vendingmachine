package application;

import domain.VendingMachine;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("자판기 기능 관련 테스트")
public class VendingMachineServiceTest {

    private VendingMachineService vendingMachineService;

    @BeforeEach
    void setUp() {
        vendingMachineService = new VendingMachineService();
    }

    @Test
    @DisplayName("자판기가 보유할 금액을 입력")
    void 자판기_보유_금액_입력() {
        VendingMachine vendingMachine = new VendingMachine();

        vendingMachineService.chargeHoldingAmount(vendingMachine, 450);

        assertThat(vendingMachine.isRemainingAmount(450)).isTrue();
    }
}
