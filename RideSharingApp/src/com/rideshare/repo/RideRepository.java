package com.rideshare.repo;

import com.rideshare.model.Ride;
import com.rideshare.model.User;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Getter
@Setter
public class RideRepository {

    private List<Ride> allOffers;
    private Map<User, List<Ride>> allRidesTaken;

    public RideRepository() {
        allOffers = new ArrayList<>();
        allRidesTaken = new HashMap<>();
    }
}
