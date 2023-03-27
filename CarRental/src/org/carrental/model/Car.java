package org.carrental.model;

import java.util.UUID;

public class Car extends Vehicle{

    public Car(int licenseNumber, int dailyRentalCost, int hourlyRentalCost, int passengerCapacity) {
        super(UUID.randomUUID().toString(), licenseNumber, VehicleType.CAR, dailyRentalCost,
                hourlyRentalCost, passengerCapacity);
    }

}
