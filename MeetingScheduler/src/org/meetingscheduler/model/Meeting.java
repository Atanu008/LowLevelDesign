package org.meetingscheduler.model;

import lombok.Getter;
import lombok.Setter;
import org.meetingscheduler.model.user.Attendee;
import org.meetingscheduler.model.user.Host;
import org.meetingscheduler.service.NotificationService;

import java.util.*;

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
    private Map<Attendee, ResponseStatus> attendeeMap;

    private NotificationService notificationService;

    public Meeting(MeetingRoom meetingRoom, Host host, String subject, Interval interval){
        id = UUID.randomUUID().toString();
        this.meetingRoom = meetingRoom;
        this.host = host;
        this.subject = subject;
        this.interval = interval;
        attendeeMap = new HashMap<>();
        notificationService = new NotificationService();
    }

    public void addAttendees(Attendee attendee){
        this.getAttendeeMap().put(attendee, ResponseStatus.NO_RESPONSE);
    }

    public void addAttendees(List<Attendee> attendeeList){
        Map<Attendee, ResponseStatus> attendeeResponseStatusMap = this.getAttendeeMap();
        //By Default set attendee status as NO_RESPONSE
        attendeeList.forEach(attendee -> attendeeMap.put(attendee, ResponseStatus.NO_RESPONSE));
    }

    public void invite(List<Attendee> attendees) {
        notificationService.sendBulkEmails(attendees, this);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Meeting meeting = (Meeting) o;
        return Objects.equals(id, meeting.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
