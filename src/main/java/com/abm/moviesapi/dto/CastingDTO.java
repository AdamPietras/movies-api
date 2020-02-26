package com.abm.moviesapi.dto;

import com.abm.moviesapi.entity.Movie;

import java.util.List;

public class CastingDTO {

    private int id;

    private String actorName;

    private List<String> titles;

    public CastingDTO(int id, String actorName, List<String> titles) {
        this.id = id;
        this.actorName = actorName;
        this.titles = titles;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getActorName() {
        return actorName;
    }

    public void setActorName(String actorName) {
        this.actorName = actorName;
    }

    public List<String> getTitles() {
        return titles;
    }

    public void setTitles(List<String> titles) {
        this.titles = titles;
    }
}
