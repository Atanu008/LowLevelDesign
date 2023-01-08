package org.meetingscheduler.model;

import lombok.Getter;

import java.util.Date;

@Getter
public class Interval {

    private Date startTime;
    private Date endTime;

    public Interval(Date startTime, Date endTime) {
        this.startTime = startTime;
        this.endTime = endTime;
    }
}
