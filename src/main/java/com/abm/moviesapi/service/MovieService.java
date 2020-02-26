package com.abm.moviesapi.service;

import com.abm.moviesapi.entity.Movie;

import java.util.List;

public interface MovieService {
    public List<Movie> findAll();
    public Movie findById(int id) throws Exception;
    public void save(Movie movie) throws Exception;
    public void deleteById(int id);
}
