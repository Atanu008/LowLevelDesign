package org.atm.state;

import org.atm.ATM;
import org.atm.model.Card;

public class HasCardState extends ATMState{

    ATM ATMInstance;

    public HasCardState(ATM ATMInstance) {
        this.ATMInstance = ATMInstance;
    }

    @Override
    public void authenticatePin(Card card, int pin){
        System.out.println("Authenticating Ping...");
        boolean isCorrectPinEntered = card.validatePin(pin);
        if(isCorrectPinEntered){
            System.out.println("Card is authenticated");
            ATMInstance.setCurrentATMState(new SelectOperationState(ATMInstance));
        }
        else{
            System.out.println("Invalid PIN Number");
            exit();
        }
    }

    @Override
    public void exit(){
        returnCard();
        ATMInstance.setCurrentATMState(new IdleState(ATMInstance));
        System.out.println("Exit . \n Thank you Visit again.");
    }

    public void returnCard(){
        System.out.println("Please collect your card");
    }
}
