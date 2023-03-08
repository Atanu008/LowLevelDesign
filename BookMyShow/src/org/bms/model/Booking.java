package org.bms.model;

import lombok.Getter;
import lombok.Setter;
import org.bms.exceptions.InvalidStateException;

import java.util.List;

@Getter
@Setter
public class Booking {
    private final String id;
    private final String user;
    private final Show show;
    private final List<Seat> seatsBooked;
    private BookingStatus bookingStatus; // Is not final as it would change throughput the cycle


    public Booking(String id, String user, Show show, List<Seat> seatsBooked) {
        this.id = id;
        this.user = user;
        this.show = show;
        this.seatsBooked = seatsBooked;
        bookingStatus = BookingStatus.Created;
    }

    public boolean isConfirmed(){
        return this.bookingStatus == BookingStatus.Confirmed;
    }

    public void confirmBooking(){
        if(this.bookingStatus != BookingStatus.Created){
            throw new InvalidStateException();
        }
    }
}
