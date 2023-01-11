package org.meetingscheduler;

import org.meetingscheduler.app.MeetingScheduler;
import org.meetingscheduler.model.Interval;
import org.meetingscheduler.model.Meeting;
import org.meetingscheduler.model.MeetingRoom;
import org.meetingscheduler.model.ResponseStatus;
import org.meetingscheduler.model.user.Attendee;
import org.meetingscheduler.model.user.Host;

import java.util.Arrays;
import java.util.Date;

public class MeetingSchedulerApp {

    public static void main(String[] args) {

        Host host1 = new Host("Host1","host1@gmail.com");
        Host host2 = new Host("Host2","host2@gmail.com");

        Attendee attendee1 = new Attendee("Attendee1","attendee1@gmail.com");
        Attendee attendee2 = new Attendee("Attendee2","attendee2@gmail.com");
        Attendee attendee3 = new Attendee("Attendee3","attendee3@gmail.com");
        Attendee attendee4 = new Attendee("Attendee4","attendee4@gmail.com");

        MeetingRoom meetingRoom1 = new MeetingRoom("MeetingRoom1");
        MeetingRoom meetingRoom2 = new MeetingRoom("MeetingRoom2");
        MeetingRoom meetingRoom3 = new MeetingRoom("MeetingRoom3");

        MeetingScheduler meetingScheduler = MeetingScheduler.getInstance();

        meetingScheduler.addMeetingRoom(meetingRoom1);
        meetingScheduler.addMeetingRoom(meetingRoom2);
        meetingScheduler.addMeetingRoom(meetingRoom3);

        Date startDate = new Date(System.currentTimeMillis());
        Date endDate = new Date(System.currentTimeMillis()+60*10000);
        Meeting meet1 = meetingScheduler.bookRoom(host1, "First Meeting", new Interval(startDate, endDate) );
        meetingScheduler.addAttendees(meet1, Arrays.asList(attendee1, attendee3));

        // Unable to create another meeting with same interval as Meet1
        Meeting meet2 = meetingScheduler.bookParticularMeetingRoom(meet1.getMeetingRoom(), host1, "Second Meeting",new Interval(startDate, endDate));
        meetingScheduler.addAttendees(meet2, Arrays.asList(attendee2, attendee3));


        // Attenndee1 respond to meeting
        attendee1.respondInvitation(meet1,ResponseStatus.ACCEPTED);
        // check attendee response status in Meeting
        System.out.println(attendee1.getName() +"'s response to Meeting - "+ meet1.getSubject() + " : "+ meet1.getAttendeeMap().get(attendee1));
        // check meeting response status in AttendeeMeetingResponse Map
        System.out.println(attendee1.getName() +" responded to Meeting - "+ meet1.getSubject() + " : "+ attendee1.getMeetingResponseStatusMap().get(meet1));
    }
}
