package application;

import domain.Coins;
import domain.VendingMachine;

import java.util.Map;

public class VendingMachineService {
    public void chargeHoldingAmount(VendingMachine vendingMachine, int chargeHoldingAmount) {
        if (chargeHoldingAmount % 10 != 0) {
            throw new IllegalArgumentException("금액은 10원 단위로 입력이 가능합니다.");
        }
        while (chargeHoldingAmount != 0) {
            chargeHoldingAmount = afterChargeRemainingAmount(vendingMachine, chargeHoldingAmount);
        }
    }

    private int afterChargeRemainingAmount(VendingMachine vendingMachine, int chargeHoldingAmount) {
        for (Coins coin : Coins.values()) {
            int coinCount = CreateRandomCoinCountUtils.createRandomCoinCount(chargeHoldingAmount, coin);
            vendingMachine.chargeCoin(coin, coinCount);
            chargeHoldingAmount = coin.calculateRemainingAmount(chargeHoldingAmount, coinCount);
        }
        return chargeHoldingAmount;
    }

    public boolean isCanBuyDrink(VendingMachine vendingMachine, int pay) {
        if (!vendingMachine.isExistDrink()) {
            return false;
        }
        if (!vendingMachine.isExistCheapDrinkThanPay(pay)) {
            return false;
        }
        return true;
    }

    public Map<String, Integer> returnChange(VendingMachine vendingMachine, int pay) {
        return vendingMachine.returnChange(pay);
    }
}
