package com.abm.moviesapi.controller;

import com.abm.moviesapi.entity.Movie;
import com.abm.moviesapi.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class MoviesRestController {

    private MovieService movieService;

    @Autowired
    public MoviesRestController(MovieService movieService){
        this.movieService = movieService;
    }

    @GetMapping("/movies")
    public List<Movie> findAll(){
        return movieService.findAll();
    }

    @GetMapping("/movies/{movieId}")
    public Movie getMovie(@PathVariable int movieId){
        return movieService.findById(movieId);
    }

}
