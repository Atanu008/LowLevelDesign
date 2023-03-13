package org.decorator.notification;

//This one of the Concrete Component
public class MessageNotifier implements INotifier{

    private final String username;
    private final DatabaseService databaseService;

    public MessageNotifier(String username) {
        this.username = username;
        this.databaseService = new DatabaseService();
    }

    @Override
    public void send(String message) {
        String mail = databaseService.getPhoneNbrFromUsername(username);
        System.out.println("Sending " + message + " by Phone message to " + mail);
    }

    @Override
    public String getUserName() {
        return this.username;
    }
}
