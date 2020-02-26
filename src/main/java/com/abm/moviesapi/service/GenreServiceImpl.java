package com.abm.moviesapi.service;

import com.abm.moviesapi.entity.Genre;
import com.abm.moviesapi.repository.CastingRepository;
import com.abm.moviesapi.repository.DirectorRepository;
import com.abm.moviesapi.repository.GenreRepository;
import com.abm.moviesapi.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GenreServiceImpl implements GenreService {

    private DirectorRepository directorRepository;
    private GenreRepository genreRepository;
    private CastingRepository castingRepository;
    private MovieRepository movieRepository;

    @Autowired
    public GenreServiceImpl(DirectorRepository directorRepository, GenreRepository genreRepository, CastingRepository castingRepository, MovieRepository movieRepository) {
        this.directorRepository = directorRepository;
        this.genreRepository = genreRepository;
        this.castingRepository = castingRepository;
        this.movieRepository = movieRepository;
    }

    @Override
    public List<Genre> findAll() {
        return null;
    }

    @Override
    public Genre findById(int id) {
        return null;
    }

    @Override
    public void save(Genre genre) throws Exception {

    }

    @Override
    public void deleteById(int id) {

    }
}
