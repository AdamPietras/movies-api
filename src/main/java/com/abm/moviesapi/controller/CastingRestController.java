package com.abm.moviesapi.controller;

import com.abm.moviesapi.entity.Casting;
import com.abm.moviesapi.service.CastingService;
import org.springframework.beans.factory.annotation.Autowired;
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
    public Casting getCasting(@PathVariable int castingId) throws Exception {
        return castingService.findById(castingId);
    }

    @PostMapping(value = "/casting", consumes = MediaType.APPLICATION_JSON_VALUE)
    public Casting addCasting(@RequestBody Casting casting) throws Exception {
        casting.setId(0);
        castingService.save(casting);
        return casting;
    }

    @PutMapping("/casting")
    public Casting updateCasting(@RequestBody Casting casting) throws Exception {
        castingService.save(casting);
        return casting;
    }

    @DeleteMapping("/casting/{castingId}")
    public String deleteCasting(@PathVariable int castingId) throws Exception {
        Casting casting = castingService.findById(castingId);
        return "Deleted casting id- " + castingId;
    }
}
