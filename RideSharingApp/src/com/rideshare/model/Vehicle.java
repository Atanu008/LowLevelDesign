package com.rideshare.model;

import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public class Vehicle {

    private String id;
    private User owner;
    private String model;
    private String regNo;

    public Vehicle(User owner, String model, String regNo) {
        this.id = UUID.randomUUID().toString();
        this.owner = owner;
        this.model = model;
        this.regNo = regNo;
    }
}
