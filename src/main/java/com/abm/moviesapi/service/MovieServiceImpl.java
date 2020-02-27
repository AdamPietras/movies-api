package com.abm.moviesapi.service;

import com.abm.moviesapi.entity.Casting;
import com.abm.moviesapi.entity.Director;
import com.abm.moviesapi.entity.Genre;
import com.abm.moviesapi.entity.Movie;
import com.abm.moviesapi.exceptions.CustomCastingException.CastingNotFoundException;
import com.abm.moviesapi.exceptions.CustomMovieException.MovieNotFoundException;
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
        try {
            movie = movieRepository.findById(id).orElseThrow(()->new MovieNotFoundException("Movie with id" + id + "not found"));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return movie;
    }

    @Override
    public void save(Movie movie) throws MovieNotFoundException {
        try {
            Director director = directorRepository.findByDirectorName(movie.getDirector().getDirectorName()).orElseThrow(() -> new Exception("Director with name " + movie.getDirector().getDirectorName() + " NOT found"));
            movie.setDirector(director);

            List<Genre> genres = new ArrayList<>();
            for (Genre genre : movie.getGenres()) {
                genres.add(genreRepository.findGenreByName(genre.getName()).orElseThrow(() -> new Exception("Genre with name " + movie.getGenres().toString() + " NOT found")));
            }
            movie.setGenres(genres);

            List<Casting> castings = new ArrayList<>();
            for (Casting casting : movie.getCastings()) {
                castings.add(castingRepository.findByActorName(casting.getActorName()).orElseThrow(() -> new CastingNotFoundException("Casting with name " + casting.getActorName() + " NOT found")));
            }
            movie.setCastings(castings);

            movieRepository.save(movie);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public void deleteById(int id) throws MovieNotFoundException {
        movieRepository.deleteById(id);
    }
}
