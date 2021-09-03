package domain;

import java.util.ArrayList;
import java.util.List;

public class VendingMachine {
    private VendingMachineHoldingAmount vendingMachineHoldingAmount;
    private Drinks drinks;

    public VendingMachine() {
        this.vendingMachineHoldingAmount = new VendingMachineHoldingAmount();
        this.drinks = new Drinks();
    }

    public void chargeCoin (Coins coin, int chargeCoinCount) {
        this.vendingMachineHoldingAmount.chargeCoin(coin, chargeCoinCount);
    }

    public boolean isRemainingAmount(int expectedAmount) {
        return this.vendingMachineHoldingAmount.isRemainingAmount(expectedAmount);
    }

    public void addDrink(Drink drink) {
        drinks.addDrink(drink);
    }

    public int countDrinks() {
        return drinks.countDrinks();
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }
}
