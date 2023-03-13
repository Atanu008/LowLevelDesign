package org.decorator.notification;

//This is Decorator
public abstract class BaseNotificationDecorator implements INotifier {

    private final INotifier wrappedNotifier;
    protected final DatabaseService databaseService;

    protected BaseNotificationDecorator(INotifier wrappedNotifier) {
        this.wrappedNotifier = wrappedNotifier;
        this.databaseService = new DatabaseService();
    }

    @Override
    public void send(String message){
        wrappedNotifier.send(message);
    }

    @Override
    public String getUserName() {
        return wrappedNotifier.getUserName();
    }
}
