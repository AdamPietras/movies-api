package com.abm.moviesapi.service;

import com.abm.moviesapi.entity.Movie;
import com.abm.moviesapi.exceptions.CustomMovieException.MovieNotFoundException;

import java.util.List;

public interface MovieService {
    public List<Movie> findAll();
    public Movie findById(int id) throws MovieNotFoundException;
    public void save(Movie movie) throws MovieNotFoundException;
    public void deleteById(int id) throws MovieNotFoundException;
}
