package com.abm.moviesapi.service;

import com.abm.moviesapi.entity.Movie;
import com.abm.moviesapi.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class MovieServiceImpl implements MovieService {
    private MovieRepository movieRepository;

    @Autowired
    public MovieServiceImpl(MovieRepository movieRepository){
        this.movieRepository = movieRepository;
    }

    @Override
    public List<Movie> findAll(){
        return movieRepository.findAll();
    }
    @Override
    public Movie findById(int id){
        Optional<Movie> result = movieRepository.findById(id);
        Movie movie = null;
        if (result.isPresent())
            movie = result.get();
        else
            throw new RuntimeException("Did not find movie with id" + id);
        return movie;
    }

    @Override
    public void save(Movie movie) {

    }

    @Override
    public void deleteById(int id) {

    }
}
