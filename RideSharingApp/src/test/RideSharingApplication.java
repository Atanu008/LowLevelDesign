package test;

import com.rideshare.model.Gender;
import com.rideshare.model.Ride;
import com.rideshare.model.User;
import com.rideshare.model.Vehicle;
import com.rideshare.service.RideService;
import com.rideshare.service.UserService;

import java.text.ParseException;

public class RideSharingApplication {

    public static void main(String[] args) throws ParseException {

        //create rohan
        User u1 = UserService.createUser("Rohan", 36, Gender.MALE);
        Vehicle v1 =UserService.addVehicle("Rohan","Swift","KA-01-12345");

        //create rohan
        User u2 = UserService.createUser("Shashank", 29, Gender.MALE);
        Vehicle v2 =UserService.addVehicle("Shashank","Baleno","TS-05-62395");

        //create nandani
        User u3 = UserService.createUser("Nandani", 29, Gender.FEMALE);

        //create user Shipra
        User u4 = UserService.createUser("Shipra", 27, Gender.FEMALE);
        Vehicle v4 =UserService.addVehicle("Shipra","Polo","KA-05-41491");
        Vehicle v5 = UserService.addVehicle("Shipra", "Scooty", "KA-12-12332");

        //create user Shipra
        User u5 = UserService.createUser("Gaurav", 29, Gender.MALE);

        //offer ride Rohan
        Ride r1 = RideService.offerRide("Rohan", "KA-01-12345", 1, "Hyderabad", "Bangalore", "25 Jan, 2019 08",13);
        //offer ride Shipra
        Ride r2 = RideService.offerRide("Shipra", "KA-12-12332", 1, "Bangalore", "Mysore", "29 Jan, 2019 18",10);

        //offer ride Shipra
        Ride r3 = RideService.offerRide("Shipra","KA-05-41491", 2, "Bangalore", "Mysore", "30 Jan, 2019 18",4);

        //offer ride Shashank
        Ride r4 = RideService.offerRide("Shashank", "TS-05-62395", 2, "Hyderabad", "Bangalore", "27 Jan, 2019 10",14);


        //select ride nandani
        Ride rs1 = RideService.selectRide("Nandani", "Bangalore", "Mysore", "Fastest_Ride");

        //select ride gaurav
        Ride rs2 = RideService.selectRide("Gaurav", "Bangalore", "Mysore", "Earliest_Ride");

        //select ride shashank
        Ride rs3 = RideService.selectRide("Shashank", "Mumbai", "Bangalore", "Fastest_Ride");

        //select ride Rohan
        Ride rs4= RideService.selectRide("Rohan", "Hyderabad", "Bangalore", "Fastest_Ride");

        System.out.println();
        //Find Total Rides by user
        RideService.totalRidesByUser();

    }
}
