package com.backend.movieapp.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Movies {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer moviesId;
    private String moviesName;
    private Integer moviesRating;
    private String moviesGenre;

    public Integer getMoviesId() {
        return moviesId;
    }

    public void setMoviesId(Integer moviesId) {
        this.moviesId = moviesId;
    }

    public String getMoviesName() {
        return moviesName;
    }

    public void setMoviesName(String moviesName) {
        this.moviesName = moviesName;
    }

    public Integer getMoviesRating() {
        return moviesRating;
    }

    public void setMoviesRating(Integer moviesRating) {
        this.moviesRating = moviesRating;
    }

    public String getMoviesGenre() {
        return moviesGenre;
    }

    public void setMoviesGenre(String moviesGenre) {
        this.moviesGenre = moviesGenre;
    }

    @Override
    public String toString() {
        return "Movies{" +
                "moviesId=" + moviesId +
                ", moviesName='" + moviesName + '\'' +
                ", moviesRating=" + moviesRating +
                ", moviesGenre='" + moviesGenre + '\'' +
                '}';
    }
}
