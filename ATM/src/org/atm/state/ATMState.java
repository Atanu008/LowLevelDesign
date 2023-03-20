package org.atm.state;

import org.atm.model.Card;
import org.atm.model.TransactionType;

public abstract class ATMState {

    public void insertCard(Card card){
        System.out.println("OOPS!! Something went wrong");
    }

    public void authenticatePin(Card crad, int pin){
        System.out.println("OOPS!! Something went wrong");
    }

    public void selectOperation(Card card, TransactionType tracsactionType){
        System.out.println("OOPS!! Something went wrong");
    }

    public void cashWithdrawal(Card card, int withdrawAmount) {
        System.out.println("OOPS!! Something went wrong");
    }

    public void displayBalance(Card card){
        System.out.println("OOPS!! Something went wrong");
    }

    public void returnCard(){
        System.out.println("OOPS!! Something went wrong");
    }

    public void exit(){
        System.out.println("OOPS!! Something went wrong");
    }
}
