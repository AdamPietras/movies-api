package com.abm.moviesapi.controller;

import com.abm.moviesapi.dto.DirectorDTO;
import com.abm.moviesapi.entity.Casting;
import com.abm.moviesapi.entity.Director;
import com.abm.moviesapi.entity.Genre;
import com.abm.moviesapi.service.DirectorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

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

    //POST (add director)
    @PostMapping(value = "/directors", consumes = MediaType.APPLICATION_JSON_VALUE)
    public Director addDirector(@RequestBody Director director) throws Exception {
        director.setId(0);
        directorService.save(director);
        return director;
    }

    //PUT (update director)
    @PutMapping("/directors")
    public Director updateDirector(@RequestBody Director director) throws Exception {
        directorService.save(director);
        return director;
        //TODO
    }

    //DELETE (delete Director)
    @DeleteMapping("/directors/{directorId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public HttpStatus deleteDirector(@PathVariable int directorId) throws Exception {
        directorService.deleteById(directorId);
        return HttpStatus.NO_CONTENT;
    }
}
