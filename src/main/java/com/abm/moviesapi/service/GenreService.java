package com.abm.moviesapi.service;

import com.abm.moviesapi.entity.Genre;
import com.abm.moviesapi.entity.Movie;

import java.util.List;

public interface GenreService {
    public List<Genre> findAll();
    public Genre findById(int id);
    public void save(Genre genre) throws Exception;
    public void deleteById(int id);
    List<String> getMoviesByGenre(int genreId);
}
