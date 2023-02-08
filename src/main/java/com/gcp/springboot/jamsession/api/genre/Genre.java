package com.gcp.springboot.jamsession.api.genre;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.gcp.springboot.jamsession.api.user.User;

@Entity
@Table(name = "Genres")
public class Genre {
    // Class Definition
    @Id @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "genre_id")
    private long id;

    @Column(name = "name")
    private String name;

    @ManyToMany(mappedBy = "genres")
    @JsonIgnore
    private Set<User> users = new HashSet<>();

    public Genre() {}

    // Getters & Setters
    public long getGenreId() {
        return id;
    }

    public void setGenreId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<User> getUsers() {
        return users;
    }
    
    public void setUsers(Set<User> users) {
        this.users = users;
    }

    // Constructors
    public Genre(long id, String name) {
        super();
        this.id = id;
        this.name = name;
    }
}
