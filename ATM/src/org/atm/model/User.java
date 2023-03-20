package org.atm.model;

public class User {

    Card card;
    BankAccount userBankAccount;

    public Card getCard() {
        return card;
    }

    public void setCard(Card card) {
        this.card = card;
    }

    public BankAccount getUserBankAccount() {
        return userBankAccount;
    }

    public void setUserBankAccount(BankAccount userBankAccount) {
        this.userBankAccount = userBankAccount;
    }
}
