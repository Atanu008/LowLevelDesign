package com.splitwise.service;

import com.splitwise.group.Group;
import com.splitwise.models.ExpenseType;
import com.splitwise.models.split.Split;

import java.util.List;
import java.util.Set;

public class SplitWiseService {

    Group group;

    public SplitWiseService(Group group){
        this.group = group;
    }

    public void addExpense(String expenseName, ExpenseType expenseType, double amount, String expensePaidBy, List<Split> splits){
        group.addExpense(expenseName, expenseType, amount, expensePaidBy, splits);
    }

    public void showBalance(String userName){
        List<String> balances = group.getBalance(userName);
        if(balances != null && !balances.isEmpty()){
            balances.forEach(System.out::println);
        }
        else{
            System.out.println("No Balance");
        }
    }

    public void showBalances(){
        Set<String> balances = group.getBalances();
        if(balances != null && !balances.isEmpty()){
            balances.forEach(System.out::println);
        }
        else{
            System.out.println("No Balance");
        }
    }
}
