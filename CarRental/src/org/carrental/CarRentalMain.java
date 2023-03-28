package org.carrental;

import org.carrental.model.Car;
import org.carrental.model.Location;
import org.carrental.model.User;
import org.carrental.model.VehicleReservation;
import org.carrental.service.Store;

import java.util.Date;

public class CarRentalMain {

    public static void main(String[] args) {
        CarRentalApp carRentalApp =  new CarRentalApp();

        User user1 =  new User("Ashok","22B Baker Street","ashok@gmail.com",587587, "1234", "drive_123", new Date());
        User user2 =  new User("Bijlani","2 Louden Street","Bijlani@gmail.com",637911, "4321", "drive_980", new Date());
        carRentalApp.addUser(user1);
        carRentalApp.addUser(user2);

        Store storeA = carRentalApp.addStore(new Location("Kolkata-South"));
        Store storeB = carRentalApp.addStore(new Location("Kolkata-North"));

        System.out.println(carRentalApp.getUser(user1.getAccountId()));
        System.out.println(carRentalApp.getStore(storeA.getStoreId()));

        Car carA = new Car(234, 1000, 2300, 5);
        Car carB = new Car(999, 1700, 3900, 5);
        Car carC = new Car(007, 1980, 890, 5);
        Car carD = new Car(456, 1590, 7980, 5);
        Car carE = new Car(789, 6980, 670, 5);

        storeA.addVehicleToStore(carA);
        storeA.addVehicleToStore(carB);
        storeA.addVehicleToStore(carE);

        storeB.addVehicleToStore(carC);
        storeB.addVehicleToStore(carD);

        VehicleReservation vehicleReservationA = storeA.reserveVehicle(user1, new Date(), new Date(), "Kolkata", "Mumbai");
        VehicleReservation vehicleReservationB = storeA.reserveVehicle(user2, new Date(), new Date(), "BNG", "Kashmir");
        VehicleReservation vehicleReservationC = storeA.reserveVehicle(user2, new Date(), new Date(), "Del", "Kol");
        // Below Reservation wont happen as three cars of storeA are booked already
        // VehicleReservation vehicleReservationD = storeA.reserveVehicle(user1, new Date(), new Date(), "NYC", "WDC");
        System.out.println(vehicleReservationA);
        carRentalApp.makePayment(vehicleReservationA); // To Do : Proper print message in make Payment

        carRentalApp.startTrip(storeA.getStoreId(), vehicleReservationA.getReservationId());
        System.out.println("Vehicle Status after Start Trip : "+vehicleReservationA.getVehicle().getVehicleStatus());
        carRentalApp.endTrip(storeA.getStoreId(), vehicleReservationA.getReservationId());

        //Trying to book again . One vehicle is available as teh last trip ended
        VehicleReservation vehicleReservationD = storeA.reserveVehicle(user1, new Date(), new Date(), "NYC", "WDC");
        System.out.println(vehicleReservationD);

        // To Do
        // Calculate Amount - Hourly , Daily
        // Proper print message in make Payment

        // Next Backlog To Do
        // ATM - Proper Prints - Mainly in Dispatch
        // BookMyShow : Main One Use Case
    }
}
