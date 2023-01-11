package org.meetingscheduler.app;

import org.meetingscheduler.model.Interval;
import org.meetingscheduler.model.Meeting;
import org.meetingscheduler.model.MeetingRoom;
import org.meetingscheduler.model.user.Attendee;
import org.meetingscheduler.model.user.Host;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class MeetingScheduler {

    private static volatile MeetingScheduler meetingScheduler;
    List<MeetingRoom> meetingRoomList;
    Deque<Meeting> history;
    private int MAX_HISTORICAL_MEETING_STORAGE = 10;

    private MeetingScheduler(){
        history = new LinkedList<>();
        meetingRoomList = new ArrayList<>();
    }

    public static MeetingScheduler getInstance(){
        if(meetingScheduler == null){
            synchronized (MeetingScheduler.class){
                if(meetingScheduler == null){
                    meetingScheduler = new MeetingScheduler();
                }
            }
        }
        return meetingScheduler;
    }

    public Meeting bookRoom(Host host, String subject, Interval interval){
        Meeting meeting = null;
        for(MeetingRoom meetingRoom : meetingRoomList){
            if(meetingRoom.isAvailable(interval)){
                meeting = meetingRoom.scheduleMeeting(host, subject, interval);
                saveToHistory(meeting);
            }
        }
        if(meeting == null){
            System.out.println("All Meeting rooms are booked for interval : "+ interval.getStartTime() + " - "+ interval.getEndTime());
        }
        return meeting;
    }

    public Meeting bookParticularMeetingRoom(MeetingRoom meetingRoom, Host host, String subject, Interval interval){
        Meeting meeting = null;
        if(meetingRoom.isAvailable(interval)){
            meeting = meetingRoom.scheduleMeeting(host, subject, interval);
            saveToHistory(meeting);
        }else{
            System.out.println(meetingRoom.getRoomName() +" is booked for interval : "+ interval.getStartTime() + " - "+ interval.getEndTime());
        }
        return meeting;
    }

    private void saveToHistory(Meeting meeting) {
        history.offer(meeting);
        if(history.size() > MAX_HISTORICAL_MEETING_STORAGE){
            history.removeFirst();
        }
    }

    public void addMeetingRoom(MeetingRoom meetingRoom){
        meetingRoomList.add(meetingRoom);
    }

    public void addAttendees(Meeting meeting, List<Attendee> attendees){
        if(meeting != null && attendees.size() != 0){
            meeting.addAttendees(attendees);
            meeting.invite(attendees);
        }else{
            System.out.println("Unable to add attendees to meeting : Either Meeting Invalid or Invalid Attendes");
        }

    }
}
