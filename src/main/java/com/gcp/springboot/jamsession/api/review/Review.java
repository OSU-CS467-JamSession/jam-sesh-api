package com.gcp.springboot.jamsession.api.review;

import com.gcp.springboot.jamsession.api.post.Post;
import com.gcp.springboot.jamsession.api.user.User;

import javax.persistence.*;

@Entity
@Table(name = "Reviews")
public class Review {
    // Class definition
    @Id @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "review_id")
    private long id;

    @Column(name = "comment")
    private String comment;

    @Column(name = "liked")
    private Boolean liked;

    @ManyToOne
    @JoinColumn(name = "post_id")
    private Post post;

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

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Post getPost() {
        return post;
    }

    public long getPostId() {
        return post.getPostId();
    }

    public void setPost(Post post) {
        this.post = post;
    }

    public User getUser() {
        return user;
    }

    public long getUserId() {
        return user.getUserId();
    }

    public void setUser(User user) {
        this.user = user;
    }

    // Constructors
    public Review() {}

    public Review(String comment, Boolean liked) {
        this.comment = comment;
        this.liked = liked;
    }
}
