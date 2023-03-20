package org.atm.state;

import org.atm.ATM;
import org.atm.model.Card;
import org.atm.model.TransactionType;

public class SelectOperationState extends ATMState{

    ATM ATMInstance;

    public SelectOperationState(ATM ATMInstance) {
        this.ATMInstance = ATMInstance;
    }

    @Override
    public void selectOperation(Card card, TransactionType transactionType){

        switch (transactionType){
            case BALANCE_CHECK :
                ATMInstance.setCurrentATMState(new CheckBalanceState(ATMInstance));
                break;
            case CASH_WITHDRAWAL:
                ATMInstance.setCurrentATMState(new CashWithdrawalState(ATMInstance));
                break;
            default:
                System.out.println("Invalid Option");
                exit();
        }
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
