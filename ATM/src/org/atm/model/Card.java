package org.atm.model;

import java.util.Date;

public class Card {
    private final int cardNumber;
    private final int cvv;
    private final Date expiryDate;
    private final String holerName;
    private final int PIN_NIMBER;
    private final BankAccount bankAccount;

    public Card(int cardNumber, int cvv, Date expiryDate, String holerName, int pin_nimber, BankAccount bankAccount) {
        this.cardNumber = cardNumber;
        this.cvv = cvv;
        this.expiryDate = expiryDate;
        this.holerName = holerName;
        PIN_NIMBER = pin_nimber;
        this.bankAccount = bankAccount;
    }

    public boolean validatePin(int pin){
        return PIN_NIMBER == pin;
    }

    public int getBalance(){
        return bankAccount.getBalance();
    }

    public void deductBalance(int amount){
        bankAccount.withdraw(amount);
    }
}
