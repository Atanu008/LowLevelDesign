package org.factorymethod;

public class VegBurgerRestaurant extends Restaurant{
    @Override
    public Burger createBurger() {
        System.out.println("Creating Veg Burger...");
        return new VegBurger();
    }
}
