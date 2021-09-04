package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("자판기 보유 금액 관련 기능 테스트")
public class VendingMachineHoldingAmountTest {

    @Test
    void 자판기_보유_금액_생성() {
        VendingMachineHoldingAmount vendingMachineHoldingAmount = new VendingMachineHoldingAmount();

        assertThat(vendingMachineHoldingAmount.countKindsOfCoin()).isEqualTo(4);
    }

    @Test
    void 자판기_보유_코인_갯수_조회() {
        VendingMachineHoldingAmount vendingMachineHoldingAmount = new VendingMachineHoldingAmount();

        assertThat(vendingMachineHoldingAmount.countThisCoin(Coins.FIVE_HUNDRED_COIN)).isZero();
    }

    @Test
    void 자판기_보유_코인_증가() {
        VendingMachineHoldingAmount vendingMachineHoldingAmount = new VendingMachineHoldingAmount();

        vendingMachineHoldingAmount.chargeCoin(Coins.FIVE_HUNDRED_COIN, 5);

        assertThat(vendingMachineHoldingAmount.countThisCoin(Coins.FIVE_HUNDRED_COIN)).isEqualTo(5);
    }

    @Test
    void 잔돈_기능_테스트() {
        VendingMachineHoldingAmount vendingMachineHoldingAmount = new VendingMachineHoldingAmount();

        vendingMachineHoldingAmount.chargeCoin(Coins.FIVE_HUNDRED_COIN, 5);
        vendingMachineHoldingAmount.chargeCoin(Coins.ONE_HUNDRED_COIN, 5);

        Map<String, Integer> expected = vendingMachineHoldingAmount.returnChange(550);

        assertThat(expected.get("500원")).isEqualTo(1);
        assertThat(expected.get("100원")).isEqualTo(0);
    }

    @Test
    void 남은_보유_금액_만큼_잔돈_기능_테스트() {
        VendingMachineHoldingAmount vendingMachineHoldingAmount = new VendingMachineHoldingAmount();

        vendingMachineHoldingAmount.chargeCoin(Coins.FIVE_HUNDRED_COIN, 0);
        vendingMachineHoldingAmount.chargeCoin(Coins.ONE_HUNDRED_COIN, 5);
        vendingMachineHoldingAmount.chargeCoin(Coins.ONE_TEN_COIN, 5);

        Map<String, Integer> expected = vendingMachineHoldingAmount.returnChange(450);

        assertThat(expected.get("100원")).isEqualTo(4);
        assertThat(expected.get("10원")).isEqualTo(5);
    }
}
