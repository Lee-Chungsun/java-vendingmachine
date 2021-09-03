package domain;

public class VendingMachine {
    private static final int MINIMUM_HOLDING_AMOUNT = 0;
    private int holdingAmount;

    public VendingMachine() {
        this.holdingAmount = MINIMUM_HOLDING_AMOUNT;
    }

    public void chargeHoldingAmount(int holdingAmount) {
        this.holdingAmount = holdingAmount;
    }

    public boolean isRemainingAmount(int expectedAmount) {
        return this.holdingAmount == expectedAmount;
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
