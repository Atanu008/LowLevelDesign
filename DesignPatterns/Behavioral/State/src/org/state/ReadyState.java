package org.state;

//Once the phone is in Ready state , by clicking the home button would show the app/home screen
//BUt there would be no state transition, will still be in ReadySate
//But if we click on OffOn button phone will be moved OffState
public class ReadyState extends State {
    public ReadyState(Phone phone) {
        super(phone);
    }

    @Override
    public void onHome() {
        phone.home();

    }

    @Override
    public void onOffOn() {
        phone.lock();
        phone.off();
        phone.setState(new OffState(phone));
    }
}
