package com.abm.moviesapi.dto;

import java.util.List;


public class GenreDTO {

    private int id;

    private String genreName;

    private List<String> titles;

    public GenreDTO(int id, String genreName, List<String> titles) {
        this.id = id;
        this.genreName = genreName;
        this.titles = titles;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getGenreName() {
        return genreName;
    }

    public void setGenreName(String genreName) {
        this.genreName = genreName;
    }

    public List<String> getTitles() {
        return titles;
    }

    public void setTitles(List<String> titles) {
        this.titles = titles;
    }
}
