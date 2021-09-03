package ui;

import application.DrinkService;
import application.VendingMachineService;
import com.woowahan.techcourse.utils.Scanners;
import domain.VendingMachine;

import java.util.Scanner;

public class InputView {

    private static Scanner s = new Scanner(System.in);

    public static VendingMachine turnOnVendingMachine() {
        VendingMachine vendingMachine = new VendingMachine();
        VendingMachineService vendingMachineService = new VendingMachineService();

        System.out.println("자판기가 보유하고 있는 금액을 입력해 주세요.");
        Integer holdingAmount = s.nextInt();

        vendingMachineService.chargeHoldingAmount(vendingMachine, holdingAmount);
        return vendingMachine;
    }

    public static void chargeDrinks(VendingMachine vendingMachine) {
        DrinkService drinkService = new DrinkService();

        System.out.println("상품명과 수량, 금액을 입력해 주세요.");
        String chargeDrinks = Scanners.nextLine();

        drinkService.createDrinks(vendingMachine, chargeDrinks);
    }

    public static int pushPay(VendingMachine vendingMachine) {
        VendingMachineService vendingMachineService = new VendingMachineService();

        System.out.println("투입 금액을 입력해 주세요.");
        Integer pay = s.nextInt();

        while (vendingMachineService.isCanBuyDrink(vendingMachine, pay)) {
            OutputView.noticeRemainingPay(pay);
            System.out.println("구매하실 상품명을 입력해주세요.");
            String orderDrink = Scanners.nextLine();

            pay = vendingMachine.orderDrink(pay, orderDrink);
        }

        return pay;
    }
}
