package org.builder.carwithsamebuilder;

import org.builder.carwithseparatebuilder.CarBuilder;

public class CarWithBuilder {
    private int id;
    private int height;
    private String model;
    private String color;
    private String engine;
    private int noOfDoors;

    public static Builder builder(){
        return new Builder();
    }
    public static class Builder{
        private int id;
        private int height;
        private String model;
        private String color;
        private String engine;
        private int noOfDoors;

        public Builder setId(int id){
            this.id = id;
            return this;
        }

        public Builder setHeight(int height){
            this.height = height;
            return this;
        }

        public Builder setModel(String model){
            this.model = model;
            return this;
        }

        public Builder setColor(String  color){
            this.color = color;
            return this;
        }

        public Builder setEngine(String engine){
            this.engine = engine;
            return this;
        }

        public Builder setINoOfDoors(int noOfDoors){
            this.noOfDoors = noOfDoors;
            return this;
        }

        public CarWithBuilder build(){
            if(this.engine == null){
                throw new RuntimeException("Engine is Mandatory for Car");
            }

            CarWithBuilder car = new CarWithBuilder();
            car.id = id;
            car.model = model;
            car.color = color;
            car.engine = engine;
            car.noOfDoors = noOfDoors;
            car.height = height;
            return car;
        }
    }

    @Override
    public String toString() {
        return "CarWithBuilder{" +
                "id=" + id +
                ", height=" + height +
                ", model='" + model + '\'' +
                ", color='" + color + '\'' +
                ", engine='" + engine + '\'' +
                ", noOfDoors=" + noOfDoors +
                '}';
    }
}
