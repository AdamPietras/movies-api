package com.abm.moviesapi.service;

import com.abm.moviesapi.entity.Casting;
import com.abm.moviesapi.repository.CastingRepository;
import com.abm.moviesapi.repository.DirectorRepository;
import com.abm.moviesapi.repository.GenreRepository;
import com.abm.moviesapi.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CastingServiceImpl implements CastingService {

    private DirectorRepository directorRepository;
    private GenreRepository genreRepository;
    private CastingRepository castingRepository;
    private MovieRepository movieRepository;

    @Autowired
    public CastingServiceImpl(DirectorRepository directorRepository, GenreRepository genreRepository, CastingRepository castingRepository, MovieRepository movieRepository) {
        this.directorRepository = directorRepository;
        this.genreRepository = genreRepository;
        this.castingRepository = castingRepository;
        this.movieRepository = movieRepository;
    }

    @Override
    public List<Casting> findAll() {
        return null;
    }

    @Override
    public Casting findById(int id) {
        return null;
    }

    @Override
    public void save(Casting casting) throws Exception {

    }

    @Override
    public void deleteById(int id) {

    }
}
