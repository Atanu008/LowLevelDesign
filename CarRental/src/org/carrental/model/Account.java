package org.carrental.model;

import lombok.Getter;

@Getter
public abstract class Account extends Person{

    private String accountId;
    private String password;
    private AccountStatus accountStatus;

    public Account(String name, String address, String email, int phoneNumber, String accountId, String password,
                   AccountStatus accountStatus) {
        super(name, address, email, phoneNumber);
    }


    public abstract boolean resetPassword();
}
