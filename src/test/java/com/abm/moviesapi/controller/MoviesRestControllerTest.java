package com.abm.moviesapi.controller;

import com.abm.moviesapi.entity.Movie;
import com.abm.moviesapi.service.MovieService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
//import org.junit.Test;
//import org.junit.runner.RunWith;
import org.junit.runner.RunWith;
import org.mockito.ArgumentMatchers;
import org.mockito.BDDMockito;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(MoviesRestController.class)
class MoviesRestControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    MovieService movieService;

    @Test
    void findAll() {

    }

    @Test
    void testDoesMethodReturnsValidObjInJson() {
        try {
            BDDMockito.given(movieService.findById(ArgumentMatchers.anyInt()))
                    .willReturn(new Movie(2, "New York Doll", 2005));

            mockMvc.perform(MockMvcRequestBuilders.get("/movies/2"))
                    .andExpect(MockMvcResultMatchers.status().isOk())
                    .andExpect(MockMvcResultMatchers.jsonPath("id").value(2))
                    .andExpect(MockMvcResultMatchers.jsonPath("title").value("New York Doll"))
                    .andExpect(MockMvcResultMatchers.jsonPath("year").value(2005))
            ;
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Test
    void addMovie() {
        Movie movie = new Movie(0, "Old York Toll", 1999);
        try {
            mockMvc.perform(post("/movies")
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(new ObjectMapper().writeValueAsString(movie)))
                    .andExpect(status().isOk());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    @Test
    void updateMovie() {
    }

    @Test
    void deleteMovie() {
        try {
            BDDMockito.given(movieService.findById(ArgumentMatchers.anyInt()))
                    .willReturn(new Movie(2, "New York Doll", 2005));

            mockMvc.perform(MockMvcRequestBuilders
            .delete("/movies/2")
            .contentType(MediaType.APPLICATION_JSON)
            .accept(MediaType.APPLICATION_JSON))
            .andExpect(status().isNoContent());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    //sprawdzic usuwanie filmu którego nie ma (czy rzuci 500)
}