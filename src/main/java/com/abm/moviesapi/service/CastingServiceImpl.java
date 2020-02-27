package com.abm.moviesapi.service;

import com.abm.moviesapi.entity.Casting;
import com.abm.moviesapi.exceptions.CustomCastingException.CastingNotFoundException;
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
public class CastingServiceImpl implements CastingService {

    private DirectorRepository directorRepository;
    private GenreRepository genreRepository;
    private CastingRepository castingRepository;
    private MovieRepository movieRepository;

    @PersistenceContext
    EntityManager entityManager;


    @Autowired
    public CastingServiceImpl(DirectorRepository directorRepository, GenreRepository genreRepository, CastingRepository castingRepository, MovieRepository movieRepository) {
        this.directorRepository = directorRepository;
        this.genreRepository = genreRepository;
        this.castingRepository = castingRepository;
        this.movieRepository = movieRepository;
    }

    @Override
    public List<Casting> findAll() {
        return castingRepository.findAll();
    }

    @Override
    public Casting findById(int id) throws CastingNotFoundException {
        return castingRepository.findById(id).orElseThrow(()-> new CastingNotFoundException("Casting with id " + castingRepository.findById(id) + "not found"));
    }

    @Override
    public void save(Casting casting){
        castingRepository.save(casting);
    }

    @Override
    public void deleteById(int id) throws CastingNotFoundException {
        castingRepository.deleteById(id);
    }

    @Override
    public List<String> getMoviesByCasting(int castingId){
        Query query = entityManager.createNativeQuery("SELECT title FROM movie_castings JOIN movie m on movie_castings.movie_id = m.id JOIN casting c on movie_castings.castings_id = c.id where castings_id = ?");
        query.setParameter(1, castingId);
        List<String> titleList = query.getResultList();
        return titleList;
    }
}
