package org.state;

//Phone will be in Off state initially
//Old Phones used to have Two buttons : Home Button and Power Button
//By clicking on Both Buttons it used to open the lock screen. The phone is still locked
//Now we are assuming no password is set .
public class OffState extends State{

    public OffState(Phone phone) {
        super(phone);
    }

    @Override
    public void onHome() {
        phone.turnOn();
        phone.setState(new LockedState(phone));
    }

    @Override
    public void onOffOn() {
        phone.turnOn();
        phone.setState(new LockedState(phone));
    }
}
