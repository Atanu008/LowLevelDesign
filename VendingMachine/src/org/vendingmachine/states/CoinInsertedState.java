package org.vendingmachine.states;

import org.vendingmachine.app.VendingMachine;
import org.vendingmachine.inventory.Inventory;
import org.vendingmachine.inventory.Product;

public class CoinInsertedState implements State{

    VendingMachine vendingMachine;

    public CoinInsertedState(VendingMachine vendingMachine) {
        this.vendingMachine = vendingMachine;
    }

    @Override
    public void insertCoin(double amount) {
        vendingMachine.setAmount(vendingMachine.getAmount() + amount);
    }

    @Override
    public void pressButton(int aisleNumber) {

        Inventory inventory = vendingMachine.getInventory();
        Product product = inventory.getProductAt(aisleNumber);

        if(product != null && !vendingMachine.hasSufficientAmount(product.getPrice())){
            throw new IllegalStateException("Insufficient amount");
        }
        if(product == null){
            throw new IllegalStateException("Product is out of stock");
        }

        vendingMachine.setCurrentVendingMachineState(vendingMachine.getDispenseState());
    }

    @Override
    public void dispense(int aisleNumber) {
        throw new IllegalStateException("Not my responsibolity");
    }
}
