package org.bms.controller;

import org.bms.model.Seat;
import org.bms.model.Show;
import org.bms.services.BookingService;
import org.bms.services.ShowService;
import org.bms.services.TheatreService;

import java.util.List;
import java.util.stream.Collectors;

public class BookingController {
    private final ShowService showService;
    private final BookingService bookingService;
    private final TheatreService theatreService;

    public BookingController(ShowService showService, BookingService bookingService, TheatreService theatreService) {
        this.showService = showService;
        this.bookingService = bookingService;
        this.theatreService = theatreService;
    }

    public String createBooking(String userId, String showId, List<String> seatIds){
        Show show = showService.getShow(showId);
        List<Seat> seats = seatIds.stream().map(theatreService::getSeat).collect(Collectors.toList());
        return bookingService.createBooking(userId, show, seats).getId();
    }
}
