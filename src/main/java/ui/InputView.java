package ui;

import application.DrinkService;
import application.VendingMachineService;
import domain.VendingMachine;

import java.util.Scanner;

public class InputView {

    public static VendingMachine turnOnVendingMachine() {
        VendingMachine vendingMachine = new VendingMachine();
        VendingMachineService vendingMachineService = new VendingMachineService();

        try{
            System.out.println("자판기가 보유하고 있는 금액을 입력해 주세요.");
            Integer holdingAmount = new Scanner(System.in).nextInt();

            vendingMachineService.chargeHoldingAmount(vendingMachine, holdingAmount);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return vendingMachine;
    }

    public static void chargeDrinks(VendingMachine vendingMachine) {
        DrinkService drinkService = new DrinkService();

        try{
            System.out.println("상품명과 수량, 금액을 입력해 주세요.");
            String chargeDrinks = new Scanner(System.in).nextLine();

            drinkService.createDrinks(vendingMachine, chargeDrinks);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static int pushPay(VendingMachine vendingMachine) {
        VendingMachineService vendingMachineService = new VendingMachineService();
        Integer pay = null;

        try {
            Scanner scan = new Scanner(System.in);

            System.out.println("투입 금액을 입력해 주세요.");
            pay = scan.nextInt();
            scan.nextLine();

            while (vendingMachineService.isCanBuyDrink(vendingMachine, pay)) {
                OutputView.noticeRemainingPay(pay);
                System.out.println("구매하실 상품명을 입력해주세요.");
                String orderDrink = scan.nextLine();

                pay = vendingMachine.orderDrink(pay, orderDrink);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return pay;
    }
}
