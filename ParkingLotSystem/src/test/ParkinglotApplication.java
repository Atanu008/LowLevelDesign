package test;

import org.lld.parkinglot.model.account.Account;
import org.lld.parkinglot.model.account.Admin;
import org.lld.parkinglot.model.parking.*;
import org.lld.parkinglot.model.vehicle.Car;
import org.lld.parkinglot.model.vehicle.Motorbike;
import org.lld.parkinglot.model.vehicle.Vehicle;
import org.lld.parkinglot.model.vehicle.VehicleType;

import java.util.UUID;

public class ParkinglotApplication {

    public static void main(String[] args) throws Exception{

        ParkingLot parkingLot = ParkingLot.getInstance();
        Address address = new Address();
        address.setAddressLine1("Rainbow Complex");
        address.setStreet("BG Road");
        address.setCity("Kolkata");
        address.setState("West Bengal");
        address.setCountry("India");
        address.setPinCode("700052");

        parkingLot.setAddress(address);

        //Admin tests
        Account adminAccount = new Admin();
        //Admin Case 1 - should be able to add parking floor case
        ((Admin)adminAccount).addParkingFloor(new ParkingFloor("1"));
        //Admin Case 2 - should be able to add parking floor case
        ((Admin) adminAccount).addParkingFloor(new ParkingFloor("2"));

        //Admin Case 3 - should be able to add entrance panel
        EntrancePanel entrancePanel = new EntrancePanel("1");
        ((Admin) adminAccount).addEntrancePanel(entrancePanel);

        //Admin Case 4 - should be able to add exit panel
        ExitPanel exitPanel = new ExitPanel("1");
        ((Admin) adminAccount).addExitPanel(exitPanel);

        String floorId = parkingLot.getParkingFloors().get(0).getFloorId();

        //Admin case 5 - should be able to add car parking spot
        ParkingSpot carSpot = new CarParkingSpot("c1");
        ((Admin)adminAccount).addParkingSpot(floorId, carSpot);
        //Admin case 6 - should be able to add bike parking spot
        ParkingSpot bikeSpot = new MotorBikeParkingSpot("b1");
        ((Admin)adminAccount).addParkingSpot(floorId, bikeSpot);
        ///Admin case 7 - should be able to add car parking spot
        ParkingSpot carSpot2 = new CarParkingSpot("c2");
        ((Admin) adminAccount).addParkingSpot(floorId, carSpot2);

        // Test case 1 - check for availability of parking lot - TRUE
        System.out.println(parkingLot.canPark(VehicleType.CAR));

        // Test case 2 - check for availability of parking lot - FALSE
        System.out.println(parkingLot.canPark(VehicleType.ELECTRIC));

        // Test case 3 - check for availability of parking lot - TRUE
        System.out.println(parkingLot.canPark(VehicleType.MOTORBIKE));
        // TEST case 4 - Check if full
        System.out.println(parkingLot.isFull());

        // Test case - 5 - Should be able to get parking ticket
        Vehicle car = new Car("WB109789");
        ParkingTicket parkingTicket = entrancePanel.getParkingTicket(car);
        System.out.println(parkingTicket.getAllocatedSpotId());

        // Test case 10 - Should not be able to get ticket
        ParkingTicket tkt = entrancePanel.getParkingTicket(new Car("ka04rb8458"));
        System.out.println(tkt.getAllocatedSpotId());


        //Now Car its Full
        //Will NOt be able to parkCar
        //This will throw an Exception as there is no parking spot available
        //ParkingTicket carTicket = entrancePanel.getParkingTicket(new Car("WB2377"));
        // Test case 12 - Should be able to get ticket
        ParkingTicket mtrTkt = entrancePanel.getParkingTicket(new Motorbike("ka01ee4901"));
        System.out.println(mtrTkt.getAllocatedSpotId());

        mtrTkt = exitPanel.scanAndVacate(mtrTkt);
        System.out.println("Motor Charges "+ mtrTkt.getCharges());

        // Test case 13 - park on vacated spot
        ParkingTicket mtrTkt1 = entrancePanel.getParkingTicket(new Motorbike("ka01ee7791"));
        System.out.println(mtrTkt.getAllocatedSpotId());

        // Test cast 15 - vacate car
        parkingTicket = exitPanel.scanAndVacate(parkingTicket);
        System.out.println(parkingTicket.getCharges());

        //Test case 18 - check for slots count
        System.out.println(parkingLot.getParkingFloors().get(0).getParkingSpots().get(ParkingSpotType.CAR).size());

        Payment payment = new Payment(UUID.randomUUID().toString(),
                parkingTicket.getTicketNumber(), parkingTicket.getCharges());
        payment.makePayment();
        System.out.println(payment.getPaymentStatus());
    }
}
