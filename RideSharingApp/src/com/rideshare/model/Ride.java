package com.rideshare.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@AllArgsConstructor
@Getter
public class Ride{

    private User rideGiver;
    private Vehicle rideVehicle;
    private String origin;
    private String destination;
    @Setter
    private int availableSeats;
    private Date startTime;
    private int rideDuration;

}
