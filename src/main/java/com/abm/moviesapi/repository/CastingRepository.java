package com.abm.moviesapi.repository;

import com.abm.moviesapi.entity.Casting;
import com.abm.moviesapi.entity.Director;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CastingRepository extends JpaRepository<Casting, Integer> {
    Optional<Casting> findByActorName(String name);
}
