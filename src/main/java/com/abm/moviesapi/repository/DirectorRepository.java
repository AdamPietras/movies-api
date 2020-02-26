package com.abm.moviesapi.repository;

import com.abm.moviesapi.entity.Director;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface DirectorRepository extends JpaRepository<Director, Integer> {
    Optional<Director> findByDirectorName(String name);
}
