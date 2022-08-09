package org.designpatterns.behavioral.strategy;

public class PayPalStrategy implements PaymentStrategy{

    String userName;
    String password;

    public PayPalStrategy(String userName, String password){
        this.userName = userName;
        this.password = password;
    }
    @Override
    public boolean validate() {
        System.out.println("Paypal Account Validated");
        return true; // Validation logic
    }

    @Override
    public void pay(int amount) {
        validate();
        System.out.println(amount + " paid using Paypal.");
    }
}
