package com.backend.movieapp.controller;

import com.backend.movieapp.exception.MovieNotFoundException;
import com.backend.movieapp.model.Movies;
import com.backend.movieapp.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("http://localhost:3000/")
public class MovieController {
    @Autowired
    private MovieRepository movieRepository;

    //To Insert a New Movie
    @PostMapping("/movie")
    Movies newMovie(@RequestBody Movies newMovie) {
        return movieRepository.save(newMovie);
    }

    //To Display All the Movies
    @GetMapping("/movies")
    List<Movies> getAllMovies() {
        return movieRepository.findAll();
    }

    //To Find any Movie by its movieId
    @GetMapping("/movie/{id}")
    Movies getMovieById(@PathVariable Integer id) {
        return movieRepository.findById(id)
                .orElseThrow(() -> new MovieNotFoundException(id));
    }

    //To Update any Movie by its movieId
    @PutMapping("/movie/{id}")
    Movies updateMovie(@RequestBody Movies newMovie, @PathVariable Integer id) {
        return movieRepository.findById(id)
                .map(movie -> {
                    movie.setMoviesName(newMovie.getMoviesName());
                    movie.setMoviesRating(newMovie.getMoviesRating());
                    movie.setMoviesGenre(newMovie.getMoviesGenre());

                    return movieRepository.save(movie);
                })
                .orElseThrow(() -> new MovieNotFoundException(id));
    }

    @DeleteMapping("/movie/{id}")
    String deleteMovie(@PathVariable Integer id) {
        if (!movieRepository.existsById(id)) {
            throw new MovieNotFoundException(id);
        }
        movieRepository.deleteById(id);
        return "Movie with id = " + id + " has been successfully Deleted.";
    }


}
