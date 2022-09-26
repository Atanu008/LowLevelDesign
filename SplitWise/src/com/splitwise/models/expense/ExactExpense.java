package com.splitwise.models.expense;

import com.splitwise.models.User;
import com.splitwise.models.split.ExactSplit;
import com.splitwise.models.split.Split;

import java.util.List;

public class ExactExpense extends Expense{

    public ExactExpense(String expenseName, double amount, User expensePaidBy, List<Split> splits) {
        super(expenseName, amount, expensePaidBy, splits);
    }

    @Override
    public boolean validate() {
        double totalAmount = getAmount();
        double splitAmount = 0;

        for (Split split : getSplits()){
            if (!(split instanceof ExactSplit)){
                return false;
            }
            splitAmount += split.getAmount();
        }
        return totalAmount == splitAmount;
    }
}
