package org.state;

public class Phone {

    private State state;

    public Phone() {
        this.state = new OffState(this);
    }

    public void turnOn(){
        System.out.println("Turning screen on, device still locked");
    }

    public void setState(State state) {
        this.state = state;
    }

    public void unlock() {
        System.out.println("Unlocking the phone to home");
    }

    public void off() {
        System.out.println("turning off the screen");
    }

    public void home() {
        System.out.println("Going to home-screen");
    }

    public void lock() {
        System.out.println("Locking the phone");
    }

    public void clickHome(){
        state.onHome();
    }

    public void clickPower(){
        state.onOffOn();
    }

}
