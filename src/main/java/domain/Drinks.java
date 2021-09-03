package domain;

import java.util.ArrayList;
import java.util.List;

public class Drinks {
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
}
