package com.abm.moviesapi.service;

import com.abm.moviesapi.entity.Director;

import java.util.List;

public interface DirectorService {
    public List<Director> findAll();
    public Director findById(int id);
    public void save(Director director);
    public void deleteById(int id);
    List<String> getMoviesByDirector(int genreId);
}
