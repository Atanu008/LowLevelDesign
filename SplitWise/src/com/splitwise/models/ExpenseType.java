package com.splitwise.models;

import java.util.HashMap;
import java.util.Map;

public enum ExpenseType {

    EQUAL("EQUAL"),
    EXACT("EXACT"),
    PERCENTAGE("PERCENTAGE");

    private final String expenseName;

    ExpenseType(String expenseName){
        this.expenseName = expenseName;
    }

    public String toString() {
        return this.expenseName;
    }

    private static final Map<String, ExpenseType> map = new HashMap<>();

    static {
        for (ExpenseType c : values()) map.put(c.expenseName, c);
    }

    public static ExpenseType of(String expenseName){
        return map.get(expenseName);
    }

}
