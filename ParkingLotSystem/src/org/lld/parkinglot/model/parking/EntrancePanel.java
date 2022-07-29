package org.lld.parkinglot.model.parking;


import lombok.Getter;
import lombok.Setter;
import org.lld.parkinglot.model.exception.ParkingLotFullException;
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

    public ParkingTicket getParkingTicket(Vehicle vehicle) throws ParkingLotFullException {

        ParkingLot parkingLot = ParkingLot.getInstance();

        if(!parkingLot.canPark(vehicle.getVehicleType())){
            throw new ParkingLotFullException("Parking Full . Try Later");
        }

        ParkingSpot parkingSpot = parkingLot.getParkingSpot(vehicle.getVehicleType());

        if(parkingSpot == null){
            return null;
        }
        //Assign License Number To Parking Spot Object
        parkingSpot.assignVehicleToSpot(vehicle.getLicenseNumber());
        //Prepare Ticket
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
