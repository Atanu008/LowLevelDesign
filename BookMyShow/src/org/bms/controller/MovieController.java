package org.bms.controller;

import org.bms.services.MovieService;

public class MovieController {
    private final MovieService movieService;

    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }

    public String createMovie(String movieName){
        return movieService.createMovie(movieName).getId();
    }
}
