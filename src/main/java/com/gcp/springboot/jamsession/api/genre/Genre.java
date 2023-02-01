package com.gcp.springboot.jamsession.api.genre;

import javax.persistence.*;

@Entity
@Table(name = "Genres")
public class Genre {
    // Class Definition
    @Id @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "genre_id")
    private long genre_id;

    @Column(name = "name")
    private String name;

    public Genre() {}

    // Getters & Setters
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

    // Constructors
    public Genre(long genre_id, String name) {
        super();
        this.genre_id = genre_id;
        this.name = name;
    }
}
