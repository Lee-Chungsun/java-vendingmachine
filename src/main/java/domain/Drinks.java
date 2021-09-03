package domain;

import java.util.ArrayList;
import java.util.List;

public class Drinks {
    private static final String NOT_FOUNDED_DRINK_EXCEPTION = "존재하지 않는 상품입니다.";
    private List<Drink> drinks;

    public Drinks() {
        this.drinks = new ArrayList<>();
    }

    public Drinks(List<Drink> drinks) {
        this.drinks = drinks;
    }

    public void addDrink(Drink drink) {
        this.drinks.add(drink);
    }

    public int countDrinks() {
        return drinks.size();
    }

    public int orderDrink(int userPay, String orderDrink) {
        Drink drink = drinks.stream()
                .filter(it -> it.isExistDrink(orderDrink))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException(NOT_FOUNDED_DRINK_EXCEPTION));
        return drink.serveDrink(userPay);
    }

    public int countOfOrderDrink(String orderDrink) {
        return drinks.stream()
                .filter(drink -> drink.isExistDrink(orderDrink))
                .mapToInt(drink -> drink.countOfDrink())
                .max()
                .orElseThrow(() -> new IllegalArgumentException(NOT_FOUNDED_DRINK_EXCEPTION));
    }

    public boolean isExistDrink() {
        return drinks.stream()
                .anyMatch(drink -> drink.countOfDrink() != 0) && drinks.size() != 0;
    }

    public boolean isExistCheapDrinkThanPay(int pay) {
        return drinks.stream()
                .anyMatch(drink -> drink.isCheapDrinkThanPay(pay));
    }
}
