package org.carrental.model;

import lombok.Getter;

import java.util.Date;

@Getter
public class User extends Account{

    private String drivingLicenseNumber;
    private Date licenseExpiry;

    public User(String name, String address, String email, int phoneNumber, String password, String drivingLicenseNumber,
                Date licenseExpiry) {
        super(name, address, email, phoneNumber, password, AccountStatus.ACTIVE);
        this.drivingLicenseNumber = drivingLicenseNumber;
        this.licenseExpiry = licenseExpiry;
    }

    @Override
    public boolean resetPassword() {
        return false;
    }

    @Override
    public String toString() {
        return "User{" +
                "drivingLicenseNumber='" + drivingLicenseNumber + '\'' +
                ", licenseExpiry=" + licenseExpiry +
                "} " + super.toString();
    }
}
