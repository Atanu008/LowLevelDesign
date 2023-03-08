package org.state;

//In Lock State by clicking on the Home button would make the phone in Ready state
// And By clicking on power button/OffOn button would make the phone in OffState again
public class LockedState extends State {
    public LockedState(Phone phone) {
        super(phone);
    }

    @Override
    public void onHome() {
        phone.unlock();
        phone.setState(new ReadyState(phone));
    }

    @Override
    public void onOffOn() {
        phone.off();
        phone.setState(new OffState(phone));
    }
}
