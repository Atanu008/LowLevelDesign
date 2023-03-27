package org.carrental.model;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.UUID;

@Getter
@Setter
public class VehicleReservation {

    private String reservationId;
    private Vehicle vehicle;
    private User user;
    private ReservationStatus reservationStatus;
    private Date dateOfReservation;
    private Date satrtDate;
    private Date endDate; //Return Date;
    private String pickupLocation;
    private String returnLocation;

    public VehicleReservation(Vehicle vehicle, User user, Date dateOfReservation, Date satrtDate, Date endDate, String pickupLocation, String returnLocation) {
        this.reservationId = UUID.randomUUID().toString();
        this.vehicle = vehicle;
        this.user = user;
        this.reservationStatus = ReservationStatus.PENDING;
        this.dateOfReservation = dateOfReservation;
        this.satrtDate = satrtDate;
        this.endDate = endDate;
        this.pickupLocation = pickupLocation;
        this.returnLocation = returnLocation;
    }

    public void updateReservationStatus(ReservationStatus reservationStatus){
        this.reservationStatus = reservationStatus;
    }
    // Below can be part of reservations
    // private List<Equipment> equipments; We can use Equipment(Eg : Navigation, ChildSeat, SkiRack) add Ons
    // private List<Service> services; Services(DriverService, RoadsideAssistance, WiFi) can be included
}
