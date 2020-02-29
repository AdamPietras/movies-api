package com.abm.moviesapi.entity;

import javax.persistence.*;

@Entity
public class Director {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String directorName;

    public Director() {
    }

    public Director(String directorName) {
        this.directorName=directorName;
    }

    public Director(int id, String directorName) {
        this.id = id;
        this.directorName=directorName;
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

    public void setDirectorName(String directorName) {
        this.directorName = directorName;
    }
}
