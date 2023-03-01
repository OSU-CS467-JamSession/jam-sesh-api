package com.gcp.springboot.jamsession.api.comment;

import com.gcp.springboot.jamsession.api.session.Session;
import com.gcp.springboot.jamsession.api.user.User;

import javax.persistence.*;

@Entity
@Table(name = "Comments")
public class Comment {
    // Class definition
    @Id @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "comment_id")
    private long id;

    @Column(name = "content")
    private String content;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "session_id")
    private Session session;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    // Getters and Setters
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Session getSession() {
        return session;
    }

    public void setSession(Session session) {
        this.session = session;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    // Constructors
    public Comment() {}

    public Comment(String content) {
        this.content = content;
    }
}
