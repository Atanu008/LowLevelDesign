package org.carrental.model;

import lombok.Getter;

import java.util.Date;

@Getter
public class Driver extends Account{
    private String drivingLicenseNumber;
    private Date licenseExpiry;
    private String driverId;

    public Driver(String name, String address, String email, int phoneNumber, String accountId, String password, AccountStatus accountStatus) {
        super(name, address, email, phoneNumber, accountId, password, accountStatus);
    }

    @Override
    public boolean resetPassword() {
        return false;
    }
}
