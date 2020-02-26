package com.abm.moviesapi.service;

import com.abm.moviesapi.entity.Casting;
import com.abm.moviesapi.entity.Movie;

import java.util.List;

public interface CastingService {
    public List<Casting> findAll();
    public Casting findById(int id);
    public void save(Casting casting) throws Exception;
    public void deleteById(int id);
}
