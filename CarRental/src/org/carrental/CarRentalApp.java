package org.carrental;


import org.carrental.model.Location;
import org.carrental.model.User;
import org.carrental.model.VehicleReservation;
import org.carrental.service.Bill;
import org.carrental.service.PaymentService;
import org.carrental.service.Store;
import org.carrental.service.UserService;

import java.time.LocalDateTime;
import java.util.*;

public class CarRentalApp {

    private Map<String, Store> stores;
    private PaymentService paymentService;
    private UserService userService;

    public CarRentalApp() {
        stores = new HashMap<>();
        paymentService = new PaymentService();
        userService = new UserService();
    }
    // User Related Services

    public void addUser(User user){
        userService.addUser(user);
    }

    public User getUser(String accountId){
        return userService.getUser(accountId);
    }

    public List<VehicleReservation> findReservationsByUser(User user) {
        return userService.findReservationsByUser(user);
    }

    // Store Related Services
    public Store addStore(Location storeLocation){
        Store store = new Store(storeLocation, userService);
        stores.put(store.getStoreId(), store);
        return store;
    }

    public Store getStore(String storeId) {
        return stores.get(storeId);
    }

    // Reservation/Booking Related APIs
    public VehicleReservation reserveVehicle(String storeId, String userId, LocalDateTime startDate, LocalDateTime endDate, String pickUpLocation, String returnLocation){
        Store store = stores.get(storeId);
        User user = getUser(userId);
        return store.reserveVehicle(user, startDate, endDate, pickUpLocation, returnLocation);
    }

    public void cancelReservation(String storeId, String reservationId){
        Store store = stores.get(storeId);
        store.cancelReservation(reservationId);
    }

    public void startTrip(String storeId, String reservationId){
        Store store = stores.get(storeId);
        store.startTrip(reservationId);
    }

    public void endTrip(String storeId, String reservationId){
        Store store = stores.get(storeId);
        store.endTrip(reservationId);
    }

    public boolean makePayment(VehicleReservation vehicleReservation){
        System.out.println("Making payment of vehicle :" + vehicleReservation.getVehicle().getVehicleID() +" \nhaving hourly cost : "+
                vehicleReservation.getVehicle().getHourlyRentalCost() +" and Daily Cost : "+ vehicleReservation.getVehicle().getDailyRentalCost()+
                " for duration from "+ vehicleReservation.getSatrtDate() +" to "+ vehicleReservation.getEndDate() +" as :::");
        Bill bill = new Bill(vehicleReservation);
        paymentService.setBill(bill);

        return paymentService.makePayment();
    }
}
