package com.abm.moviesapi.controller;

import com.abm.moviesapi.entity.Director;
import com.abm.moviesapi.entity.Genre;
import com.abm.moviesapi.exceptions.CustomGenreExeption.GenreNotFoundException;
import com.abm.moviesapi.service.DirectorService;
import com.abm.moviesapi.service.GenreService;
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
@WebMvcTest(DirectorRestController.class)
class DirectorRestControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    DirectorService directorService;

    @Test
    void testingIfFindAllDirectors() {
        try {
            Director director = new Director(1, "Test Director Name");
            Director director1 = new Director(2, "Second Test Director Name");
            List<Director> list = new ArrayList<>();
            list.add(director);
            list.add(director1);

            BDDMockito.given(directorService.findAll())
                    .willReturn(list);


            mockMvc.perform(MockMvcRequestBuilders.get("/directors"))
                    .andExpect(MockMvcResultMatchers.status().isOk())
                    .andExpect(MockMvcResultMatchers.jsonPath("$[0].id").value(1))
                    .andExpect(MockMvcResultMatchers.jsonPath("$[0].directorName").value("Test Director Name"))
                    .andExpect(MockMvcResultMatchers.jsonPath("$[1].id").value(2))
                    .andExpect(MockMvcResultMatchers.jsonPath("$[1].directorName").value("Second Test Director Name"))
                    .andDo(MockMvcResultHandlers.print())
                    ;
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Test
    void testingIfGetMoviesByDirectorId() {
        try {
            List<String> titles = Arrays.asList("one", "two", "three");

            BDDMockito.given(directorService.getMoviesByDirector(ArgumentMatchers.anyInt()))
                    .willReturn(titles);
            BDDMockito.given(directorService.findById(ArgumentMatchers.anyInt()))
                    .willReturn(new Director(1, "Test Director Name"));

            mockMvc.perform(MockMvcRequestBuilders.get("/directors/1"))
                    .andExpect(MockMvcResultMatchers.status().isOk())
                    .andExpect(MockMvcResultMatchers.jsonPath("id").value(1))
                    .andExpect(MockMvcResultMatchers.jsonPath("directorName").value("Test Director Name"))
                    .andExpect(MockMvcResultMatchers.jsonPath("titles").isArray())
                    .andExpect(MockMvcResultMatchers.jsonPath("titles").value(Matchers.containsInAnyOrder("one", "two", "three")))
                    .andDo(MockMvcResultHandlers.print())
            ;
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Test
    void testingAddDirector() {
        Director director = new Director(1, "Test Director Name");
        try {
            mockMvc.perform(post("/directors")
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(new ObjectMapper().writeValueAsString(director)))
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
    void updateDirector() {
    }

    @Test
    void deleteDirector() {
        try {
            BDDMockito.given(directorService.findById(ArgumentMatchers.anyInt()))
                    .willReturn(new Director(999, "Director To Delete"));

            mockMvc.perform(MockMvcRequestBuilders
                    .delete("/directors/999")
                    .contentType(MediaType.APPLICATION_JSON)
                    .accept(MediaType.APPLICATION_JSON))
                    .andExpect(status().isNoContent())
                    .andDo(MockMvcResultHandlers.print());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
