package org.designpatterns.behavioral.strategy;

import java.util.Date;

public class CreditCardStrategy implements PaymentStrategy{

    String cardHolderName;
    long cardNumber;
    int cvv;
    Date expiryDate;

    public CreditCardStrategy( String cardHolderName, long cardNumber, int cvv, Date expiryDate){
        this.cardHolderName = cardHolderName;
        this.cardNumber = cardNumber;
        this.cvv = cvv;
        this.expiryDate = expiryDate;
    }
    @Override
    public boolean validate() {
        System.out.println("Credit Card Account Validated");
        return true; // Validation logic
    }

    @Override
    public void pay(int amount) {
        validate();
        System.out.println(amount + " paid using Credit Card.");
    }
}
