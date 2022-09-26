package com.splitwise.models.expense;

import com.splitwise.models.User;
import com.splitwise.models.split.Split;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.UUID;

@Getter
@Setter
public abstract class Expense {

    private final String id;
    private String expenseName;
    private double amount;
    private User expensePaidBy;
    private List<Split> splits;

    public Expense(String expenseName, double amount, User expensePaidBy, List<Split> splits) {
        this.id = UUID.randomUUID().toString();
        this.expenseName = expenseName;
        this.amount = amount;
        this.expensePaidBy = expensePaidBy;
        this.splits = splits;
    }


    public abstract boolean validate();
}
