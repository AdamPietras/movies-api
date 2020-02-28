package com.abm.moviesapi.controller;

import com.abm.moviesapi.dto.CastingDTO;
import com.abm.moviesapi.dto.GenreDTO;
import com.abm.moviesapi.entity.Casting;
import com.abm.moviesapi.entity.Director;
import com.abm.moviesapi.entity.Genre;
import com.abm.moviesapi.entity.Movie;
import com.abm.moviesapi.service.GenreService;
import com.abm.moviesapi.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class GenreRestController {

    private GenreService genreService;

    @Autowired
    public GenreRestController(GenreService genreService){
        this.genreService = genreService;
    }

    //GET (all genres)
    @GetMapping("/genres")
    public List<Genre> findAll(){
        return genreService.findAll();
    }

    //GET (all movies for genre id)
    @GetMapping("/genres/{genreId}")
    public GenreDTO getGenre(@PathVariable int genreId) throws Exception {

        Genre genre = genreService.findById(genreId);
        GenreDTO genreDTO = new GenreDTO(genre.getId(), genre.getName(), genreService.getMoviesByGenre(genreId));
        return genreDTO;
    }

    //POST (add genres)
    @PostMapping(value = "/genres", consumes = MediaType.APPLICATION_JSON_VALUE)
    public Genre addGenre(@RequestBody Genre genre) throws Exception {
        genre.setId(0);
        genreService.save(genre);
        return genre;
    }

    //PUT (update director)
    @PutMapping("/genres")
    public Genre updateGenre(@RequestBody Genre genre) throws Exception {
        genreService.save(genre);
        return genre;
        //TODO
    }

    //DELETE (delete Director)
    @DeleteMapping("/genres/{genreId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public HttpStatus deleteGenre(@PathVariable int genreId) throws Exception {
        genreService.deleteById(genreId);
        return HttpStatus.NO_CONTENT;
    }
}
