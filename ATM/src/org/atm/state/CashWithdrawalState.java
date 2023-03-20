package org.atm.state;

import org.atm.ATM;
import org.atm.ammountwithdrawal.CashWithdrawProcessor;
import org.atm.ammountwithdrawal.FiveHundredWithdrawProcessor;
import org.atm.ammountwithdrawal.OneHundredWithdrawProcessor;
import org.atm.ammountwithdrawal.TwoThousandWithdrawProcessor;
import org.atm.model.Card;

public class CashWithdrawalState extends ATMState{

    ATM ATMInstance;

    public CashWithdrawalState(ATM ATMInstance) {
        this.ATMInstance = ATMInstance;
    }

    public void cashWithdrawal(Card card, int withdrawalAmount){
        if(ATMInstance.getAtmBalance() < withdrawalAmount){
            System.out.println("Insufficient fund in the ATM Machine");
            exit();
        }
        else if(card.getBalance() < withdrawalAmount){
            System.out.println("Insufficient fund in the your Bank Account");
            exit();
        }
        else{
            card.deductBalance(withdrawalAmount); // Deduct from Account
            ATMInstance.deductATMBalance(withdrawalAmount); // Deduct from ATM

            CashWithdrawProcessor withdrawProcessor =
                    new TwoThousandWithdrawProcessor(new FiveHundredWithdrawProcessor(new OneHundredWithdrawProcessor(null)));
            withdrawProcessor.withdraw(ATMInstance, withdrawalAmount);
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
