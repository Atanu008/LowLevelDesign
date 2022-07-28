package org.lld.parkinglot.model.vehicle;

import lombok.Getter;
import lombok.Setter;
import org.lld.parkinglot.model.parking.ParkingTicket;

@Getter
@Setter
public abstract class Vehicle {

    private String licenseNumber;
    private VehicleType vehicleType;
    private ParkingTicket parkingTicket;

    public Vehicle(String licenseNumber, VehicleType type) {
        this.licenseNumber = licenseNumber;
        this.vehicleType = type;
    }

}
