package domain;

public enum Coins {
    FIVE_HUNDRED_COIN(500, "500원"),
    ONE_HUNDRED_COIN(100, "100원"),
    FIVE_TEN_COIN(50, "50원"),
    ONE_TEN_COIN(10, "10원");

    Integer amount;
    String name;

    Coins(Integer amount, String name){
        this.amount = amount;
        this.name = name;
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
