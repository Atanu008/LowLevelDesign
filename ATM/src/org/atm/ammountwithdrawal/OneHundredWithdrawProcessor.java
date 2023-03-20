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
        System.out.println("Remaining Amount "+ remainingAmount);
        System.out.println("required One Hundred Notes "+ requiredNotes);
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
    }
}
