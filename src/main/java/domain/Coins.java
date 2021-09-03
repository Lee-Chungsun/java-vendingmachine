package domain;

public enum Coins {
    FIVE_HUNDRED_COIN(500),
    ONE_HUNDRED_COIN(100),
    ONE_TEN_COIN(10);

    Integer amount;

    Coins(Integer amount){
        this.amount = amount;
    }
}
