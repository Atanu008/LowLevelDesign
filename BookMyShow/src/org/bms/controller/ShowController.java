package org.bms.controller;

import org.bms.model.Movie;
import org.bms.model.Screen;
import org.bms.model.Seat;
import org.bms.model.Show;
import org.bms.services.MovieService;
import org.bms.services.SeatAvailabilityService;
import org.bms.services.ShowService;
import org.bms.services.TheatreService;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

public class ShowController {

    private final SeatAvailabilityService seatAvailabilityService;
    private final ShowService showService;
    private final MovieService movieService;
    private final TheatreService theatreService;

    public ShowController(SeatAvailabilityService seatAvailabilityService, ShowService showService, MovieService movieService, TheatreService theatreService) {
        this.seatAvailabilityService = seatAvailabilityService;
        this.showService = showService;
        this.movieService = movieService;
        this.theatreService = theatreService;
    }

    public String createShow(String movieId, String screenId, Date startTime, Integer durationInMinutes){
        Movie movie = movieService.getMovie(movieId);
        Screen screen = theatreService.getScreen(screenId);
        return showService.createShow(movie, screen, startTime, durationInMinutes).getId();
    }

    public List<String> getAvailableSeats(String showId) {
        Show show = showService.getShow(showId);
        List<Seat> availableSeats = seatAvailabilityService.getAvailableSeats(show);
        return availableSeats.stream().map(Seat::getId).collect(Collectors.toList());
    }
}
