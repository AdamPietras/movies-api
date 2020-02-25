package com.abm.moviesapi.repository;

import com.abm.moviesapi.entity.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface MovieRepository extends JpaRepository<Movie, Integer> {
    //Nothing to do here <3
}
