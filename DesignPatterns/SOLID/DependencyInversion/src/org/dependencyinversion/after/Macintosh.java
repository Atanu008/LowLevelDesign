package org.dependencyinversion.after;

public class Macintosh {

    private Keyboard keyboard;
    private Monitor monitor;

    // Here we are decoupling our machine by adding a more general Keyboard/Monitor interface
    // and at runtime, inject the concrete implementation(WirelessKeyboard/MechanicalKeyboard) to the interface
    // via constructor Or via setter
    public Macintosh(Keyboard keyboard, Monitor monitor) {
        this.keyboard = keyboard;
        this.monitor = monitor;
    }

}
