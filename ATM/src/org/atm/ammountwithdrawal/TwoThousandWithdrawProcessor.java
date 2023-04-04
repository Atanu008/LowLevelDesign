package org.atm.ammountwithdrawal;

import org.atm.ATM;

public class TwoThousandWithdrawProcessor extends CashWithdrawProcessor{


    public TwoThousandWithdrawProcessor(CashWithdrawProcessor nextCashWithdrawProcessor) {
        super(nextCashWithdrawProcessor);
    }

    @Override
    public void withdraw(ATM ATMInstance, int remainingAmount){

        int requiredNotes = remainingAmount / 2000;
        int balance = remainingAmount % 2000;

        if(requiredNotes <= ATMInstance.getNoOfTwoThousandNotes()){
            ATMInstance.deductTwoThousandNotes(requiredNotes);
        }
        else if(requiredNotes > ATMInstance.getNoOfTwoThousandNotes()){
            // if required number of 2000 Rs notes are more than notes available in ATM
            // we add again the balance in ATM. Once it is done, we deduct
            // the number of 2000 Rs notes from ATM
            balance = balance + (requiredNotes - ATMInstance.getNoOfTwoThousandNotes()) * 2000;
            //Give all the 2K notes available
            ATMInstance.deductTwoThousandNotes(ATMInstance.getNoOfTwoThousandNotes()); // Make 2K note count zero
        }

        if(requiredNotes != 0) {
            System.out.println("Dispatching "+ requiredNotes +" 2K notes");
        }

        if(balance != 0){
            nextCashWithdrawProcessor.withdraw(ATMInstance, balance);
        }
    }
}
