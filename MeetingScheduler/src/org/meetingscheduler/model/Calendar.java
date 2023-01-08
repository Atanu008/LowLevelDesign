package org.meetingscheduler.model;

import org.meetingscheduler.model.user.Host;

import java.util.ArrayList;
import java.util.List;

public class Calendar {

    // Every Calendar is having List of Meetings
    List<Meeting> meetingList;

    public Calendar() {
        this.meetingList = new ArrayList<>();
    }

    public boolean checkAvailability(Interval interval) {
        for(Meeting meeting : meetingList){
            //Check for overlaps
            //Start Time of meeting interval is less than endTime of existing meeting
            // And Ent Time of meeting interval is greater than startTime of existing meeting then its a overlap
            //in that case return false
            if(meeting.getInterval().getEndTime().compareTo(interval.getStartTime()) > 0 && meeting.getInterval().getStartTime().compareTo(interval.getEndTime()) < 0){
                return false;
            }
        }
        return true;
    }

    public Meeting scheduleNewMeeting(MeetingRoom meetingRoom , Host host, String subject, Interval interval) {
        Meeting meeting = new Meeting(meetingRoom, host, subject, interval);
        meetingList.add(meeting);
        return meeting;
    }
}
