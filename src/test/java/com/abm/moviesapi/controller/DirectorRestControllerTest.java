package com.abm.moviesapi.controller;

import com.abm.moviesapi.entity.Director;
import com.abm.moviesapi.service.DirectorService;
import com.abm.moviesapi.service.GenreService;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
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
    void directorDTO() {
    }

    @Test
    void addDirector() {
    }

    @Test
    void updateDirector() {
    }

    @Test
    void deleteDirector() {
    }
}
