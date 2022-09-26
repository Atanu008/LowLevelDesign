package com.splitwise.group;

import com.splitwise.models.ExpenseType;
import com.splitwise.models.User;
import com.splitwise.models.expense.Expense;
import com.splitwise.models.split.Split;
import com.splitwise.service.ExpenseService;

import java.util.*;

public class Group {

    private List<Expense> expenses;
    private Map<String, User> userMap;
    private Map<String, Map<String, Double>> balanceMap;

    public Group(){
        expenses = new ArrayList<>();
        userMap = new HashMap<>();
        balanceMap = new HashMap<>();
    }

    public void addUser(User user){
        userMap.put(user.getUserName(), user);
        balanceMap.putIfAbsent(user.getUserName(), new HashMap<>());
    }

    public User getUser(String userName){
        return userMap.get(userName);
    }

    public void addExpense(String expenseName, ExpenseType expenseType, double amount, String expensePaidBy, List<Split> splits){

        Expense expense = ExpenseService.createExpense(expenseName, expenseType, amount, userMap.get(expensePaidBy), splits);
        expenses.add(expense);

        assert expense != null;

        for(Split split : expense.getSplits()){

            // Update balance of the user for whom the amount is paid in Paid-By user balance sheet
            String paidFor = split.getUser().getUserName();
            Map<String, Double> paidForBalances = balanceMap.get(expensePaidBy);
            if(!paidForBalances.containsKey(paidFor)) {
                paidForBalances.put(paidFor, 0.0);
            }

            paidForBalances.put(paidFor, paidForBalances.get(paidFor) + split.getAmount());

            // Update balance of the user who paid the amount in Paid-For user balance sheet
            Map<String, Double> paidByBalances = balanceMap.get(paidFor);
            if(!paidByBalances.containsKey(expensePaidBy)){
                paidByBalances.put(expensePaidBy, 0.0);
            }

            paidByBalances.put(expensePaidBy, paidByBalances.get(expensePaidBy) - split.getAmount());

        }
    }

    public List<String> getBalance(String userName){

        List<String> balances = new ArrayList<>();
        for(Map.Entry<String, Double> userBalance : balanceMap.get(userName).entrySet()){
            if(userBalance.getValue() != 0){
                balances.add(prepareBalanceMessage(userName, userBalance.getKey(), userBalance.getValue()));
            }
        }
        return balances;
    }

    public Set<String> getBalances(){

        Set<String> balances = new HashSet<>();
        for(String user : balanceMap.keySet()){
            balances.addAll(getBalance(user));
        }

        return balances;
    }
    private String prepareBalanceMessage(String userA, String userB, Double amount) {

        String message = "";

        if(amount < 0){
            message += userA + " owes " + userB + " : " + Math.abs(amount);
        }
        else{
            message += userB + " owes " + userA + " : " + Math.abs(amount);
        }
        return message;
    }
}
