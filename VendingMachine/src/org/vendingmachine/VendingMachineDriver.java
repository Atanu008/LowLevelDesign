package org.vendingmachine;

import org.vendingmachine.app.VendingMachine;
import org.vendingmachine.inventory.Product;

public class VendingMachineDriver {
    public static void main(String[] args) {
        VendingMachine vendingMachine = new VendingMachine();

        Product hersheys = new Product("1", "Hersheys", 5.0);
        for(int i = 0; i < 3; i++){
            vendingMachine.addProduct(hersheys);
        }

        Product biskFarm = new Product("2", "BiskFarm", 2.0);
        for(int i = 0; i < 3; i++){
            vendingMachine.addProduct(biskFarm);
        }

        vendingMachine.insertCoin(5.0);
        vendingMachine.insertCoin(5.0);
        vendingMachine.pressButton(1);

        vendingMachine.insertCoin(5.0);
        vendingMachine.pressButton(1);

        vendingMachine.insertCoin(7.0);
        vendingMachine.pressButton(1); //last item consuming

        vendingMachine.insertCoin(7.0);
        vendingMachine.pressButton(2);

        vendingMachine.insertCoin(10.0);
        vendingMachine.pressButton(1); // Should throw an error , out of stock



    }
}
