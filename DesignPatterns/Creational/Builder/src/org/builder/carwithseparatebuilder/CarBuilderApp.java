package org.builder.carwithseparatebuilder;

//Git : https://github.com/geekific-official/geekific-youtube/tree/main/pattern-creational-builder
//Video : https://www.youtube.com/watch?v=MaY_MDdWkQw

public class CarBuilderApp {

    public static void main(String[] args) {
        Director director = new Director();
        CarBuilder carBuilder = new CarBuilder();
        director.buildBuggati(carBuilder);
        System.out.println(carBuilder.build());

        CarBuilder lamboBuilder = new CarBuilder();
        director.buildLambo(lamboBuilder);
        System.out.println(lamboBuilder.build());
    }
}
