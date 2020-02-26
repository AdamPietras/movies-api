package com.abm.moviesapi.service;

import com.abm.moviesapi.entity.Casting;
import com.abm.moviesapi.repository.CastingRepository;
import com.abm.moviesapi.repository.DirectorRepository;
import com.abm.moviesapi.repository.GenreRepository;
import com.abm.moviesapi.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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
        return castingRepository.findAll();
    }

    @Override
    public Casting findById(int id) throws Exception {
        return castingRepository.findById(id).orElseThrow(()-> new Exception("Casting with id " + castingRepository.findById(id) + "not found"));
    }

    @Override
    public void save(Casting casting){
        castingRepository.save(casting);
    }

    @Override
    public void deleteById(int id) {
        castingRepository.deleteById(id);
    }
}
