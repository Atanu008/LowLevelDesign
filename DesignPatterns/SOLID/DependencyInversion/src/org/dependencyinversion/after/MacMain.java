package org.dependencyinversion.after;

public class MacMain {
    public static void main(String[] args) {

        Keyboard keyboard = new MechanicalKeyboard();
        Monitor monitor = new LEDMonitor();
        //Now injecting concrete implementation of keyboard and monitor
        Macintosh macintosh = new Macintosh(keyboard, monitor);
    }
}
