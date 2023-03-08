package org.bms.services;

import org.bms.exceptions.BadRequestException;
import org.bms.exceptions.NotFoundException;
import org.bms.exceptions.SeatPermanentlyUnavailableException;
import org.bms.model.Booking;
import org.bms.model.Seat;
import org.bms.model.Show;
import org.bms.providers.SeatLockProvider;

import java.util.*;
import java.util.stream.Collectors;

public class BookingService {

    private Map<String, Booking> showBooking;
    private SeatLockProvider seatLockProvider;

    public BookingService(SeatLockProvider seatLockProvider) {
        this.seatLockProvider = seatLockProvider;
        showBooking = new HashMap<>();
    }

    public Booking getBooking(String bookingId){
        if(!showBooking.containsKey(bookingId)){
            throw new NotFoundException();
        }
        return showBooking.get(bookingId);
    }

    public List<Booking> getAllBookings(Show show){
        List<Booking> bookings = new ArrayList<>();
        for(Booking booking : showBooking.values()){
            if(booking.getShow().equals(show)){
                bookings.add(booking);
            }
        }
        return bookings;
    }

    public Booking createBooking(String userId, Show show, List<Seat> seats){

        if(anySeatAlreadyBooked(show, seats)){
            throw new SeatPermanentlyUnavailableException();
        }
        seatLockProvider.lockSeats(show,seats,userId);
        String bookingId = UUID.randomUUID().toString();
        Booking newBooking = new Booking(bookingId, userId, show, seats);
        showBooking.put(bookingId, newBooking);
        return newBooking;
    }

    public void confirmBooking(Booking booking, String  user){
        if (!booking.getUser().equals(user)) {
            throw new BadRequestException();
        }

        for(Seat seat : booking.getSeatsBooked()){
            if(!seatLockProvider.validateLock(booking.getShow(), seat, user)){
                throw new BadRequestException();
            }
        }

        booking.confirmBooking();
    }

    private boolean anySeatAlreadyBooked(Show show, List<Seat> seats) {
        List<Seat> bookedSeats = getBookedSeats(show); // may be can do with set to reduce time complexity
        for(Seat seat : seats){
            if(bookedSeats.contains(seat)){
                return false;
            }
        }
        return true;
    }

    public List<Seat> getBookedSeats(Show show) {
        return getAllBookings(show).stream()
                .filter(Booking::isConfirmed)
                .map(Booking::getSeatsBooked)
                .flatMap(Collection::stream)
                .collect(Collectors.toList());
    }
}
