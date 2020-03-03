package com.abm.moviesapi.controller;

import com.abm.moviesapi.dto.CastingDTO;
import com.abm.moviesapi.entity.Casting;
import com.abm.moviesapi.service.CastingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CastingRestController {
    private CastingService castingService;

    @Autowired
    public CastingRestController(CastingService castingService){
        this.castingService=castingService;
    }

    @GetMapping("/casting")
    public List<Casting> findAll(){
        return castingService.findAll();
    }

    @GetMapping("/casting/{castingId}")
    public CastingDTO getCasting(@PathVariable int castingId){

        Casting casting = castingService.findById(castingId);
        CastingDTO castingDTO = new CastingDTO(casting.getId(), casting.getActorName(), castingService.getMoviesByCasting(castingId));
        return castingDTO;
    }

    @PostMapping(value = "/casting", consumes = MediaType.APPLICATION_JSON_VALUE)
    public Casting addCasting(@RequestBody Casting casting){
        casting.setId(0);
        castingService.save(casting);
        return casting;
    }

    @PutMapping("/casting")
    public Casting updateCasting(@RequestBody Casting casting){
        castingService.save(casting);
        return casting;
    }

    @DeleteMapping("/casting/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public HttpStatus deleteCasting(@PathVariable int id) {
        castingService.deleteById(id);
        return HttpStatus.NO_CONTENT;
    }
}
