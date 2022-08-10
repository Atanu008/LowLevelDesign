package org.behavioral.observer.promotion;

//Concrete Implementation of Observer
public class MobileAppListner implements Listner{

    private String userName;

    public MobileAppListner(String userName){
        this.userName = userName;
    }
    @Override
    public void update(EventType eventType) {
        System.out.println("Sending mobile app notification to " + userName + " concerning " + eventType);
    }
}
