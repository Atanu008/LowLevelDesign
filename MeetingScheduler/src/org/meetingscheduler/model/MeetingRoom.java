package org.meetingscheduler.model;

import org.meetingscheduler.model.user.Host;

import java.util.List;

public class MeetingRoom {
    private String roomName;
    private Calendar calendar;
    private List<Interval> bookedIntervals;

    public boolean isAvailable(Interval interval){
        return calendar.checkAvailability(interval);
    }

    public Meeting scheduleMeeting(Host host, String subject, Interval interval){
        return calendar.scheduleNewMeeting(this, host, subject, interval);
    }
}
