package org.decorator.coffee;

//This is Decorator
public abstract class CondimentDecorator extends Beverage {
    Beverage beverage;
    public abstract String getDescription();
}

