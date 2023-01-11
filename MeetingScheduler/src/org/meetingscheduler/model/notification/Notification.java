package org.meetingscheduler.model.notification;

import org.meetingscheduler.model.Meeting;

public class Notification {

    String message = "You are invited";
    Meeting meeting;

    public Notification(Meeting meeting) {
        this.meeting = meeting;
    }
}
