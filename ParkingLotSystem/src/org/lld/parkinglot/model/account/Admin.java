package org.lld.parkinglot.model.account;

import org.lld.parkinglot.model.exception.InvlaidParkingFloorException;
import org.lld.parkinglot.model.parking.*;

import java.util.Optional;

public class Admin extends Account{

    public void addParkingFloor(ParkingFloor parkingFloor){

        ParkingLot parkingLot = ParkingLot.getInstance();
        Optional<ParkingFloor> floor = parkingLot.getParkingFloors().stream()
                .filter(pF -> pF.getFloorId().equals(parkingFloor.getFloorId()) )
                .findFirst();
        //Existing Floor
        if(floor.isPresent()){
            return;
        }

        parkingLot.getParkingFloors().add(parkingFloor);
    }

    public void addParkingSpot(String parkingFloorId, ParkingSpot parkingSpot) throws InvlaidParkingFloorException {

        ParkingLot parkingLot = ParkingLot.getInstance();

        Optional<ParkingFloor> floor = parkingLot.getParkingFloors().stream()
                .filter(pF -> pF.getFloorId().equals(parkingFloorId))
                .findFirst();
        if(floor.isEmpty()){
            throw new InvlaidParkingFloorException("Invalid Floor");
        }

        Optional<ParkingSpot> spot = floor.get().getParkingSpots().get(parkingSpot.getParkingSpotType()).stream()
                .filter(pS -> pS.getParkingSpotId().equals(parkingSpot.getParkingSpotId()))
                .findFirst();

        if (spot.isPresent())
            return;
        System.out.println("Adding Cpot "+ parkingSpot.getParkingSpotId());
        floor.get().getParkingSpots().get(parkingSpot.getParkingSpotType())
                .addLast(parkingSpot);
        System.out.println("Spot Size "+ floor.get().getParkingSpots().get(parkingSpot.getParkingSpotType()).size());

    }

    public void addEntrancePanel(EntrancePanel entrancePanel){

        ParkingLot parkingLot = ParkingLot.getInstance();
        Optional<EntrancePanel> entrance = parkingLot.getEntarcePanels().stream()
                .filter(esP -> esP.getId().equals(entrancePanel.getId()))
                .findFirst();
        if(entrance.isPresent()){
            return;
        }

        parkingLot.getEntarcePanels().add(entrancePanel);
    }

    public void addExitPanel(ExitPanel exitPanel){

        ParkingLot parkingLot = ParkingLot.getInstance();
        Optional<ExitPanel> exit = parkingLot.getExitPanels().stream()
                .filter(ex -> ex.getId().equals(exitPanel.getId()))
                .findFirst();

        if(exit.isPresent()){
            return;
        }

        parkingLot.getExitPanels().add(exitPanel);
    }

}
