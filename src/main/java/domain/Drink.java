package domain;

import java.util.Objects;

public class Drink {
    private static final String MINIMUM_DRINK_AMOUNT_EXCEPTION = "상품의 최소 금액은 %d원 이상입니다.";
    private static final int MINIMUM_DRINK_AMOUNT = 100;
    private static final String DRINK_AMOUNT_UNIT_EXCEPTION = "상품의 금액은 %d원 단위입니다.";
    private static final int DRINK_AMOUNT_UNIT = 10;

    private final String name;
    private final int count;
    private final int amount;

    public Drink(String name, int count, int amount) {
        validate(amount);
        this.name = name;
        this.count = count;
        this.amount = amount;
    }

    private void validate(int amount) {
        if (amount < MINIMUM_DRINK_AMOUNT) {
            throw new IllegalArgumentException(String.format(MINIMUM_DRINK_AMOUNT_EXCEPTION, MINIMUM_DRINK_AMOUNT));
        }

        if (amount % DRINK_AMOUNT_UNIT != 0) {
            throw new IllegalArgumentException(String.format(DRINK_AMOUNT_UNIT_EXCEPTION, DRINK_AMOUNT_UNIT));
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Drink drink = (Drink) o;
        return count == drink.count && amount == drink.amount && Objects.equals(name, drink.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, count, amount);
    }
}
