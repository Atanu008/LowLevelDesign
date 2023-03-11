package org.factorymethod;

public class VegBurger extends Burger{
    @Override
    public void prepare() {
        // Prepare Veg Burger
        System.out.println("Preparing Veg Burger...");
    }
}
