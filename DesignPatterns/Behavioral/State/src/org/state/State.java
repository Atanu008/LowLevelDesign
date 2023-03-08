package org.state;

public abstract class State {

    protected Phone phone;

    public State(Phone phone) {
        this.phone = phone;
    }

    public abstract void onHome();
    public abstract void onOffOn();
}
