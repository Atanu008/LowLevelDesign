package org.carrental.model;

import lombok.Getter;

import java.util.UUID;

@Getter
public abstract class Account extends Person{

    private String accountId;
    private String password;
    private AccountStatus accountStatus;

    public Account(String name, String address, String email, int phoneNumber, String password,
                   AccountStatus accountStatus) {
        super(name, address, email, phoneNumber);
        accountId = UUID.randomUUID().toString();
        this.password = password;
        this.accountStatus = accountStatus;
    }


    public abstract boolean resetPassword();

    @Override
    public String toString() {
        return "Account{" +
                "accountId='" + accountId + '\'' +
                ", password='" + password + '\'' +
                ", accountStatus=" + accountStatus +
                "} " + super.toString();
    }
}
