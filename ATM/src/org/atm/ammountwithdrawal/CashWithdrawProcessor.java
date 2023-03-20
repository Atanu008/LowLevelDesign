package org.atm.ammountwithdrawal;

import org.atm.ATM;

public abstract class CashWithdrawProcessor {

    CashWithdrawProcessor nextCashWithdrawProcessor;

    public CashWithdrawProcessor(CashWithdrawProcessor nextCashWithdrawProcessor) {
        this.nextCashWithdrawProcessor = nextCashWithdrawProcessor;
    }

    public abstract void  withdraw(ATM ATMInstance, int remainingAmount);

}
