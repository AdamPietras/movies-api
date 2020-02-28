package com.abm.moviesapi.dto;

import java.util.List;


public class DirectorDTO {

    private int id;

    private String directorName;

    private List<String> titles;

    public DirectorDTO(int id, String directorName, List<String> titles) {
        this.id = id;
        this.directorName = directorName;
        this.titles = titles;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDirectorName() {
        return directorName;
    }

    public void setDirectorName(String genreName) {
        this.directorName = genreName;
    }

    public List<String> getTitles() {
        return titles;
    }

    public void setTitles(List<String> titles) {
        this.titles = titles;
    }
}
