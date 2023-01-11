package org.meetingscheduler.service;

import org.meetingscheduler.model.Meeting;
import org.meetingscheduler.model.ResponseStatus;
import org.meetingscheduler.model.user.Attendee;

import java.util.List;

public class NotificationService {

    public void sendBulkEmails(List<Attendee> attendees, Meeting meeting){
        attendees.forEach(a -> {
            System.out.println(a.getName() +" is invited to Meeting : "+ meeting.getSubject() +" hosted by "+ meeting.getHost().getName());
            a.addMeeting(meeting, ResponseStatus.NO_RESPONSE);
        } );
    }
}
