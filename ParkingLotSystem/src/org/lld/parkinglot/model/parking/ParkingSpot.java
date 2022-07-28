package org.lld.parkinglot.model.parking;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ParkingSpot {

    private String parkingSpotId;
    private boolean isFree;
    private ParkingSpotType parkingSpotType;
    private String assignedVehicleId;

    public ParkingSpot(String parkingSpotId, ParkingSpotType parkingSpotType){
        this.parkingSpotId = parkingSpotId;
        this.parkingSpotType = parkingSpotType;
        isFree = true;
    }

    public void assignVehicleToSpot(String vehicleId){
        this.assignedVehicleId = vehicleId;
        this.isFree = false;
    }

    public void freeSpot(){
        this.isFree = true;
        this.assignedVehicleId = null;
    }
}
