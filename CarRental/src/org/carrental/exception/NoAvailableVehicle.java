package org.carrental.exception;

public class NoAvailableVehicle extends RuntimeException {

    public NoAvailableVehicle(String no_available_vehicle) {
        super(no_available_vehicle);
    }
}
