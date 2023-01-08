package org.meetingscheduler.model.user;

import org.meetingscheduler.model.notification.Notification;

import java.util.UUID;

public class Attendee extends User{

    public Attendee(String name, String email){
        super(UUID.randomUUID().toString(), name, email);
    }

    public void respondInvitation(Notification invite){

    }
}
