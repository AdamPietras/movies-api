package com.abm.moviesapi.service;

import com.abm.moviesapi.entity.Casting;
import com.abm.moviesapi.entity.Director;
import com.abm.moviesapi.entity.Genre;
import com.abm.moviesapi.entity.Movie;
import com.abm.moviesapi.exceptions.CustomResourceNotFoundException.ResourceNotFoundException;
import com.abm.moviesapi.repository.CastingRepository;
import com.abm.moviesapi.repository.DirectorRepository;
import com.abm.moviesapi.repository.GenreRepository;
import com.abm.moviesapi.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MovieServiceImpl implements MovieService {


    private DirectorRepository directorRepository;
    private GenreRepository genreRepository;
    private CastingRepository castingRepository;
    private MovieRepository movieRepository;

    @Autowired
    public MovieServiceImpl(MovieRepository movieRepository, DirectorRepository directorRepository, GenreRepository genreRepository, CastingRepository castingRepository){
        this.movieRepository = movieRepository;
        this.directorRepository = directorRepository;
        this.genreRepository = genreRepository;
        this.castingRepository = castingRepository;
    }

    @Override
    public List<Movie> findAll(){
        return movieRepository.findAll();
    }
    @Override
    public Movie findById(int id) {
        Movie movie = null;
        movie = movieRepository.findById(id).get();
        return movie;
    }

@Override
    public void save(Movie movie) throws ResourceNotFoundException {
            Director director = directorRepository.findByDirectorName(movie.getDirector().getDirectorName()).get();
            movie.setDirector(director);

            List<Genre> genres = new ArrayList<>();
            for (Genre genre : movie.getGenres()) {
                genres.add(genreRepository.findGenreByName(genre.getName()).get());
            }
            movie.setGenres(genres);

            List<Casting> castings = new ArrayList<>();
            for (Casting casting : movie.getCastings()) {
                castings.add(castingRepository.findByActorName(casting.getActorName()).get());
            }
            movie.setCastings(castings);

            movieRepository.save(movie);
    }

    @Override
    public void deleteById(int id) {
        movieRepository.deleteById(id);
    }
}
