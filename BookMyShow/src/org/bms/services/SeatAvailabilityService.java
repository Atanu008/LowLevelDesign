package org.bms.services;

import org.bms.model.Seat;
import org.bms.model.Show;
import org.bms.providers.SeatLockProvider;

import java.util.List;

public class SeatAvailabilityService {

    private final BookingService bookingService;
    private final SeatLockProvider seatLockProvider;

    public SeatAvailabilityService(BookingService bookingService, SeatLockProvider seatLockProvider) {
        this.bookingService = bookingService;
        this.seatLockProvider = seatLockProvider;
    }

    public List<Seat> getAvailableSeats(Show show){
        List<Seat> allSeats = show.getScreen().getSeats();
        List<Seat> allBookedAndLockedSeats = getAllBookedAndLockedSeats(show);
        allSeats.removeAll(allBookedAndLockedSeats); // Remove unavailable seats
        return allSeats; // Now allSeats have only available seats
    }

    private List<Seat> getAllBookedAndLockedSeats(Show show) {

        List<Seat> bookedSeats = bookingService.getBookedSeats(show);
        List<Seat> lockedSeats = seatLockProvider.getLockedSeats(show);
        bookedSeats.addAll(lockedSeats);
        return bookedSeats; // We need to return booked and locked seats
    }
}
