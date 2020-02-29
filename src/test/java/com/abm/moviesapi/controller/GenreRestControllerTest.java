package com.abm.moviesapi.controller;

import com.abm.moviesapi.dto.GenreDTO;
import com.abm.moviesapi.entity.Genre;
import com.abm.moviesapi.entity.Movie;
import com.abm.moviesapi.exceptions.CustomGenreExeption.GenreNotFoundException;
import com.abm.moviesapi.exceptions.CustomMovieException.MovieNotFoundException;
import com.abm.moviesapi.service.GenreService;
import com.abm.moviesapi.service.MovieService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentMatchers;
import org.mockito.BDDMockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(GenreRestController.class)
class GenreRestControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    GenreService genreService;

    @Test
    void testingIfFindAllGenres() {
        try {
            Genre genre = new Genre(1 ,"Comedy");
            Genre genre2 = new Genre(2,"Horror");
            List<Genre> list = new ArrayList<>();
            list.add(genre);
            list.add(genre2);

            BDDMockito.given(genreService.findAll())
                    .willReturn(list);


            mockMvc.perform(MockMvcRequestBuilders.get("/genres"))
                    .andExpect(MockMvcResultMatchers.status().isOk())
                    .andExpect(MockMvcResultMatchers.jsonPath("$[0].id").value(1))
                    .andExpect(MockMvcResultMatchers.jsonPath("$[0].name").value("Comedy"))
                    .andExpect(MockMvcResultMatchers.jsonPath("$[1].id").value(2))
                    .andExpect(MockMvcResultMatchers.jsonPath("$[1].name").value("Horror"))
                    .andDo(MockMvcResultHandlers.print())

            ;
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Test
    void testingIfGetMoviesByGenreId() {
        try {
            List<String> titles = Arrays.asList("one", "two", "three");

            BDDMockito.given(genreService.getMoviesByGenre(ArgumentMatchers.anyInt()))
                    .willReturn(titles);
            BDDMockito.given(genreService.findById(ArgumentMatchers.anyInt()))
                    .willReturn(new Genre(1, "Comedy"));

            mockMvc.perform(MockMvcRequestBuilders.get("/genres/1"))
                    .andExpect(MockMvcResultMatchers.status().isOk())
                    .andExpect(MockMvcResultMatchers.jsonPath("id").value(1))
                    .andExpect(MockMvcResultMatchers.jsonPath("genreName").value("Comedy"))
                    .andExpect(MockMvcResultMatchers.jsonPath("titles").isArray())
                    .andExpect(MockMvcResultMatchers.jsonPath("titles").value(Matchers.containsInAnyOrder("one", "two", "three")))
                    .andDo(MockMvcResultHandlers.print())
            ;
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Test
    void testingAddGenre() {
        Genre genre = new Genre(0,"I don't know");
        try {
            mockMvc.perform(post("/genres")
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(new ObjectMapper().writeValueAsString(genre)))
                    .andExpect(status().isOk())
                    .andDo(MockMvcResultHandlers.print());
        } catch (GenreNotFoundException d) {
            d.printStackTrace();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    void testingDeleteGenreById() {
        try {
            BDDMockito.given(genreService.findById(ArgumentMatchers.anyInt()))
                    .willReturn(new Genre(999, "Category To Delete"));

            mockMvc.perform(MockMvcRequestBuilders
                    .delete("/genres/999")
                    .contentType(MediaType.APPLICATION_JSON)
                    .accept(MediaType.APPLICATION_JSON))
                    .andExpect(status().isNoContent())
                    .andDo(MockMvcResultHandlers.print());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
