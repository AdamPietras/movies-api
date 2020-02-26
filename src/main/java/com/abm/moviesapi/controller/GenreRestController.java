package com.abm.moviesapi.controller;

import com.abm.moviesapi.entity.Genre;
import com.abm.moviesapi.entity.Movie;
import com.abm.moviesapi.service.GenreService;
import com.abm.moviesapi.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class GenreRestController {

    private GenreService genreService;

    @Autowired
    public GenreRestController(GenreService genreService){
        this.genreService = genreService;
    }

    //GET (all movies)
    @GetMapping("/genres")
    public List<Genre> findAll(){
        return genreService.findAll();
    }
}
