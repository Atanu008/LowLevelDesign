package org.lld.parkinglot.model.parking;

import lombok.Getter;
import lombok.Setter;
import org.lld.parkinglot.model.vehicle.VehicleType;

import java.util.Deque;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentLinkedDeque;

public class ParkingFloor {

    @Getter
    @Setter
    private String floorId;
    @Getter
    private Map<ParkingSpotType, Deque<ParkingSpot>> parkingSpots; // Available Parking spots
    private Map<String, ParkingSpot> usedParkingSpots; // Used ones

    public ParkingFloor(String floorId){
        this.floorId = floorId;
        parkingSpots = new HashMap<>();
        usedParkingSpots = new HashMap<>();

        parkingSpots.put(ParkingSpotType.CAR, new ConcurrentLinkedDeque<>());
        parkingSpots.put(ParkingSpotType.LARGE, new ConcurrentLinkedDeque<>());
        parkingSpots.put(ParkingSpotType.MOTORBIKE, new ConcurrentLinkedDeque<>());
        parkingSpots.put(ParkingSpotType.ELECTRIC, new ConcurrentLinkedDeque<>());

    }

    public boolean isFloorFull(){

        /*
         * Iterate over all types of parkingSpots,
         * In case if any of the spots is not empty,
         * 		that means the floor itself is not empty
         * else
         * 		the whole floor is empty
         *
         */
        for(Map.Entry<ParkingSpotType, Deque<ParkingSpot>> entry : parkingSpots.entrySet()){
            if(entry.getValue().size() != 0){ // This means we still have available
                return false;
            }
        }
        return true; // size of the all parking spot queue is zero i.e no available
    }


    public static ParkingSpotType getParkingSpotType(VehicleType vehicleType){

        switch (vehicleType){
            case CAR:
                return ParkingSpotType.CAR;
            case ELECTRIC:
                return ParkingSpotType.ELECTRIC;
            case MOTORBIKE:
                return ParkingSpotType.MOTORBIKE;
            default:
                return ParkingSpotType.LARGE;
        }
    }

    public synchronized ParkingSpot getParkingSpot(VehicleType vehicleType){

        //No space for vehicleType in this Floor
        if(!canPark(vehicleType))
            return null;

        ParkingSpotType parkingSpotType = getParkingSpotType(vehicleType);
        ParkingSpot parkingSpot = parkingSpots.get(parkingSpotType).poll(); //Remove from Remaining from available parking spot

        //Update used Parking Map
        usedParkingSpots.put(parkingSpot.getParkingSpotId(), parkingSpot);

        return parkingSpot;
    }

    public ParkingSpot vacateParkingSpot(String parkingSpotId){
        //Remove from Used Parking spots
        ParkingSpot parkingSpot = usedParkingSpots.remove(parkingSpotId);
        //Have a valid Parking Spot
        if(parkingSpot != null){
            parkingSpot.freeSpot();//Make this Spot Free
            parkingSpots.get(parkingSpot.getParkingSpotType()).addFirst(parkingSpot); // Make it available in Floor
            return parkingSpot;
        }

        return null; // Not a valid parking Spot
    }

    public boolean canPark(VehicleType vehicleType){
        return isSpotAvailable(getParkingSpotType(vehicleType));
    }

    public boolean isSpotAvailable(ParkingSpotType parkingSpotType){
        return parkingSpots.get(parkingSpotType).size() > 0;
    }
}
