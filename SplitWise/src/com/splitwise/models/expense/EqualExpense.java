package com.splitwise.models.expense;

import com.splitwise.models.User;
import com.splitwise.models.split.EqualSplit;
import com.splitwise.models.split.Split;

import java.util.List;

public class EqualExpense extends Expense{

    public EqualExpense(String expenseName, double amount, User expensePaidBy, List<Split> splits){
        super(expenseName, amount, expensePaidBy, splits);
    }

    @Override
    public boolean validate() {
        for(Split split : getSplits()){
            if(!(split instanceof EqualSplit)){
                return false;
            }
        }
        return true;
    }
}
