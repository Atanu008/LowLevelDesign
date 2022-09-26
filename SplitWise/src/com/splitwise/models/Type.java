package com.splitwise.models;

import java.util.HashMap;
import java.util.Map;

public enum Type {

    EXPENSES("EXPENSE"),
    SHOW("SHOW"),
    QUIT("QUIT");

    private final String name;

    Type(String name){
        this.name = name;
    }

    public String toString(){
        return this.name;
    }

    private static Map<String, Type> map = new HashMap<>(values().length); // We don't need more than three entries. so specifying size

    static{
        for(Type c : values()){
            map.put(c.name, c);
        }
    }

    public static Type of(String name){
        return map.get(name);
    }
}
