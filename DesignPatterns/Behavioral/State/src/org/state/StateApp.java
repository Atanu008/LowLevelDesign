package org.state;

//Video Reference : https://www.youtube.com/watch?v=abX4xzaAsoc

public class StateApp {
    public static void main(String[] args) {
        Phone phone = new Phone();
        phone.clickPower();
        phone.clickHome(); //called On Locekd State
        phone.clickHome(); //called on Ready State
        phone.clickPower(); //Again Off

        phone.clickHome(); // Off State
        phone.clickHome(); // Locked
        phone.clickHome(); // Ready State

    }
}
