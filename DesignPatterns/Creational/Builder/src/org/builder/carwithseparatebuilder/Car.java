package org.builder.carwithseparatebuilder;

public class Car {

    private int id;
    private int height;
    private String model;
    private String color;
    private String engine;
    private int noOfDoors;

    public Car(){

    }
    public void setId(int id) {
        this.id = id;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void setEngine(String engine) {
        this.engine = engine;
    }

    public void setNoOfDoors(int noOfDoors) {
        this.noOfDoors = noOfDoors;
    }

    @Override
    public String toString() {
        return "Car{" +
                "id=" + id +
                ", height=" + height +
                ", model='" + model + '\'' +
                ", color='" + color + '\'' +
                ", engine='" + engine + '\'' +
                ", noOfDoors=" + noOfDoors +
                '}';
    }
}
