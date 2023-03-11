package org.factory.burger;

//This is simple Factory. NOT the actual Gang Of Four Pattern
//Now if we have to introduce new Burger Type then we need to modify the burger creation code
//This would violate the open close principle i.e open for extension and closed for modification
//This problem will be solved(not entirely : we need to know which type Factory to use) by Factory Method.

public class BurgerFactory {

    public static Burger createBurger(String burgerType){
        Burger burger = null;
        if("Chicken".equals(burgerType)){
            burger =  new ChickenBurger();
        }
        else if("Veg".equals(burgerType)){
            burger =  new VegBurger();
        }
        return burger;
    }
}
