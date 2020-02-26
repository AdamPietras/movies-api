package com.abm.moviesapi.controller;

import com.abm.moviesapi.entity.Movie;
import com.abm.moviesapi.service.MovieService;
import org.hibernate.validator.constraints.Length;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

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
    public Movie getMovie(@PathVariable int movieId){
        return movieService.findById(movieId);
    }

    //POST - add new one
    @PostMapping(value = "/movies", consumes = MediaType.APPLICATION_JSON_VALUE)
    public Movie addMovie(@RequestBody Movie movie) throws Exception {
        movie.setId(0); // if it isn't here spring will be trying to update element
        movieService.save(movie);
        return movie;
    }

    //PUT update existing one
    @PutMapping("/movies")
    public Movie updateMovie(@RequestBody Movie movie) throws Exception {
        movieService.save(movie);
        return movie;
    }
    //DELETE
    @DeleteMapping("/movies/{movieId}")
    public String deleteMovie(@PathVariable int id){
        Optional<Movie> tempMovie = Optional.ofNullable(movieService.findById(id));
        if (!(tempMovie.isPresent())){
            throw new RuntimeException("There is no movie like that");
        }
        movieService.deleteById(id);
        return "Deleted movie id - " + id;
    }
}
