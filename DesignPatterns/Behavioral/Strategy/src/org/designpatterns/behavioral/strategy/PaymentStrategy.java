package org.designpatterns.behavioral.strategy;

public interface PaymentStrategy {

    public boolean validate();
    public void pay(int amount);
}
