package org.atm.model;

public enum TransactionType {

    CASH_WITHDRAWAL,
    BALANCE_CHECK;

    public static void showAllTransactionType() {
        for(TransactionType tracsactionType : values()){
            System.out.println(tracsactionType.name());
        }
    }
}
