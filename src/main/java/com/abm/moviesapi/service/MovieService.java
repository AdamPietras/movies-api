package com.abm.moviesapi.service;

import com.abm.moviesapi.entity.Movie;

import java.util.List;

public interface MovieService {
    public List<Movie> findAll();

    public Movie findById(int id);

    public void save(Movie movie);

    public void deleteById(int id);

//    public Optional<Director> findDirectorForMovie(Movie movie);
//
//    public List<Optional<Genre>> findGenreForMovie(Movie movie);
//
//    public List<Optional<Casting>> findCastingForMovie(Movie movie);
}