package org.meetingscheduler.model.user;

import lombok.Getter;
import lombok.Setter;
import org.meetingscheduler.model.Meeting;
import org.meetingscheduler.model.ResponseStatus;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Getter
@Setter
public class Attendee extends User{

    Map<Meeting, ResponseStatus> meetingResponseStatusMap;

    public Attendee(String name, String email){
        super(UUID.randomUUID().toString(), name, email);
        meetingResponseStatusMap = new HashMap<>();
    }

    public void respondInvitation(Meeting meeting, ResponseStatus responseStatus){
        // Update Meeting Status in Attendee
        this.meetingResponseStatusMap.put(meeting, responseStatus);
        // Update Attendee Response Status In Meeting
        meeting.getAttendeeMap().put(this, responseStatus);
    }

    public void addMeeting(Meeting meeting, ResponseStatus responseStatus){
        this.getMeetingResponseStatusMap().put(meeting, responseStatus);
    }
}
