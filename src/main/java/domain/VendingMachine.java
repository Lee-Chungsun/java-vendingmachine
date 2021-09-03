package domain;

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

    public int orderDrink(int userPay, String orderDrink) {
        return drinks.orderDrink(userPay, orderDrink);
    }

    public int getDrinkCount(String orderDrink) {
        return drinks.countOfOrderDrink(orderDrink);
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
