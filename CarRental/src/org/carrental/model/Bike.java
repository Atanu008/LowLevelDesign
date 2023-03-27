package org.carrental.model;

import java.util.UUID;

public class Bike extends Vehicle{
    public Bike(int licenseNumber, int dailyRentalCost, int hourlyRentalCost) {
        super(UUID.randomUUID().toString(), licenseNumber, VehicleType.BIKE, dailyRentalCost, hourlyRentalCost, 2);
    }
}
