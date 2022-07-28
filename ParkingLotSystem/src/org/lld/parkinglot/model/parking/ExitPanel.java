package org.lld.parkinglot.model.parking;

import lombok.Getter;

import java.time.Duration;
import java.time.LocalDateTime;

@Getter
public class ExitPanel {

    private String id;

    public ExitPanel(String id){
        this.id = id;
    }

    public ParkingTicket scanAndVacate(ParkingTicket parkingTicket){

        ParkingSpot parkingSpot = ParkingLot.getInstance().vacateParkingSpot(parkingTicket.getAllocatedSpotId());
        parkingTicket.setCharges(calculateCost(parkingTicket, parkingSpot.getParkingSpotType()));

        return parkingTicket;
    }

    private double calculateCost(ParkingTicket parkingTicket, ParkingSpotType parkingSpotType) {

        Duration duration = Duration.between(parkingTicket.getIssuedAt() , LocalDateTime.now());
        long hours = duration.toHours();

        if(hours == 0){
            hours = 1;
        }

        double amount = hours * new HourlyCost().getCost(parkingSpotType);

        return amount;
    }
}
