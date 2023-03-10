package com.gcp.springboot.jamsession.api.user;

import javax.persistence.*;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import com.gcp.springboot.jamsession.api.comment.Comment;
import com.gcp.springboot.jamsession.api.genre.Genre;
import com.gcp.springboot.jamsession.api.instrument.Instrument;
import com.gcp.springboot.jamsession.api.login.Login;
import com.gcp.springboot.jamsession.api.post.Post;
import com.gcp.springboot.jamsession.api.review.Review;
import com.gcp.springboot.jamsession.api.session.Session;

import java.sql.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "Users")
public class User {
    // Class Definition
    @Id @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Long id;

    @Column(name = "email", unique = true)
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

    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Login login;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Session> sessions = new HashSet<>();

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Post> posts = new HashSet<>();

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Comment> comments = new HashSet<>();

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Review> reviews = new HashSet<>();

    public User() {}

    // Getters & Setters
    public Long getUserId() {
        return id;
    }

    public void setUserId(Long id) {
        this.id = id;
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

    public void setInstruments(Set<Instrument> instruments) {
        this.instruments = instruments;
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
 
    public Set<Session> getSessions() {
        return sessions;
    }

    public Set<Post> getPosts() {
        return posts;
    }

    public Login getLogin() {
        return login;
    }

    public void setLogin(Login login) {
        this.login = login;
    }

    // public void addSession(Session session) {
    //     this.sessions.add(session);
    //     session.setUser(this);
    // }

    // public void removeSession(Session session) {
    //     this.sessions.remove(session);
    //     session.setUser(null);
    // }

    public Set<Comment> getComments() {
        return comments;
    }

    public void setComments(Set<Comment> comments) {
        this.comments = comments;
    }

    public Set<Review> getReviews() {
        return reviews;
    }

    // Constructors
    public User(String email, String nameFirst,
                String nameLast, Date birthdate, Integer locationZipcode,
                String locationCity, String locationState, Integer experience)  {
        super();
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
