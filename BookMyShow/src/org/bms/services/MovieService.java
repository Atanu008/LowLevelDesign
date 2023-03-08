package org.bms.services;

import lombok.NonNull;
import org.bms.exceptions.NotFoundException;
import org.bms.model.Movie;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class MovieService {

    private final Map<String, Movie> movies;

    public MovieService() {
        this.movies = new HashMap<>();
    }

    public Movie getMovie(@NonNull final String movieId){
        Movie movie = movies.get(movieId);
        if(movie == null){
            throw new NotFoundException();
        }
        return movie;
    }

    public Movie createMovie(@NonNull final String movieName){
        String movieId = UUID.randomUUID().toString();
        Movie movie = new Movie(movieId, movieName);
        movies.put(movieId, movie);
        return movie;
    }
}
