package org.lld.parkinglot.model.parking;


import lombok.Getter;
import lombok.Setter;
import org.lld.parkinglot.model.vehicle.Vehicle;

import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Setter
public class EntrancePanel {

    private String id;

    public EntrancePanel(String id){
        this.id = id;
    }

    public ParkingTicket getParkingTicket(Vehicle vehicle){

        ParkingLot parkingLot = ParkingLot.getInstance();

        if(!parkingLot.canPark(vehicle.getVehicleType())){
            return null;
            //throw new ParkingFullException();
        }

        ParkingSpot parkingSpot = parkingLot.getParkingSpot(vehicle.getVehicleType());
        if(parkingSpot == null){
            return null;
        }

        return buildTciket(vehicle.getLicenseNumber(), parkingSpot.getParkingSpotId());
    }

    //Next Activity - Implement Builder Pattern
    private ParkingTicket buildTciket(String licenseNumber, String parkingSpotId) {

        ParkingTicket parkingTicket = new ParkingTicket();
        parkingTicket.setIssuedAt(LocalDateTime.now());
        parkingTicket.setAllocatedSpotId(parkingSpotId);
        parkingTicket.setLicensePlateNumber(licenseNumber);
        parkingTicket.setTicketNumber(UUID.randomUUID().toString());
        parkingTicket.setTicketStatus(TicketStatus.ACTIVE);
        return parkingTicket;
    }
}
