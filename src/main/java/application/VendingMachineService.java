package application;

import domain.Coins;
import domain.VendingMachine;

public class VendingMachineService {
    public void chargeHoldingAmount(VendingMachine vendingMachine, int chargeHoldingAmount) {
        while (chargeHoldingAmount != 0){
            chargeHoldingAmount = afterChargeRemainingAmount(vendingMachine, chargeHoldingAmount);
        }
    }

    private int afterChargeRemainingAmount(VendingMachine vendingMachine, int chargeHoldingAmount) {
        for(Coins coin : Coins.values()){
            int coinCount = CreateRandomCoinCountUtils.createRandomCoinCount(chargeHoldingAmount, coin);
            vendingMachine.chargeCoin(coin, coinCount);
            chargeHoldingAmount = coin.calculateRemainingAmount(chargeHoldingAmount, coinCount);
        }
        return chargeHoldingAmount;
    }
}
