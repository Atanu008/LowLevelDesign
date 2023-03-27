package org.carrental.model;

import lombok.Getter;

import java.util.Date;

@Getter
public class User extends Account{

    private String drivingLicenseNumber;
    private Date licenseExpiry;

    public User(String name, String address, String email, int phoneNumber, String accountId, String password) {
        super(name, address, email, phoneNumber, accountId, password, AccountStatus.ACTIVE);
    }

    @Override
    public boolean resetPassword() {
        return false;
    }
}
