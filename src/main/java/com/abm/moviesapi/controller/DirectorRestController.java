package com.abm.moviesapi.controller;

import com.abm.moviesapi.entity.Director;
import com.abm.moviesapi.service.DirectorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class DirectorRestController {
    private DirectorService directorService;

    @Autowired public DirectorRestController(DirectorService directorService){
        this.directorService=directorService;
    }

    @GetMapping("/directors")
    public List<Director> findAll(){
        return directorService.findAll();
    }

    @GetMapping("/directors/{id}")
    public Director getDirector(@PathVariable int id) throws Exception {
        return directorService.findById(id);
    }

    @PostMapping(value = "/directors", consumes = MediaType.APPLICATION_JSON_VALUE)
    public Director addDirector(@RequestBody Director director){
        try {
            director.setId(0);
            directorService.save(director);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return director;
    }

    @PutMapping("/directors")
    public Director updateDirector(@RequestBody Director director){
        try {
            directorService.save(director);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return director;
    }

    @DeleteMapping("/directors/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public HttpStatus deleteDirector(@PathVariable int id){
        directorService.deleteById(id);
        return HttpStatus.NO_CONTENT;
    }
}
