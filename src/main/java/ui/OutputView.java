package ui;

import application.VendingMachineService;
import domain.VendingMachine;

import java.util.Map;

public class OutputView {
    public static void noticeRemainingPay(Integer pay) {
        System.out.println("남은 금액: " + pay + "원");
    }

    public static void returnCharge(VendingMachine vendingMachine, int pay) {
        noticeRemainingPay(pay);
        VendingMachineService vendingMachineService = new VendingMachineService();

        System.out.println("잔돈");
        Map<String, Integer> returnCharges =
                vendingMachineService.returnChange(vendingMachine, pay);

        for (String coin : returnCharges.keySet()) {
            System.out.println(coin + " - " + returnCharges.get(coin) + "개");
        }
    }
}
