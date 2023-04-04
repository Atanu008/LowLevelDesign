package org.carrental.service;

import lombok.Getter;
import org.carrental.model.VehicleReservation;

import java.time.Duration;
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

        Duration duration = Duration.between(vehicleReservation.getSatrtDate(), vehicleReservation.getEndDate());
        long days = duration.toDays();
        long hours = duration.toHours();

        double amount = days * vehicleReservation.getVehicle().getDailyRentalCost();
        long remainingHours = hours - (days * 24);
        //System.out.println("Making Payment of Vehicle : "+  vehicleReservation.getVehicle());
        amount += remainingHours * vehicleReservation.getVehicle().getHourlyRentalCost();
        return amount;
    }


}
