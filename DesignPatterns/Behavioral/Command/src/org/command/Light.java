package org.command;

public class Light {

    private boolean switchedOn = false;

    public void switchOn(){
        System.out.println("Switching On light");
        this.switchedOn = true;
    }

    public void switchOff(){
        System.out.println("Switching Of light");
        this.switchedOn = false;
    }

    public boolean isSwitchedOn(){
        return this.switchedOn;
    }
}
