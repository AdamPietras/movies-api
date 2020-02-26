package com.abm.moviesapi.service;

import com.abm.moviesapi.entity.Casting;
import com.abm.moviesapi.entity.Movie;

import java.util.List;

public interface CastingService {
    public List<Casting> findAll();
    public Casting findById(int id) throws Exception;
    public void save(Casting casting);
    public void deleteById(int id);

    List<String> getMoviesByCasting(int castingId);
}
