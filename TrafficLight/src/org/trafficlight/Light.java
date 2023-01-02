package org.trafficlight;

import lombok.Getter;

@Getter
public class Light {

    private Color color;
    private State currentState;
    private int timeDuration;

    public Light(Color color){
        this.color = color;
        this.currentState = State.OFF; //Initially OFF
    }

    public Light(Color color, int timeDuration){
        this.color = color;
        this.currentState = State.OFF; //Initially OFF
        this.timeDuration = timeDuration;
    }

    public void turnON(){
        this.currentState = State.ON;
    }

    public void turnOFF(){
        this.currentState = State.OFF;
    }

    public boolean equals(Object object){

        if(object instanceof Color){
            return this.color == ((Light) object).color;
        }

        return false;
    }
}
