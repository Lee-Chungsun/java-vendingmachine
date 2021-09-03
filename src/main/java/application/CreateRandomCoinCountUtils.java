package application;

import com.woowahan.techcourse.utils.Randoms;
import domain.Coins;

public class CreateRandomCoinCountUtils {

    private CreateRandomCoinCountUtils() {
    }

    public static int createRandomCoinCount(int chargeHoldingAmount, Coins coin) {
        int createMaxCountOfCoin = coin.calculateMaxCountOfCoin(chargeHoldingAmount);
        return Randoms.pick(0, createMaxCountOfCoin);
    }
}
