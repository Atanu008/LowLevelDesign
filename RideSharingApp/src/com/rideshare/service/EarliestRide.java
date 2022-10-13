package com.rideshare.service;

import com.rideshare.model.Ride;

import java.util.Comparator;

public class EarliestRide implements Comparator<Ride> {

    @Override
    public int compare(Ride a, Ride b) {
        return a.getStartTime().compareTo(b.getStartTime());
    }
}
