package org.decorator.coffee;

public class CoffeeApp {
    public static void main(String[] args) {
        Beverage beverage = new Whip(new Mocha(new Mocha(new DarkRoast())));
        String desc = beverage.getDescription();
        double cost = beverage.cost();
        System.out.println(desc + ": Costs :"+ cost);
    }
}
