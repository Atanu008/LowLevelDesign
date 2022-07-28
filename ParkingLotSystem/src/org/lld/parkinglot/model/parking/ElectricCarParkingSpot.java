package org.lld.parkinglot.model.parking;

public class ElectricCarParkingSpot extends ParkingSpot{
    public ElectricCarParkingSpot(String parkingSpotId) {
        super(parkingSpotId, ParkingSpotType.ELECTRIC);
    }
}
