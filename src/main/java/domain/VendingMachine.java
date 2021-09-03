package domain;

public class VendingMachine {
    private VendingMachineHoldingAmount vendingMachineHoldingAmount;

    public VendingMachine() {
        this.vendingMachineHoldingAmount = new VendingMachineHoldingAmount();
    }

    public void chargeCoin (Coins coin, int chargeCoinCount) {
        this.vendingMachineHoldingAmount.chargeCoin(coin, chargeCoinCount);
    }

    public boolean isRemainingAmount(int expectedAmount) {
        return this.vendingMachineHoldingAmount.isRemainingAmount(expectedAmount);
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
