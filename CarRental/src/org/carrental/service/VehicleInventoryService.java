package org.carrental.service;

import org.carrental.model.Vehicle;
import org.carrental.model.VehicleReservation;
import org.carrental.model.VehicleStatus;

import java.util.*;
import java.util.stream.Collectors;

public class VehicleInventoryService {

    private Map<String , Vehicle> vehiclesMap;
    private Map<Vehicle, List<VehicleReservation>> vehicleReservationMap;


    public VehicleInventoryService(){
        vehiclesMap =  new HashMap<>();
        vehicleReservationMap = new HashMap<>();
    }

    public void addVehicles(List<Vehicle> vehicles){
        vehicles.forEach(vehicle -> vehiclesMap.put(vehicle.getVehicleID(), vehicle));
    }

    public List<Vehicle> getAllVehicles(){
        return new ArrayList<>(vehiclesMap.values());
    }

    public List<Vehicle> getAllAvailablesVehicles(){
        return vehiclesMap.values().stream()
                .filter(vehicle -> VehicleStatus.AVAILABLE.equals(vehicle.getVehicleStatus()))
                .collect(Collectors.toList());
    }

    public void addVehicle(Vehicle vehicle){
        vehiclesMap.put(vehicle.getVehicleID(), vehicle);
    }

    public boolean isAvailableForReservation(Vehicle vehicle){
        if(this.vehiclesMap.get(vehicle.getVehicleID()) != null){
            return VehicleStatus.AVAILABLE.equals(this.vehiclesMap.get(vehicle.getVehicleID()).getVehicleStatus());
        }
        return false;
    }

    public Map<Vehicle, List<VehicleReservation>> getVehicleReservationMap() {
        return vehicleReservationMap;
    }

    public List<VehicleReservation> findReservationsByVehicle(Vehicle vehicle) {
        return vehicleReservationMap.get(vehicle);
    }

    public void addToReservationToVehicle(Vehicle vehicle, VehicleReservation vehicleReservation) {
        vehicleReservationMap.putIfAbsent(vehicle, new ArrayList<>());
        vehicleReservationMap.get(vehicle).add(vehicleReservation);
    }

}
