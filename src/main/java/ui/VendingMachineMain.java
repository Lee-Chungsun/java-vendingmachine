package ui;

import domain.VendingMachine;

public class VendingMachineMain {

    public static void main(String[] arg) {
        /**
         * 자판기를 생성하고 보유 금액과 음료 리스트를 생성한다.
         */
        VendingMachine vendingMachine = InputView.turnOnVendingMachine();
        InputView.chargeDrinks(vendingMachine);

        /**
         * 돈을 지불한다.
         */
        int pay = InputView.pushPay(vendingMachine);

        /**
         * 잔돈을 받는다.
         */
        OutputView.returnCharge(vendingMachine, pay);
    }
}
