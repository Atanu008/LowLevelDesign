package org.builder.carwithseparatebuilder;

public class CarBuilder {
    private int id;
    private int height;
    private String model;
    private String color;
    private String engine;
    private int noOfDoors;

    public CarBuilder setId(int id){
        this.id = id;
        return this;
    }

    public CarBuilder setHeight(int height){
        this.height = height;
        return this;
    }

    public CarBuilder setModel(String model){
        this.model = model;
        return this;
    }

    public CarBuilder setColor(String  color){
        this.color = color;
        return this;
    }

    public CarBuilder setEngine(String engine){
        this.engine = engine;
        return this;
    }

    public CarBuilder setINoOfDoors(int noOfDoors){
        this.noOfDoors = noOfDoors;
        return this;
    }

    public Car build(){
        if(this.engine == null){
            throw new RuntimeException("Engine is Mandatory for Car");
        }
        Car car = new Car();
        car.setId(this.id);
        car.setColor(this.color);
        car.setModel(this.model);
        car.setHeight(this.height);
        car.setEngine(this.engine);
        car.setNoOfDoors(this.noOfDoors);
        return car;
    }
}
