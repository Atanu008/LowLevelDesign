package org.atm;

import org.atm.model.BankAccount;
import org.atm.model.Card;
import org.atm.model.TransactionType;
import org.atm.model.User;

import java.util.Date;

public class ATMRoom {

    ATM ATMInsatance;
    User user;

    public static void main(String[] args) {
        ATMRoom atmRoom = new ATMRoom();
        atmRoom.init();
        atmRoom.ATMInsatance.printCurrentATMBalance();
        atmRoom.ATMInsatance.getCurrentATMState().insertCard(atmRoom.user.getCard());
        atmRoom.ATMInsatance.getCurrentATMState().authenticatePin(atmRoom.user.getCard(), 1234);
        atmRoom.ATMInsatance.getCurrentATMState().selectOperation(atmRoom.user.getCard(), TransactionType.CASH_WITHDRAWAL);
        atmRoom.ATMInsatance.getCurrentATMState().cashWithdrawal(atmRoom.user.getCard(), 2700);
        atmRoom.ATMInsatance.printCurrentATMBalance();
    }

    private void init() {
        this.ATMInsatance = ATM.getInstance();
        ATMInsatance.setAtmBalance(3500, 1, 2, 5);

        this.user = createUser();
    }

    private User createUser() {
        BankAccount bankAccount = new BankAccount("1298", 3000);
        Card card = createCard(bankAccount);
        User user = new User();
        user.setCard(card);
        user.setUserBankAccount(bankAccount);
        return user;
    }

    private Card createCard(BankAccount bankAccount) {
        Card card = new Card(198007, 295, new Date(), "Riju", 1234, bankAccount);
        return card;
    }
}
