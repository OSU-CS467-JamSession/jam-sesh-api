package com.gcp.springboot.jamsession.api.school;

import javax.persistence.*;

@Entity // keyword that tells the Spring Boot that the following
        // class should be considered as a table class
public class School {
    @Id     // Fields annotated with @ID will be treated as Primary Key
    @GeneratedValue(strategy = GenerationType.AUTO) // auto-generate ID
    @Column(name="id")  // specifies the column name
    private long id;
    private String name;
    private String principle;
    private String address;

    public School() {

    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPrinciple() {
        return principle;
    }

    public void setPrinciple(String principle) {
        this.principle = principle;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public School(long id, String name, String principle, String address) {
        super();
        this.id = id;
        this.name = name;
        this.principle = principle;
        this.address = address;
    }
}
