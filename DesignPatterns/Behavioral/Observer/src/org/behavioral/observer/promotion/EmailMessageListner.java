package org.behavioral.observer.promotion;

//Concrete Implementation of Observer
public class EmailMessageListner implements Listner{

    private String email;

    public EmailMessageListner(String email){
        this.email = email;
    }
    @Override
    public void update(EventType eventType) {
        System.out.println("Sending mail to " + email + " concerning " + eventType);
    }
}
