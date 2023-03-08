package org.bms.providers;

import org.bms.exceptions.SeatTemporaryUnavailableException;
import org.bms.model.Seat;
import org.bms.model.SeatLock;
import org.bms.model.Show;

import java.util.*;

public class InMemorySeatLockProviders implements SeatLockProvider{

    private final Integer lockTimeOut;
    private final Map<Show, Map<Seat, SeatLock>> locks;

    public InMemorySeatLockProviders(Integer lockTimeOut) {
        this.lockTimeOut = lockTimeOut;
        this.locks = new HashMap<>();
    }

    @Override
    public void lockSeats(Show show, List<Seat> seats, String user) {
        synchronized (this){
            for(Seat seat: seats){
                if(isSeatLocked(show, seat)){
                    throw new SeatTemporaryUnavailableException();
                }
            }

            for(Seat seat: seats){
                lockSeat(show, seat, lockTimeOut, user);
            }

        }
    }

    @Override
    public void unlockSeats(Show show, List<Seat> seats, String user) {
        for(Seat seat : seats){
            if(validateLock(show, seat, user)){
                unlockSeat(show, seat);
            }
        }
    }


    @Override
    public boolean validateLock(Show show, Seat seat, String user) {
        //Check if lock present and locked by same user
        return isSeatLocked(show, seat) && locks.get(show).get(seat).getLockedBy().equals(user);
    }

    @Override
    public List<Seat> getLockedSeats(Show show) {
        if(!locks.containsKey(show)){
            return List.of(); // new ArrayList<>();
        }

        List<Seat> lockedSeats = new ArrayList<>();
        for(Seat seat : locks.get(show).keySet()){
            if(isSeatLocked(show, seat)){
                lockedSeats.add(seat);
            }
        }
        return lockedSeats;
    }

    private void unlockSeat(Show show, Seat seat) {
        if(!locks.containsKey(show)){
            return;
        }
        locks.get(show).remove(seat);
    }

    private void lockSeat(Show show, Seat seat, Integer lockTimeOut, String user) {
        locks.putIfAbsent(show, new HashMap<>());
        SeatLock seatLock = new SeatLock(seat, show, lockTimeOut, new Date(), user);
        locks.get(show).put(seat, seatLock);
    }

    private boolean isSeatLocked(Show show, Seat seat) {
        return locks.containsKey(show) && locks.get(show).containsKey(seat) && !locks.get(show).get(seat).isLockedExpired();
    }
}
