package com.gcp.springboot.jamsession.api.instrument;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.gcp.springboot.jamsession.api.user.User;

@Entity
public class Instrument {
    @Id @GeneratedValue(strategy=GenerationType.IDENTITY)
    private long instrument_id;

    private String name;
    
    private String type;

    @ManyToMany(mappedBy = "instruments")
    @JsonIgnore
    private Set<User> users = new HashSet<>();
    
    public Instrument() {}

    public long getId() {
        return instrument_id;
    }

    public void setId(long instrument_id) {
        this.instrument_id = instrument_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Set<User> getUsers() {
        return users;
    }
    
    public void setUsers(Set<User> users) {
        this.users = users;
    }

    public Instrument(long instrument_id, String name, String type, Set<User> users) {
        super();
        this.instrument_id = instrument_id;
        this.name = name;
        this.type = type;
        this.users = users;
    }
}
