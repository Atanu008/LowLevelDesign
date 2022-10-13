package com.rideshare.service;

import com.rideshare.model.Ride;
import com.rideshare.model.User;
import com.rideshare.model.Vehicle;
import com.rideshare.repo.RideRepository;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class RideService {

    private static RideRepository  rideRepository = new RideRepository();

    public static Ride offerRide(String ownerName, String regNo, int availableSeats, String origin, String destination, String startTime, int duration) throws ParseException {

        User user = UserService.getVehicleByOwnerNameAndRegNo(ownerName, regNo);
        if(user == null){
            System.out.println("user "+ownerName+" has no such vehicle "+regNo+" so cannot offer such ride");
            return null;
        }

        Vehicle vehicle = UserService.getVehicleByRegNo(regNo);

        if(vehicle == null){
            System.out.println("user "+ownerName+" has no such vehicle "+regNo+" so cannot offer such ride");
            return null;
        }

        DateFormat format = new SimpleDateFormat("d MMM, yyyy HH", Locale.ENGLISH);
        Date rideStartTime = format.parse(startTime);

        Ride ride = new Ride(user, vehicle, origin, destination, availableSeats, rideStartTime,duration );
        user.setRideOffered(user.getRideOffered()+1);
        rideRepository.getAllOffers().add(ride);

        return ride;
    }

    public static Ride selectRide(String name, String origin, String destination, String type){

        User user = UserService.getUserByName(name);
        if(user == null){
            System.out.println("No Such User "+name);
            return null;
        }

        Ride ride = selectRideService(user, origin, destination, type);
        if(ride == null){
            System.out.println("No Such Ride with Origin "+origin +" Destination "+ destination);
            return null;
        }

        ride.setAvailableSeats(ride.getAvailableSeats() - 1);
        user.setRideTaken(user.getRideTaken()+1);
        rideRepository.getAllRidesTaken().putIfAbsent(user, new ArrayList<>());
        rideRepository.getAllRidesTaken().get(user).add(ride);
        System.out.println("Ride given by "+ ride.getRideGiver().getName() + " With vehicle "
                + ride.getRideVehicle().getRegNo() + " to " + user.getName());
        return ride;
    }

    private static Ride selectRideService(User u, String origin, String destination, String type){

        List<Ride> specificRides = getAvailableRidesWithSourceAndDestinationForUser(u, origin, destination);

        if(specificRides.isEmpty()){
            return null;
        }

        switch (type){
            case "Fastest_Ride" :
                Collections.sort(specificRides, new FastestRide());
                return specificRides.get(0);
            case "Earliest_Ride" :
                specificRides.sort(new EarliestRide()); // List.sort and Collection.sort same :)
                return specificRides.get(0);
            default:
                return null;
        }
    }

    private static List<Ride> getAvailableRidesWithSourceAndDestinationForUser(User u, String origin, String destination) {

        List<Ride> speceficRide = new ArrayList<>();
        List<Ride> rides = rideRepository.getAllOffers();

        for(Ride ride : rides){
            if(!u.getId().equals(ride.getRideGiver().getId())
                    && ride.getOrigin().equals(origin) && ride.getDestination().equals(destination)
            && ride.getAvailableSeats() > 0){
                speceficRide.add(ride);
            }
        }

        return speceficRide;
    }

    public static void totalRidesByUser() {
        UserService.getUserRepository().
                getAllUsers().stream().forEach(
                user ->
                        System.out.println(user.getName() +" " + user.getRideTaken() + " : Taken "+ user.getRideOffered() + " : Offered"));
    }
}
