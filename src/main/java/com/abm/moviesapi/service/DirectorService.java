package com.abm.moviesapi.service;

import com.abm.moviesapi.entity.Director;
import com.abm.moviesapi.entity.Movie;

import java.util.List;

public interface DirectorService {
    public List<Director> findAll();
    public Director findById(int id) throws Exception;
    public void save(Director director) throws Exception;
    public void deleteById(int id) throws Exception;

    List<String> getMoviesByDirector(int genreId);
}
