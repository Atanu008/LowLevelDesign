package org.bms.controller;

import org.bms.model.Screen;
import org.bms.model.Theatre;
import org.bms.services.TheatreService;

public class TheatreController {
    private final TheatreService theatreService;

    public TheatreController(TheatreService theatreService) {
        this.theatreService = theatreService;
    }

    public String createTheatre(String theatreName){
        return theatreService.createTheatre(theatreName).getId();
    }

    public String createScreenInTheatre(String theatreId, String screenName){
        Theatre theatre = theatreService.getTheatre(theatreId);
        return theatreService.createScreenInTheatre(screenName, theatre).getId();
    }

    public String createSeatInScreen(int rowNo, int seatNo, String scrrenId){
        Screen screen = theatreService.getScreen(scrrenId);
        return theatreService.createSeatInScreen(rowNo, seatNo, screen).getId();
    }
}
