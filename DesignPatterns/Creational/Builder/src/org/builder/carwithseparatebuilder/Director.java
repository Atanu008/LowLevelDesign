package org.builder.carwithseparatebuilder;

public class Director {

    public void buildBuggati(CarBuilder carBuilder){
        carBuilder.setModel("Buggati")
                .setColor("Red")
                .setINoOfDoors(2)
                .setEngine("2100L")
                .setHeight(2);
    }

    public void buildLambo(CarBuilder carBuilder) {
        carBuilder.setModel("Lamborghini")
                .setColor("Yellow")
                .setHeight(120);
    }
}
