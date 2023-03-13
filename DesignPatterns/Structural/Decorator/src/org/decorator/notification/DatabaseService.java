package org.decorator.notification;

public class DatabaseService {
    public String getMailFromUsername(String userName){
        return userName + "@mail";
    }

    public String getPhoneNbrFromUsername(String userName){
        return userName + "@phone";
    }

    public String getFBNameFromUsername(String userName){
        return userName + "@facebook";
    }
}
