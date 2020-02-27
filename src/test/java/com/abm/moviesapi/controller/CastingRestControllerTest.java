package com.abm.moviesapi.controller;

import com.abm.moviesapi.entity.Casting;
import com.abm.moviesapi.service.CastingService;
import com.fasterxml.jackson.databind.ObjectMapper;
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
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(CastingRestController.class)
class CastingRestControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    CastingService castingService;

    @Test
    void findAll() {
    }

    @Test
    void getCasting() {
        try {
            BDDMockito.given(castingService.findById(ArgumentMatchers.anyInt()))
                    .willReturn(new Casting(2, "Sylvain Sylvain"));
            mockMvc.perform(MockMvcRequestBuilders.get("/casting/2"))
                    .andExpect(status().isOk())
                    .andExpect(MockMvcResultMatchers.jsonPath("id").value(2))
                    .andExpect(MockMvcResultMatchers.jsonPath("actorName").value("Sylvain Sylvain"))
            ;
        }catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    void addCasting() {
        Casting casting = new Casting(2, "Sylvain Sylvain");
        try {
            mockMvc.perform(post("/casting")
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(new ObjectMapper().writeValueAsString(casting)))
                    .andExpect(status().isOk());
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Test
    void updateCasting() {
    }

    @Test
    void deleteCasting() {
        try{
            BDDMockito.given(castingService.findById(ArgumentMatchers.anyInt()))
                    .willReturn(new Casting(2, "Sylvain Sylvain"));

            mockMvc.perform(MockMvcRequestBuilders
            .delete("/casting/2")
            .contentType(MediaType.APPLICATION_JSON)
            .accept(MediaType.APPLICATION_JSON))
            .andExpect(status().isNoContent());
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}