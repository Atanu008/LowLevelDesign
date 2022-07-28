package org.lld.parkinglot.model.parking;

import java.util.HashMap;
import java.util.Map;

public class HourlyCost {

    private Map<ParkingSpotType, Double> hourlyCosts;

    public HourlyCost(){

        hourlyCosts = new HashMap<>();
        hourlyCosts.put(ParkingSpotType.CAR, 20.0);
        hourlyCosts.put(ParkingSpotType.LARGE, 30.0);
        hourlyCosts.put(ParkingSpotType.ELECTRIC, 25.0);
        hourlyCosts.put(ParkingSpotType.MOTORBIKE, 10.0);
    }

    public double getCost(ParkingSpotType parkingSpotType){
        return hourlyCosts.get(parkingSpotType);
    }
}
