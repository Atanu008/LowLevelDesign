package com.rideshare.model;

import lombok.Getter;
import lombok.Setter;

import java.util.*;

@Getter
@Setter
public class User {

    private String id;
    private String name;
    private Gender gender;
    private int age;
    private Set<Vehicle> vehicles;
    private int rideTaken;
    private int rideOffered;

    public User(String name, Gender gender, int age){
        id = UUID.randomUUID().toString();
        this.name = name;
        this.gender = gender;
        this.age = age;
        vehicles = new HashSet<>();
        rideTaken = 0;
        rideOffered = 0;
    }

    public boolean hasVehicle(Vehicle vehicle){
       return this.vehicles.contains(vehicle);
    }

    public int getNumberOfVehicles(){
        return this.vehicles.size();
    }

    public void addVehicle(Vehicle vehicle){
        this.getVehicles().add(vehicle);
    }
}
