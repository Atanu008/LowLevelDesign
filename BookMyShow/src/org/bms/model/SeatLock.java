package org.bms.model;

import lombok.Getter;

import java.time.Instant;
import java.util.Date;

@Getter

public class SeatLock {
    private Seat seat;
    private Show show;
    private Integer tmeOutInSec;
    private Date lockTime;
    private String lockedBy;

    public SeatLock(Seat seat, Show show, Integer tmeOutInSec, Date lockTime, String lockedBy) {
        this.seat = seat;
        this.show = show;
        this.tmeOutInSec = tmeOutInSec;
        this.lockTime = lockTime;
        this.lockedBy = lockedBy;
    }

    public boolean isLockedExpired(){
        Instant lockInstant = lockTime.toInstant().plusSeconds(tmeOutInSec);
        Instant currentInstance = new Date().toInstant();
        return lockInstant.isBefore(currentInstance);
    }
}
