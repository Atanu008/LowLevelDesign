package com.rideshare.service;

import com.rideshare.model.Ride;

import java.util.Comparator;

public class FastestRide implements Comparator<Ride> {

    public int compare(Ride a, Ride b){
        return Integer.compare(a.getRideDuration(), b.getRideDuration());
    }
}
