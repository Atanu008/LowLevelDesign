package org.atm.state;

import org.atm.ATM;
import org.atm.model.Card;

public class IdleState extends ATMState {

    ATM ATMInstance;

    public IdleState(ATM atm) {
        this.ATMInstance = atm;
    }

    public void setATMInstance(ATM ATMInstance) {
        this.ATMInstance = ATMInstance;
    }

    @Override
    public void insertCard(Card card){
        System.out.println("Card is inserted");
        ATMInstance.setCurrentATMState(new HasCardState(ATMInstance));
    }
}
