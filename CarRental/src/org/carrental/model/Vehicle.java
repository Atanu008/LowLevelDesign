package org.carrental.model;

public class Vehicle {
    String vehicleID;
    int licenseNumber;
    VehicleType vehicleType;
    VehicleStatus vehicleStatus;
    int dailyRentalCost;
    int hourlyRentalCost;
    int passengerCapacity;

    public Vehicle(String vehicleID, int licenseNumber, VehicleType vehicleType, int dailyRentalCost, int hourlyRentalCost, int passengerCapacity) {
        this.vehicleID = vehicleID;
        this.licenseNumber = licenseNumber;
        this.vehicleType = vehicleType;
        this.dailyRentalCost = dailyRentalCost;
        this.hourlyRentalCost = hourlyRentalCost;
        this.passengerCapacity = passengerCapacity;
        this.vehicleStatus = VehicleStatus.AVAILABLE;
    }

    public String getVehicleID() {
        return vehicleID;
    }

    public void setVehicleID(String vehicleID) {
        this.vehicleID = vehicleID;
    }

    public int getLicenseNumber() {
        return licenseNumber;
    }

    public void setLicenseNumber(int licenseNumber) {
        this.licenseNumber = licenseNumber;
    }

    public VehicleType getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(VehicleType vehicleType) {
        this.vehicleType = vehicleType;
    }

    public VehicleStatus getVehicleStatus() {
        return vehicleStatus;
    }

    public void setVehicleStatus(VehicleStatus vehicleStatus) {
        this.vehicleStatus = vehicleStatus;
    }

    public int getDailyRentalCost() {
        return dailyRentalCost;
    }

    public void setDailyRentalCost(int dailyRentalCost) {
        this.dailyRentalCost = dailyRentalCost;
    }

    public int getHourlyRentalCost() {
        return hourlyRentalCost;
    }

    public void setHourlyRentalCost(int hourlyRentalCost) {
        this.hourlyRentalCost = hourlyRentalCost;
    }

    public int getPassengerCapacity() {
        return passengerCapacity;
    }

    public void setPassengerCapacity(int passengerCapacity) {
        this.passengerCapacity = passengerCapacity;
    }
}
