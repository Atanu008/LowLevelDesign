package org.builder.carwithsamebuilder;

//Git : https://github.com/anomaly2104/coding-recipies/tree/master/src/main/java/com/uditagarwal/builder_pattern
//video : https://www.youtube.com/watch?v=6Wi2XZeAf-Q
public class CarBuilderApp {


    public static void main(String[] args) {

        //Reasons to why Use Builder to Create Object :

        //Why Not Constructor :
        /**
         * Constructor
         * 1. So many nulls you will to put.
         * 2. Makes constructor ugly.
         */

        //Why Not Setters
        /**
         * Setters
         * 1. You can make half baked object by missing required properties.
         * 2. Object becomes mutable. You can change its properties even after its construction.
         */
        // We forgot to set required properties like engine in Car

        //How Builder solves the problem ?
        /**
         * Using builders
         * 1. Simple construction.
         * 2. Looks clean. More Readable
         * 3. Object remains immutable once it is build.
         */
        //Cons : Redundant code for setters for  Builder and model as they share same properties.

        CarWithBuilder carWithBuilder = CarWithBuilder.builder()
                .setModel("Buggati")
                .setColor("Red")
                .setINoOfDoors(2)
                .setEngine("2100L")
                .setHeight(2).build();
        System.out.println(carWithBuilder);

        CarWithBuilder carWithBuilder_2 = CarWithBuilder.builder()
                .setModel("Buggati")
                .setColor("Red")
                .setINoOfDoors(2)
                //.setEngine("2100L")
                .setHeight(2).build();
        System.out.println(carWithBuilder_2);
    }
}
