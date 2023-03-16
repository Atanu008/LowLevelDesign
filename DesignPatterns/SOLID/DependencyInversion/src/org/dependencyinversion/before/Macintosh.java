package org.dependencyinversion.before;

public class Macintosh {

    private Keyboard keyboard;
    private Monitor monitor;

    public Macintosh() {
        // By declaring the WirelessKeyboard and LCDMonitor with the new keyword,
        // we've tightly coupled these three classes together.
        //Not only does this make our MacMachine hard to test, but we've also lost the ability
        // to switch out our LCDKeyboard class with a different one should the need arise.
        // And we're stuck with our Monitor class too.

        // One solution is to decouple our machine adding a more general Keyboard/Monitor interface
        // at runtime inject the concrete implementation(WirelessKeyboard/MechanicalKeyboard) to the interface
        // via constructor Or via setter
        // same goes for Monitor too

        keyboard = new WirelessKeyboard();
        monitor = new LCDMonitor();
    }
}
