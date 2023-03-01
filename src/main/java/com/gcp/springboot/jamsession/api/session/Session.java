package com.gcp.springboot.jamsession.api.session;

import com.gcp.springboot.jamsession.api.comment.Comment;
import com.gcp.springboot.jamsession.api.user.User;
import com.gcp.springboot.jamsession.api.user.UserRepository;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Entity
@Table(name = "Sessions")
public class Session {
    // Class Definition
    @Id @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "session_id")
    private long id;

    @Column(name = "title")
    private String title;

    @Column(name = "description")
    private String description;

    @Column(name = "location_city")
    private String location_city;

    @Column(name = "location_state")
    private String location_state;

    @Column(name = "location_zip_code")
    private String location_zip_code;

    // TODO: use proper type datetime for sorting
    @Column(name = "time_creation")
    private String datetime;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @OneToMany(mappedBy = "session", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Comment> comments = new HashSet<>();

    public Session() {}

    // Getters and Setters
    public long getSessionId() {
        return id;
    }

    public void setSessionId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getLocation_city() {
        return location_city;
    }

    public void setLocation_city(String location_city) {
        this.location_city = location_city;
    }

    public String getLocation_state() {
        return location_state;
    }

    public void setLocation_state(String location_state) {
        this.location_state = location_state;
    }

    public String getLocation_zip_code() {
        return location_zip_code;
    }

    public void setLocation_zip_code(String location_zip_code) {
        this.location_zip_code = location_zip_code;
    }

    public String getDatetime() {
        return datetime;
    }

    public void setDatetime(String datetime) {
        this.datetime = datetime;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Set<Comment> getComments() {
        return comments;
    }

    public void setComments(Set<Comment> comments) {
        this.comments = comments;
    }

    // Constructors
//    public Session(String name) {
//        super();
//        this.name = name;
//    }

    public Session(String title, String description, String location_city, String location_state, String location_zip_code, String datetime) {
        super();
        this.title = title;
        this.description = description;
        this.location_city = location_city;
        this.location_state = location_state;
        this.location_zip_code = location_zip_code;
        this.datetime = datetime;
    }
}
