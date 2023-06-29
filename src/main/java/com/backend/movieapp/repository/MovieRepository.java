package com.backend.movieapp.repository;

import com.backend.movieapp.model.Movies;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovieRepository extends JpaRepository<Movies, Integer> {
}
