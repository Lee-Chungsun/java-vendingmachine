package domain;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class VendingMachineHoldingAmount {
    private Map<Coins, Integer> coins;

    public VendingMachineHoldingAmount() {
        coins = new HashMap<>();
        Arrays.stream(Coins.values()).forEach(
                coin -> coins.put(coin, Integer.valueOf(0))
        );
    }

    public int countKindsOfCoin() {
        return this.coins.size();
    }

    /**
     * {@code Coins} 해당 코인의 갯수를 반환한다.
     * @param expectedCoin 갯수를 조회하는 코인
     * @return 해당 코인의 갯수
     */
    public int countThisCoin(Coins expectedCoin) {
        return this.coins.get(expectedCoin);
    }

    /**
     * {@code Coins} 코인을 충전한다.
     * @param coin 충전할 코인
     * @param chargeAmount 충전할 코인 갯수
     */
    public void chargeHoldingAmount(Coins coin, int chargeCoinCount) {
        this.coins.put(coin, Integer.sum(this.coins.get(coin), chargeCoinCount));
    }
}
