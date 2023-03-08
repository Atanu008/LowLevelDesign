package org.bms.services;

import org.bms.exceptions.NotFoundException;
import org.bms.exceptions.ScreenAlreadyOccupiedException;
import org.bms.model.Movie;
import org.bms.model.Screen;
import org.bms.model.Show;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class ShowService {

    private final Map<String, Show> shows;

    public ShowService() {
        this.shows = new HashMap<>();
    }

    public Show getShow(String showId){
        Show show = shows.get(showId);
        if(show == null){
            throw new NotFoundException();
        }
        return show;
    }

    public Show createShow(Movie movie, Screen screen, Date startTime, Integer durationInMinutes){
        if (!checkIfShowCreationAllowed(screen, startTime, durationInMinutes)) {
            throw new ScreenAlreadyOccupiedException();
        }

        String showId = UUID.randomUUID().toString();
        Show show = new Show(showId, movie, screen, startTime, durationInMinutes);
        shows.put(showId, show);
        return show;
    }



    private boolean checkIfShowCreationAllowed(final Screen screen, final Date startTime, final Integer durationInSeconds) {
        // TODO: Implement this. This method will return whether the screen is free at a particular time for
        // specific duration. This function will be helpful in checking whether the show can be scheduled in that slot
        // or not.
        return true;
    }
}
