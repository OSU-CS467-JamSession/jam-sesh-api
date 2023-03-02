package com.gcp.springboot.jamsession.api.post;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.gcp.springboot.jamsession.api.review.Review;
import com.gcp.springboot.jamsession.api.user.User;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

@Entity
@Table(name = "Posts")
public class Post {
    // Class Definition
    @Id @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "post_id")
    private Long id;

    @Column(name = "title")
    private String title;

    @Column(name = "description")
    private String description;

    // TODO: use proper type datetime for sorting
    @Column(name = "time_creation")
    private String datetime;

    @JsonIgnore
    @Column(name = "data")
    @Lob
    private byte[] data;

    @JsonIgnore
    @Column(name = "filetype")
    private String type;

    @Column(name = "media_link")
    private String link;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @OneToMany(mappedBy = "post", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Review> reviews = new HashSet<>();

    public Post() {}

    // Getters and Setters
    public long getPostId() {
        return id;
    }

    public void setPostId(long id) {
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

    public String getDatetime() {
        return datetime;
    }

    public void setDatetime(String datetime) {
        this.datetime = datetime;
    }

    public byte[] getData() {
        return data;
    }

    public void setData(byte[] data) {
        this.data = data;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getMediaLink() {
        return link;
    }

    public void setMediaLink(String link) {
        this.link = link;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Long getUserId() {
        return user.getUserId();
    }

    public Set<Review> getReviews() {
        return reviews;
    }

    public void setReviews(Set<Review> reviews) {
        this.reviews = reviews;
    }

    // Constructors
    public Post(String title, String description, String datetime, byte[] data, String type, User user) {
        super();
        this.title = title;
        this.description = description;
        this.datetime = datetime;
        this.data = data;
        this.type = type;
        this.user = user;
    }
}
