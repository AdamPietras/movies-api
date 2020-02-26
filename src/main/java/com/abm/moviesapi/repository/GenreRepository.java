package com.abm.moviesapi.repository;

import com.abm.moviesapi.entity.Director;
import com.abm.moviesapi.entity.Genre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface GenreRepository extends JpaRepository<Genre, Integer> {
    Optional<Genre> findGenreByName(String name);
}
