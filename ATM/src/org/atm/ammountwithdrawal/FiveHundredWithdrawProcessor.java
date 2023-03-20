package org.atm.ammountwithdrawal;

import org.atm.ATM;

public class FiveHundredWithdrawProcessor extends CashWithdrawProcessor{

    public FiveHundredWithdrawProcessor(CashWithdrawProcessor nextCashWithdrawProcessor) {
        super(nextCashWithdrawProcessor);
    }

    @Override
    public void withdraw(ATM ATMInstance, int remainingAmount){
        int requiredNotes = remainingAmount / 500;
        int balance = remainingAmount % 500;

        if(requiredNotes <= ATMInstance.getNoOfFiveHundredNotes()){
            ATMInstance.deductFiveHundredNotes(requiredNotes);
        }
        else if(requiredNotes > ATMInstance.getNoOfFiveHundredNotes()){
            // if required number of 500 Rs notes are more than notes available in ATM
            // we add again the balance in ATM. Once it is done, we deduct
            // the number of 500 Rs notes from ATM
            balance = balance + (requiredNotes - ATMInstance.getNoOfFiveHundredNotes()) * 500;
            //Give all the 500 notes available
            ATMInstance.deductFiveHundredNotes(ATMInstance.getNoOfFiveHundredNotes()); // Make 500 note count zero
        }

        if(balance != 0){
            nextCashWithdrawProcessor.withdraw(ATMInstance, balance);
        }
    }
}
