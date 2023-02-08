package com.gcp.springboot.jamsession.api.session;

import com.gcp.springboot.jamsession.api.user.User;

import javax.persistence.*;

@Entity
@Table(name = "Sessions")
public class Session {
    // Class Definition
    @Id @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "session_id")
    private long id;

    @Column(name = "name")
    private String name;


    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    public Session() {}

    // Getters and Setters
    public long getSessionId() {
        return id;
    }

    public void setSessionId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Long getUserId() {
        return user.getUserId();
    }

    // Constructors
    public Session(long id, String name) {
        super();
        this.id = id;
        this.name = name;
    }
}
