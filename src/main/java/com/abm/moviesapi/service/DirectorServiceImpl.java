package com.abm.moviesapi.service;

import com.abm.moviesapi.entity.Director;
import com.abm.moviesapi.exceptions.CustomDirectorException.DirectorNotFoundException;
import com.abm.moviesapi.repository.CastingRepository;
import com.abm.moviesapi.repository.DirectorRepository;
import com.abm.moviesapi.repository.GenreRepository;
import com.abm.moviesapi.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Service
public class DirectorServiceImpl implements DirectorService {

    private DirectorRepository directorRepository;
    private GenreRepository genreRepository;
    private CastingRepository castingRepository;
    private MovieRepository movieRepository;

    @PersistenceContext
    EntityManager entityManager;

    @Autowired
    public DirectorServiceImpl(DirectorRepository directorRepository, GenreRepository genreRepository, CastingRepository castingRepository, MovieRepository movieRepository) {
        this.directorRepository = directorRepository;
        this.genreRepository = genreRepository;
        this.castingRepository = castingRepository;
        this.movieRepository = movieRepository;
    }

    @Override
    public List<Director> findAll() {
        return directorRepository.findAll();
    }

    @Override
    public Director findById(int id) throws Exception {
        return directorRepository.findById(id).orElseThrow(()->new Exception("Director with id" + id + " not found"));
    }

    @Override
    public void save(Director director) throws Exception {
        directorRepository.save(director);
    }

    @Override
    public void deleteById(int id) throws Exception {
        Director director = directorRepository.findById(id).orElseThrow(()-> new Exception("Director with id" + id + " not found"));
        directorRepository.deleteById(director.getId());
    }

    @Override
    public List<String> getMoviesByDirector(int directorId) {
        Query query = entityManager.createNativeQuery("select m.title from director as d join movie as m on d.id = m.director_id where d.id = ?");
        query.setParameter(1, directorId);
        List<String> titleList = query.getResultList();
        return titleList;
    }
}
