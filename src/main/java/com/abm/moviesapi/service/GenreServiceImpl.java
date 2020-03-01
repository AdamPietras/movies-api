package com.abm.moviesapi.service;

import com.abm.moviesapi.entity.Genre;
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
public class GenreServiceImpl implements GenreService {

    private DirectorRepository directorRepository;
    private GenreRepository genreRepository;
    private CastingRepository castingRepository;
    private MovieRepository movieRepository;

    @PersistenceContext
    EntityManager entityManager;


    @Autowired
    public GenreServiceImpl(DirectorRepository directorRepository, GenreRepository genreRepository, CastingRepository castingRepository, MovieRepository movieRepository) {
        this.directorRepository = directorRepository;
        this.genreRepository = genreRepository;
        this.castingRepository = castingRepository;
        this.movieRepository = movieRepository;
    }

    @Override
    public List<Genre> findAll() {
        return genreRepository.findAll();
    }

    @Override
    public Genre findById(int id){
        return genreRepository.findById(id).get();
    }

    @Override
    public void save(Genre genre){
        genreRepository.save(genre);
    }

    @Override
    public void deleteById(int id){
        genreRepository.deleteById(id);
    }

    @Override
    public List<String> getMoviesByGenre (int genryId){
        Query query = entityManager.createNativeQuery("select m.title from genre as g join movie_genres as mg on g.id = mg.genres_id join movie as m on mg.movie_id = m.id where g.id = ?");
        query.setParameter(1, genryId);
        List<String> titleList = query.getResultList();
        return titleList;
    }
}
