package org.atm.state;

import org.atm.ATM;
import org.atm.model.Card;

public class CheckBalanceState extends ATMState{

    ATM ATMInstance;

    public CheckBalanceState(ATM ATMInstance){
        this.ATMInstance = ATMInstance;
    }

    @Override
    public void displayBalance(Card card){
        System.out.println("Your Balance is: "+ card.getBalance());
        exit();
    }

    @Override
    public void exit(){
        returnCard();
        ATMInstance.setCurrentATMState(new IdleState(ATMInstance));
        System.out.println("Exit . \n Thank you Visit again.");
    }

    @Override
    public void returnCard(){
        System.out.println("Please collect your card");
    }
}
