package com.gcp.springboot.jamsession.api.login;

import com.gcp.springboot.jamsession.api.user.User;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "Logins")
public class Login {
    // Class Definition
    @Id
    @Column(name = "login_id")
    private long loginID;

    @Column(name = "creation_date")
    private String creationDate;

    @Column(name = "logged_in")
    private Boolean loggedIn;

    @Column(name = "last_login")
    private Timestamp lastLogin;

    @Column(name = "salted_pass")
    private String saltedPass;

    @OneToOne
    @MapsId
    @JoinColumn(name = "user_id")
    private User user;

    public Login() {}

    // Getters and Setters
    public long getLoginID() {
        return loginID;
    }

    public void setLoginID(long loginID) {
        this.loginID = loginID;
    }

    public String getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(String creationDate) {
        this.creationDate = creationDate;
    }

    public Boolean getLoggedIn() {
        return loggedIn;
    }

    public void setLoggedIn(Boolean loggedIn) {
        this.loggedIn = loggedIn;
    }

    public Timestamp getLastLogin() {
        return lastLogin;
    }

    public void setLastLogin(Timestamp lastLogin) {
        this.lastLogin = lastLogin;
    }

    public String getSaltedPass() {
        return saltedPass;
    }

    public void setSaltedPass(String saltedPass) {
        this.saltedPass = saltedPass;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
