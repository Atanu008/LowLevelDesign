package org.decorator.notification;

//This is one Concerete Decorator
public class WhatsAppDecorator extends BaseNotificationDecorator{
    public WhatsAppDecorator(INotifier wrappedNotifier) {
        super(wrappedNotifier);
    }

    public void send(String message){
        super.send(message);
        String phNb = databaseService.getPhoneNbrFromUsername(getUserName());
        System.out.println("Sending " + message + " by WhatsApp on " + phNb);
    }
}
