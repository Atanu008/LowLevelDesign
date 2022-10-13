package com.rideshare.service;

import com.rideshare.model.Gender;
import com.rideshare.model.User;
import com.rideshare.model.Vehicle;
import com.rideshare.repo.UserRepository;
import com.rideshare.repo.VehicleRepository;
import lombok.Getter;

public class UserService {

    @Getter
    private static UserRepository userRepository = new UserRepository();
    @Getter
    private static VehicleRepository vehicleRepository = new VehicleRepository();

    public UserService() {
    }

    public static User createUser(String name, int age, Gender gender){
        User user = new User(name, gender, age);
        userRepository.getAllUsers().add(user);
        return user;
    }

    public static Vehicle addVehicle(String owner, String model, String regNo){

        User user = getUserByName(owner);
        if(user == null)
            return null;

        Vehicle vehicle = new Vehicle(user, model, regNo);
        user.addVehicle(vehicle);
        vehicleRepository.getAllVehicles().add(vehicle);

        return vehicle;
    }

    public static User getUserByName(String name) {

       return userRepository.getAllUsers().stream()
               .filter(user -> user.getName().equals(name))
               .findFirst().orElse(null);

    }

    public static Vehicle getVehicleByRegNo(String regNo){
        return vehicleRepository.getAllVehicles().stream()
                .filter(vehicle -> vehicle.getRegNo().equals(regNo))
                .findFirst().orElse(null);
    }

    public static User getVehicleByOwnerNameAndRegNo(String ownerName, String regNo){

        Vehicle vehicle = getVehicleByRegNo(regNo);
        if(vehicle == null){
            return null;
        }

        return userRepository.getAllUsers().stream()
                .filter(user -> user.getName().equals(ownerName) && user.hasVehicle(vehicle)).findFirst().orElse(null);
    }
}
