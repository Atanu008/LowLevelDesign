package org.carrental.service;

import lombok.Getter;
import org.carrental.model.VehicleReservation;

import java.util.Date;

@Getter
public class Bill {

    private VehicleReservation vehicleReservation;
    private Date paymentTimeStamp;

    public Bill(VehicleReservation vehicleReservation) {
        this.vehicleReservation = vehicleReservation;
        this.paymentTimeStamp = new Date();
    }

    public double calculateAmount(){
        // TODO
        return 100.0;
    }


}
