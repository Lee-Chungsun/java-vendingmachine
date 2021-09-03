package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("자판기 보유 금액 관련 기능 테스트")
public class VendingMachineHoldingAmountTest {

    @Test
    void 자판기_보유_금액_생성() {
        VendingMachineHoldingAmount vendingMachineHoldingAmount = new VendingMachineHoldingAmount();

        assertThat(vendingMachineHoldingAmount.countKindsOfCoin()).isEqualTo(3);
    }

    @Test
    void 자판기_보유_코인_갯수_조회() {
        VendingMachineHoldingAmount vendingMachineHoldingAmount = new VendingMachineHoldingAmount();

        assertThat(vendingMachineHoldingAmount.countThisCoin(Coins.FIVE_HUNDRED_COIN)).isZero();
    }

    @Test
    void 자판기_보유_코인_증가() {
        VendingMachineHoldingAmount vendingMachineHoldingAmount = new VendingMachineHoldingAmount();

        vendingMachineHoldingAmount.chargeHoldingAmount(Coins.FIVE_HUNDRED_COIN, 5);

        assertThat(vendingMachineHoldingAmount.countThisCoin(Coins.FIVE_HUNDRED_COIN)).isEqualTo(5);
    }
}
