package org.atm.model;

public class BankAccount {
    String accountNumber;
    int balance;

    public BankAccount(String accountNumber, int balance) {
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    public void withdraw(int amount){
        System.out.println("Withdrawing : updating bank account ");
        balance = balance - amount;
    }

    public int getBalance(){
        return balance;
    }

    public String getAccountNumber(){
        return accountNumber;
    }

}
