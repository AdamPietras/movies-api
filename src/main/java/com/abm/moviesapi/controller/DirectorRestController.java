package com.abm.moviesapi.controller;

import com.abm.moviesapi.dto.DirectorDTO;
import com.abm.moviesapi.entity.Director;
import com.abm.moviesapi.entity.Genre;
import com.abm.moviesapi.service.DirectorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class DirectorRestController {

    private DirectorService directorService;

    @Autowired
    public DirectorRestController(DirectorService directorService){
        this.directorService = directorService;
    }

    //GET (all directors)
    @GetMapping("/directors")
    public List<Director> findAll(){
        return directorService.findAll();
    }

    //GET (all movies for director id)
    @GetMapping("/directors/{directorId}")
    public DirectorDTO directorDTO(@PathVariable int directorId) throws Exception {

        Director director = directorService.findById(directorId);
        DirectorDTO directorDTO= new DirectorDTO(director.getId(), director.getDirectorName(), directorService.getMoviesByDirector(directorId));
        return  directorDTO;
    }
}
