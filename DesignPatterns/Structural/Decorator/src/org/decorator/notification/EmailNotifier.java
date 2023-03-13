package org.decorator.notification;

//This one of the Concrete Component
public class EmailNotifier implements INotifier{

    private final String username;
    private final DatabaseService databaseService;

    public EmailNotifier(String username) {
        this.username = username;
        this.databaseService = new DatabaseService();
    }

    @Override
    public void send(String message) {
        String mail = databaseService.getMailFromUsername(username);
        System.out.println("Sending " + message + " by Mail to " + mail);
    }

    @Override
    public String getUserName() {
        return this.username;
    }
}
