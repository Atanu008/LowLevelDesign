package org.lld.parkinglot.model.parking;

import lombok.Getter;
import lombok.Setter;
import org.lld.parkinglot.model.vehicle.VehicleType;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Getter
@Setter
public class ParkingLot {

    private String parkingLotId;
    private Address address;

    private List<ParkingFloor> parkingFloors;
    private List<EntrancePanel> entarcePanels;
    private List<ExitPanel> exitPanels;


    // singleton ParkingLot to ensure only one object of ParkingLot in the system,
    private static ParkingLot parkingLot = null;

    // private constructor to restrict for singleton
    private ParkingLot() {

        this.parkingLotId = UUID.randomUUID().toString();
        parkingFloors = new ArrayList<>();
        entarcePanels = new ArrayList<>();
        exitPanels = new ArrayList<>();
    }

    // static method to get the singleton instance of ParkingLot
    public static ParkingLot getInstance() {
        if (parkingLot == null) {
            parkingLot = new ParkingLot();
        }
        return parkingLot;
    }

    public boolean isFull(){
        //If any floor has available spot return false
        for(ParkingFloor floor : parkingFloors){
            if(!floor.isFloorFull()){
                return false;
            }
        }

        return true;
    }

    public boolean canPark(VehicleType vehicleType){

        for(ParkingFloor parkingFloor : parkingFloors){
            if(parkingFloor.canPark(vehicleType)){
                return true;
            }
        }
        return false;
    }

    public ParkingSpot getParkingSpot(VehicleType vehicleType){

        for(ParkingFloor parkingFloor : parkingFloors){
            ParkingSpot parkingSpot = parkingFloor.getParkingSpot(vehicleType);
            if (parkingSpot != null) {
                return parkingSpot;
            }
        }
        return null;
    }

    public ParkingSpot vacateParkingSpot(String parkingSpotId){

        for(ParkingFloor parkingFloor : parkingFloors){
            ParkingSpot parkingSpot = parkingFloor.vacateParkingSpot(parkingSpotId);
            if (parkingSpot != null) {
                return parkingSpot;
            }
        }
        return null;
    }


}
