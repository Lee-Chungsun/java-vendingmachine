package domain;

import java.util.ArrayList;
import java.util.List;

public class VendingMachine {
    private VendingMachineHoldingAmount vendingMachineHoldingAmount;
    private List<Drink> drinks;

    public VendingMachine() {
        this.vendingMachineHoldingAmount = new VendingMachineHoldingAmount();
        this.drinks = new ArrayList<>();
    }

    public void chargeCoin (Coins coin, int chargeCoinCount) {
        this.vendingMachineHoldingAmount.chargeCoin(coin, chargeCoinCount);
    }

    public boolean isRemainingAmount(int expectedAmount) {
        return this.vendingMachineHoldingAmount.isRemainingAmount(expectedAmount);
    }

    public void addDrink(Drink drink) {
        drinks.add(drink);
    }

    public int countDrinks() {
        return drinks.size();
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
