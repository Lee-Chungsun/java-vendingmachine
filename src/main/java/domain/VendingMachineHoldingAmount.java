package domain;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;

public class VendingMachineHoldingAmount {
    public static final int MINIMUM_COIN_COUNT = 0;
    private Map<Coins, Integer> coins;

    public VendingMachineHoldingAmount() {
        this.coins = new LinkedHashMap<>();
        Arrays.stream(Coins.values()).forEach(
                coin -> this.coins.put(coin, Integer.valueOf(MINIMUM_COIN_COUNT))
        );
    }

    public int countKindsOfCoin() {
        return this.coins.size();
    }

    /**
     * {@code Coins} 해당 코인의 갯수를 반환한다.
     *
     * @param expectedCoin 갯수를 조회하는 코인
     * @return 해당 코인의 갯수
     */
    public int countThisCoin(Coins expectedCoin) {
        return this.coins.get(expectedCoin);
    }

    /**
     * {@code Coins} 코인을 충전한다.
     *
     * @param coin            충전할 코인
     * @param chargeCoinCount 충전할 코인 갯수
     */
    public void chargeCoin(Coins coin, int chargeCoinCount) {
        this.coins.put(coin, Integer.sum(this.coins.get(coin), chargeCoinCount));
    }

    public boolean isRemainingAmount(int expectedAmount) {
        Integer sum = 0;
        for (Coins coin : this.coins.keySet()) {
            sum = Integer.sum(sum, coin.calculateAmount(this.coins.get(coin)));
        }
        return sum == expectedAmount;
    }

    public Map<String, Integer> returnChange(int pay) {
        Map<String, Integer> returnChange = new LinkedHashMap<>();
        for (Coins coin : this.coins.keySet()) {
            int countOfCoin = Integer.min(coin.calculateMaxCountOfCoin(pay), this.coins.get(coin));
            returnChange.put(coin.name, Integer.min(countOfCoin, this.coins.get(coin)));
            pay = pay - coin.calculateAmount(countOfCoin);
        }
        return returnChange;
    }
}
