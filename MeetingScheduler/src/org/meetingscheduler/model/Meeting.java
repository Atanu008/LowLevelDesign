package org.meetingscheduler.model;

import lombok.Getter;
import lombok.Setter;
import org.meetingscheduler.model.user.Attendee;
import org.meetingscheduler.model.user.Host;
import org.meetingscheduler.service.NotificationService;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Getter
@Setter
public class Meeting {

    private String id;
    private String subject;
    // Person who booked the meeting
    private Host host;
    private Interval interval;
    // This particular meeting is for which Room
    private MeetingRoom meetingRoom;
    private List<Attendee> attendeeList;

    private NotificationService notificationService;

    public Meeting(MeetingRoom meetingRoom, Host host, String subject, Interval interval){
        id = UUID.randomUUID().toString();
        this.meetingRoom = meetingRoom;
        this.host = host;
        this.subject = subject;
        this.interval = interval;
        attendeeList = new ArrayList<>();
    }

    public void addAttendees(Attendee attendee){
        this.getAttendeeList().add(attendee);
    }

    public void addAttendees(List<Attendee> attendeeList){
        this.getAttendeeList().addAll(attendeeList);
    }

    public void invite(List<Attendee> attendees) {

    }
}
