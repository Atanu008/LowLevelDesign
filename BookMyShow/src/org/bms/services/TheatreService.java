package org.bms.services;

import lombok.Getter;
import lombok.NonNull;
import org.bms.exceptions.NotFoundException;
import org.bms.model.Screen;
import org.bms.model.Seat;
import org.bms.model.Theatre;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Getter
public class TheatreService {

    private final Map<String, Theatre> theatres;
    private final Map<String, Screen> screens;
    private final Map<String, Seat> seats;


    public TheatreService() {
        this.theatres = new HashMap<>();
        this.screens = new HashMap<>();
        this.seats = new HashMap<>();
    }

    public Theatre createTheatre(String theaterName){
        String theatreId = UUID.randomUUID().toString();
        Theatre theatre = new Theatre(theatreId, theaterName);
        theatres.put(theatreId, theatre);
        return theatre;
    }

    public Screen createScreenInTheatre(String screenName, Theatre theatre){
        //Create Screen
        String screenId = UUID.randomUUID().toString();
        Screen screen = new Screen(screenId, screenName, theatre);
        screens.put(screenId, screen);
        //Add Screen to Theatre
        theatre.addScreen(screen);
        return screen;
    }

    public Seat createSeatInScreen(Integer rowNo, Integer seatNo, Screen screen){
        //Add Seat
        String seatId = UUID.randomUUID().toString();
        Seat seat = new Seat(seatId, rowNo, seatNo);
        seats.put(seatId, seat);
        //Add Screen to Theatre
        screen.addSeat(seat);
        return seat;
    }

    public Seat getSeat(@NonNull final String seatId) {
        if (!seats.containsKey(seatId)) {
            throw new NotFoundException();
        }
        return seats.get(seatId);
    }

    public Theatre getTheatre(@NonNull final String theatreId) {
        if (!theatres.containsKey(theatreId)) {
            throw new NotFoundException();
        }
        return theatres.get(theatreId);
    }

    public Screen getScreen(@NonNull final String screenId) {
        if (!screens.containsKey(screenId)) {
            throw new NotFoundException();
        }
        return screens.get(screenId);
    }
}
