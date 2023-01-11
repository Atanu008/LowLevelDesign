package org.meetingscheduler.model;

import lombok.Getter;
import org.meetingscheduler.model.user.Host;

import java.util.List;

@Getter
public class MeetingRoom {
    private String roomName;
    private Calendar calendar;
    private List<Interval> bookedIntervals;

    public MeetingRoom(String roomName){
        this.roomName = roomName;
        calendar = new Calendar();
    }
    public boolean isAvailable(Interval interval){
        return calendar.checkAvailability(interval);
    }

    public Meeting scheduleMeeting(Host host, String subject, Interval interval){
        return calendar.scheduleNewMeeting(this, host, subject, interval);
    }
}
