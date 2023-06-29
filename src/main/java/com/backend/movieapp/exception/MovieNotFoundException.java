package com.backend.movieapp.exception;

public class MovieNotFoundException extends RuntimeException {
    public MovieNotFoundException(Integer id) {
        super("Could Not Find The Movie with id = " + id);
    }
}
