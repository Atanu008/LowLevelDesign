package org.atm.ammountwithdrawal;

import org.atm.ATM;

public class OneHundredWithdrawProcessor extends CashWithdrawProcessor{

    public OneHundredWithdrawProcessor(CashWithdrawProcessor nextCashWithdrawProcessor) {
        super(nextCashWithdrawProcessor);
    }

    @Override
    public void withdraw(ATM ATMInstance, int remainingAmount){
        int requiredNotes = remainingAmount / 100;
        int balance = remainingAmount % 100;
        //We wont support amounts not divisible by 100
        if(balance != 0){
            System.out.println("Unable To Dispatch. Denominations not available");
        }
        else if(requiredNotes <= ATMInstance.getNoOfOneHundredNotes()){
            ATMInstance.deductOneHundredNotes(requiredNotes);
        }
        else if(requiredNotes > ATMInstance.getNoOfOneHundredNotes()){
            System.out.println("Unable To Dispatch. Denominations not available : Not enough NOtes");
            throw new RuntimeException("Not Enough Notes");
        }

        if(requiredNotes != 0) {
            System.out.println("Dispatching "+ requiredNotes +" 100 notes");
        }
    }
}
