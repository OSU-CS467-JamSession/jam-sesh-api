package com.gcp.springboot.jamsession.api.user;

import javax.persistence.*;

import com.gcp.springboot.jamsession.api.genre.Genre;
import com.gcp.springboot.jamsession.api.instrument.Instrument;
import com.gcp.springboot.jamsession.api.login.Login;

import java.sql.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "Users")
public class User {
    // Class Definition
    @Id @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "user_id")
    private long userId;

    @Column(name = "email")
    private String email;

    @Column(name = "name_first")
    private String nameFirst;

    @Column(name = "name_last")
    private String nameLast;

    @Column(name = "birthdate")
    private Date birthdate;

    @Column(name = "location_zipcode")
    private Integer locationZipcode;

    @Column(name = "location_city")
    private String locationCity;

    @Column(name = "location_state")
    private String locationState;

    @Column(name = "experience")
    private Integer experience;

    @ManyToMany
    @JoinTable(name = "Users_Instruments",
        joinColumns = { @JoinColumn(name = "user_id") },
        inverseJoinColumns = { @JoinColumn(name = "instrument_id") })
    private Set<Instrument> instruments = new HashSet<>();

    @ManyToMany
    @JoinTable(name = "Users_Genres",
        joinColumns = { @JoinColumn(name = "user_id") },
        inverseJoinColumns = { @JoinColumn(name = "genre_id") })
    private Set<Genre> genres = new HashSet<>();

    @OneToOne(cascade = CascadeType.ALL, mappedBy = "user", fetch = FetchType.LAZY)
    private Login login;

    public User() {}

    // Getters & Setters
    public long getId() {
        return userId;
    }

    public void setId(long userId) {
        this.userId = userId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNameFirst() {
        return nameFirst;
    }

    public void setNameFirst(String nameFirst) {
        this.nameFirst = nameFirst;
    }

    public String getNameLast() {
        return nameLast;
    }

    public void setNameLast(String nameLast) {
        this.nameLast = nameLast;
    }

    public Date getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(Date birthdate) {
        this.birthdate = birthdate;
    }
    
    public Integer getLocationZipcode() {
        return locationZipcode;
    }

    public void setLocationZipcode(Integer locationZipcode) {
        this.locationZipcode = locationZipcode;
    }

    public String getLocationCity() {
        return locationCity;
    }

    public void setLocationCity(String locationCity) {
        this.locationCity = locationCity;
    }
    
    public String getLocationState() {
        return locationState;
    }

    public void setLocationState(String locationState) {
        this.locationState = locationState;
    }

    public Integer getExperience() {return experience;}

    public void setExperience(Integer experience) {
        this.experience = experience;
    }

    public Set<Instrument> getInstruments() {
        return instruments;
    }
    
    public void addInstrument(Instrument instrument) {
        this.instruments.add(instrument);
        instrument.getUsers().add(this);
    }
      
    public void removeInstrument(Instrument instrument) {
        this.instruments.remove(instrument);
        instrument.getUsers().remove(this);
    }

    public Set<Genre> getGenres() {
        return genres;
    }
    
    public void addGenre(Genre genre) {
        this.genres.add(genre);
        genre.getUsers().add(this);
    }
      
    public void removeGenre(Genre genre) {
        this.genres.remove(genre);
        genre.getUsers().remove(this);
    }

    // Constructors
    public User(long userId, String email, String nameFirst,
                String nameLast, Date birthdate, Integer locationZipcode,
                String locationCity, String locationState, Integer experience)  {
        super();
        this.userId = userId;
        this.email = email;
        this.nameFirst = nameFirst;
        this.nameLast = nameLast;
        this.birthdate = birthdate;
        this.locationZipcode = locationZipcode;
        this.locationCity = locationCity;
        this.locationState = locationState;
        this.experience = experience;
    }
}
