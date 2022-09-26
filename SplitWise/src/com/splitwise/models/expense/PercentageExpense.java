package com.splitwise.models.expense;

import com.splitwise.models.User;
import com.splitwise.models.split.PercentSplit;
import com.splitwise.models.split.Split;

import java.util.List;

public class PercentageExpense extends Expense{

    public PercentageExpense(String expenseName, double amount, User expensePaidBy, List<Split> splits){
        super(expenseName, amount, expensePaidBy, splits);
    }

    @Override
    public boolean validate() {

        double totalSplitPercentage = 0;

        for(Split split : getSplits()){
            if(!(split instanceof PercentSplit)){
                return false;
            }
            totalSplitPercentage += ((PercentSplit) split).getPercent();
        }

        return 100.0 == totalSplitPercentage;
    }
}
