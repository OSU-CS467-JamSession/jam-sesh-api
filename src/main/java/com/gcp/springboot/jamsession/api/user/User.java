package com.gcp.springboot.jamsession.api.user;

import javax.persistence.*;
import java.sql.Date;

@Entity // keyword that tells the Spring Boot that the following
        // class should be considered as a table class
public class User {
    @Id     // Fields annotated with @ID will be treated as Primary Key
    @GeneratedValue(strategy = GenerationType.AUTO) // auto-generate ID
    @Column(name="user_id")  // specifies the column name
    private long user_id;
    private String email;
    private String salted_pass;
    private String name_first;
    private String name_last;
    private Date birthdate;
    private Integer location_zipcode;
    private String location_city;
    private String location_state;
    public User() {
    }

    public long getId() {
        return user_id;
    }

    public void setId(long user_id) {
        this.user_id = user_id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSaltedPass() {
        return salted_pass;
    }

    public void setSaltedPass(String salted_pass) {
        this.salted_pass = salted_pass;
    }

    public String getNameFirst() {
        return name_first;
    }

    public void setNameFirst(String name_first) {
        this.name_first = name_first;
    }

    public String getNameLast() {
        return name_last;
    }

    public void setNameLast(String name_last) {
        this.name_last = name_last;
    }

    public Date getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(Date birthdate) {
        this.birthdate = birthdate;
    }
    
    public Integer getLocationZipcode() {
        return location_zipcode;
    }

    public void setLocationZipcode(Integer location_zipcode) {
        this.location_zipcode = location_zipcode;
    }

    public String getLocationCity() {
        return location_city;
    }

    public void setLocationCity(String location_city) {
        this.location_city = location_city;
    }
    
    public String getLocationState() {
        return location_state;
    }

    public void setLocationState(String location_state) {
        this.location_state = location_state;
    }

    public User(long user_id, String email, String salted_pass, String name_first,
                String name_last, Date birthdate, Integer location_zipcode,
                String location_city, String location_state) {
        super();
        this.user_id = user_id;
        this.email = email;
        this.salted_pass = salted_pass;
        this.name_first = name_first;
        this.name_last = name_last;
        this.birthdate = birthdate;
        this.location_zipcode = location_zipcode;
        this.location_city = location_city;
        this.location_state = location_state;
    }
}
