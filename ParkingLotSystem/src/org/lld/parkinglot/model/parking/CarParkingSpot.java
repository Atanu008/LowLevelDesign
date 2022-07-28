package org.lld.parkinglot.model.parking;

public class CarParkingSpot extends ParkingSpot{

    public CarParkingSpot(String parkingSpotId){
        super(parkingSpotId, ParkingSpotType.CAR);
    }
}
