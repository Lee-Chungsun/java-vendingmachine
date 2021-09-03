package domain;

public enum Coins {
    FIVE_HUNDRED_COIN(500),
    ONE_HUNDRED_COIN(100),
    ONE_TEN_COIN(10);

    Integer amount;

    Coins(Integer amount){
        this.amount = amount;
    }

    public int calculateRemainingAmount(int holdingAmount, int coinCount) {
        return holdingAmount - this.amount * coinCount;
    }

    public int calculateMaxCountOfCoin(int chargeHoldingAmount) {
        return chargeHoldingAmount / amount;
    }

    public int calculateAmount(Integer countOfCoin) {
        return countOfCoin * amount;
    }
}
