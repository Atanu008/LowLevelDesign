package com.splitwise.service;

import com.splitwise.models.ExpenseType;
import com.splitwise.models.User;
import com.splitwise.models.expense.EqualExpense;
import com.splitwise.models.expense.ExactExpense;
import com.splitwise.models.expense.Expense;
import com.splitwise.models.expense.PercentageExpense;
import com.splitwise.models.split.PercentSplit;
import com.splitwise.models.split.Split;

import java.util.List;

public class ExpenseService {

    public static Expense createExpense(String expenseName, ExpenseType expenseType, double amount, User expensePaidBy,
                                        List<Split> splits){

        switch (expenseType){
            case EXACT :
                return new ExactExpense(expenseName, amount, expensePaidBy, splits);

            case PERCENTAGE:
                for(Split split : splits){
                    PercentSplit percentSplit = (PercentSplit) split;
                    double splitAmount = (amount * percentSplit.getPercent())/100.0;
                    percentSplit.setAmount(splitAmount);
                }
                return new PercentageExpense(expenseName, amount, expensePaidBy,  splits);

            case EQUAL:
                // multiplying with 100 to take two decimal place consideration
                // e.g : amount = 20 and totalSplits =3
                // 20*100 = 2000/3 = 666.6667
                // Round(666.6667) = 666
                // 666/100 = 6.66 ( this is the exact split as we need to consider the decimal place to make total
                // amount 100
                double splitAmount = (double)(Math.round((amount * 100)/splits.size()))/100.0;
                return new EqualExpense(expenseName, amount, expensePaidBy, splits);

            default:
                return null;
        }

    }
}
