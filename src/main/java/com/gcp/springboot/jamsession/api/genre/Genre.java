package com.gcp.springboot.jamsession.api.genre;

import javax.persistence.*;

@Entity // keyword that tells the Spring Boot that the following
        // class should be considered as a table class
public class Genre {
    @Id @GeneratedValue(strategy=GenerationType.IDENTITY)
    private long genre_id;
    private String name;
    public Genre() {
    }

    public long getId() {
        return genre_id;
    }

    public void setId(long genre_id) {
        this.genre_id = genre_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Genre(long genre_id, String name) {
        super();
        this.genre_id = genre_id;
        this.name = name;
    }
}
