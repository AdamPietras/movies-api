package com.abm.moviesapi.controller;

import com.abm.moviesapi.entity.Movie;
import com.abm.moviesapi.exceptions.CustomMovieException.MovieNotFoundException;
import com.abm.moviesapi.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MoviesRestController {

    private MovieService movieService;

    @Autowired
    public MoviesRestController(MovieService movieService){
        this.movieService = movieService;
    }

    //GET (all movies)
    @GetMapping("/movies")
    public List<Movie> findAll(){
        return movieService.findAll();
    }
    //GET (movie by id)
    @GetMapping("/movies/{movieId}")
    public Movie getMovie(@PathVariable int movieId) {
        Movie movie = movieService.findById(movieId);
        if (movie.getId() < 0 || movie.getId() == 0){
            throw new MovieNotFoundException();
        }
        return movie;
    }

    //POST - add new one
    @PostMapping(value = "/movies", consumes = MediaType.APPLICATION_JSON_VALUE)
    public Movie addMovie(@RequestBody Movie movie){
        movie.setId(0); // if it isn't here spring will be trying to update element
        movieService.save(movie);
        return movie;
    }

    @PutMapping("/movies")
    public Movie updateMovie(@RequestBody Movie movie){
        if (movie.getId() <= 0){
            throw new MovieNotFoundException();
        }
        movieService.save(movie);
        return movie;
    }
    //DELETE
    @DeleteMapping("/movies/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public HttpStatus deleteMovie(@PathVariable int id){
        Movie movie = movieService.findById(id);
        if (movie.getId()<=0){
            throw new MovieNotFoundException();
        }
        movieService.deleteById(id);
        return HttpStatus.NO_CONTENT;
    }
}
