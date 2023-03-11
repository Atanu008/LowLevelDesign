package org.factorymethod;

public class ChickenBurger extends Burger{
    @Override
    public void prepare() {
        // Prepare Chicken Burger
        System.out.println("Preparing Chicken Burger...");
    }
}
