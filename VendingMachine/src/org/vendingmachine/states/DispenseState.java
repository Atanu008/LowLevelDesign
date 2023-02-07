package org.vendingmachine.states;

import org.vendingmachine.app.VendingMachine;
import org.vendingmachine.inventory.Inventory;
import org.vendingmachine.inventory.Product;

public class DispenseState implements State{

    VendingMachine vendingMachine;

    public DispenseState(VendingMachine vendingMachine) {
        this.vendingMachine = vendingMachine;
    }

    @Override
    public void insertCoin(double amount) {
        throw new IllegalStateException("No Coin Inserted");
    }

    @Override
    public void pressButton(int aisleNumber) {
        throw new IllegalStateException("No Coin Inserted");
    }

    @Override
    public void dispense(int aisleNumber) {
        Inventory inventory = vendingMachine.getInventory();
        Product product = inventory.getProductAt(aisleNumber);
        inventory.deductProductCount(aisleNumber);
        double change = vendingMachine.getAmount() - product.getPrice();

        vendingMachine.setAmount(0);
        vendingMachine.setCurrentVendingMachineState(vendingMachine.getNoCoinInsertedState());

        System.out.println("Product with id "+product.getProductId() + " is being dispensed and your return is Rs "+ change);
    }
}
