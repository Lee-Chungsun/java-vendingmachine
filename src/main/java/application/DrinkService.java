package application;

import domain.Drink;
import domain.VendingMachine;

public class DrinkService {
    private static final int DRINK_NAME_ORDER = 0;
    private static final int DRINK_COUNT_ORDER = 1;
    private static final int DRINK_AMOUNT_ORDER = 2;
    private static final String DRINK_LIST_CSV = ";";
    private static final String DRINK_INFORM_CSV = ",";

    public void createDrinks(VendingMachine vendingMachine, String inputDrinkInforms) {
        String[] drinkInforms = inputDrinkInforms.split(DRINK_LIST_CSV);
        for (String drinkInform : drinkInforms) {
            String[] drink = getDrinkInform(drinkInform);
            vendingMachine.addDrink(new Drink(drink[DRINK_NAME_ORDER], Integer.parseInt(drink[DRINK_COUNT_ORDER]), Integer.parseInt(drink[DRINK_AMOUNT_ORDER])));
        }
    }

    private String[] getDrinkInform(String drinkInform) {
        String[] returnDrinkInform = drinkInform.replace("[", "")
                .replace("]", "")
                .split(DRINK_INFORM_CSV);
        if (returnDrinkInform.length != 3) {
            throw new IllegalArgumentException("상품의 정보를 정확히 입력해 주세요.");
        }
        return returnDrinkInform;
    }
}
