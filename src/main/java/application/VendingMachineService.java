package application;

import domain.VendingMachine;

public class VendingMachineService {
    public void chargeHoldingAmount(VendingMachine vendingMachine, int holdingAmount) {
        vendingMachine.chargeHoldingAmount(holdingAmount);
    }
}
