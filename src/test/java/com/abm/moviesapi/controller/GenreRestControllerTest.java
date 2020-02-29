package com.abm.moviesapi.controller;

import com.abm.moviesapi.dto.GenreDTO;
import com.abm.moviesapi.entity.Genre;
import com.abm.moviesapi.service.GenreService;
import com.abm.moviesapi.service.MovieService;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentMatchers;
import org.mockito.BDDMockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
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

@RunWith(SpringRunner.class)
@WebMvcTest(GenreRestController.class)
class GenreRestControllerTest {


    @Autowired
    private MockMvc mockMvc;

    @MockBean
    GenreService genreService;

    @Test
    void findAll() {
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
                    .andExpect(MockMvcResultMatchers.jsonPath("$[2].name").value("Horror"))
                    .andDo(MockMvcResultHandlers.print())

            ;
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Test
    void getGenre() {
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
                    .andExpect(MockMvcResultMatchers.jsonPath("titles", Matchers.containsInAnyOrder("one", "two", "three")))
                    .andDo(MockMvcResultHandlers.print())
            ;
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
