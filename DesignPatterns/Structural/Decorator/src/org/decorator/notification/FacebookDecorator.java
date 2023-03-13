package org.decorator.notification;

//This is one Concerete Decorator
public class FacebookDecorator extends BaseNotificationDecorator{
    public FacebookDecorator(INotifier wrappedNotifier) {
        super(wrappedNotifier);
    }

    public void send(String message){
        super.send(message);
        String fbName = databaseService.getFBNameFromUsername(getUserName());
        System.out.println("Sending " + message + " on Facebook to " + fbName);
    }
}
