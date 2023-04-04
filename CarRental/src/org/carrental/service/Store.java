package org.carrental.service;

import lombok.Getter;
import org.carrental.exception.NoAvailableVehicle;
import org.carrental.model.*;

import java.time.LocalDateTime;
import java.util.*;

@Getter
public class Store {

    private Location location;
    private String storeId;
    private VehicleInventoryService vehicleInventoryService;
    private UserService userService;
    private Map<String, VehicleReservation> reservationMap;

    /*
    VehicleInventoryService has one-to-one relationship with store
    i.e. every store will have it's own VehicleInventory. Hence we are initializing new object on
    Store object creation.
    But wrt UserService, it is only one across the whole application.
    Hence we are injecting this on every store.
     */
    public Store(Location location, UserService userService) {
        this.storeId = UUID.randomUUID().toString();
        this.location = location;
        this.userService = userService;
        vehicleInventoryService = new VehicleInventoryService();
        reservationMap = new HashMap<>();
    }

    public VehicleReservation reserveVehicle(User user, LocalDateTime startDate, LocalDateTime endDate, String pickUpLocation, String returnLocation){
        List<Vehicle> allAvailableVehicles = getAllAvailableCar();
        Vehicle reservedVehicle = null;
        VehicleReservation vehicleReservation = null;
        if(allAvailableVehicles != null && !allAvailableVehicles.isEmpty()) {
            reservedVehicle = allAvailableVehicles.get(0);
            vehicleReservation = reserveVehicle(user, reservedVehicle, startDate, endDate, pickUpLocation, returnLocation);
        }
        else {
            throw new NoAvailableVehicle("No Available Vehicle In Store");
        }
        return vehicleReservation;
    }

    public VehicleReservation reserveVehicle(User user, Vehicle vehicle, LocalDateTime startDate, LocalDateTime endDate, String pickUpLocation, String returnLocation){
        VehicleReservation vehicleReservation = new VehicleReservation(vehicle, user, new Date(), startDate, endDate, pickUpLocation, returnLocation);
        vehicle.setVehicleStatus(VehicleStatus.RESERVED);
        userService.addUserReservation(user, vehicleReservation);
        reservationMap.put(vehicleReservation.getReservationId(), vehicleReservation);

        return vehicleReservation;
    }

    public void cancelReservation(String reservationId){
        VehicleReservation vehicleReservation = reservationMap.get(reservationId);
        if(vehicleReservation != null){
            updateReservationAndVehicleStatus(vehicleReservation, ReservationStatus.CANCELLED, VehicleStatus.AVAILABLE);
        }
    }

    public void startTrip(String reservationId){
        VehicleReservation vehicleReservation = reservationMap.get(reservationId);
        if(vehicleReservation != null){
            updateReservationAndVehicleStatus(vehicleReservation, ReservationStatus.INPROGRESS, VehicleStatus.BEING_SERVICED);
        }
    }

    public void endTrip(String reservationId){
        VehicleReservation vehicleReservation = reservationMap.get(reservationId);
        if(vehicleReservation != null){
            updateReservationAndVehicleStatus(vehicleReservation, ReservationStatus.COMPLETE, VehicleStatus.AVAILABLE);
        }
    }

    private void updateReservationAndVehicleStatus(VehicleReservation vehicleReservation, ReservationStatus reservationStatus, VehicleStatus vehicleStatus) {
        vehicleReservation.setReservationStatus(reservationStatus); // Cancel the reservation
        vehicleReservation.getVehicle().setVehicleStatus(vehicleStatus);  // make the Vehicle Available
    }

    public List<Vehicle> getAllAvailableCar(){
        return vehicleInventoryService.getAllAvailablesVehicles();
    }

    public void addVehicleToStore(Vehicle vehicle){
        vehicleInventoryService.addVehicle(vehicle);
    }

    @Override
    public String toString() {
        return "Store{" +
                "location=" + location +
                ", storeId='" + storeId + '\'' +
                '}';
    }
}
