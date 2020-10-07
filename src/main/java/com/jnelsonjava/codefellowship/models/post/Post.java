package com.jnelsonjava.codefellowship.models.post;

import com.jnelsonjava.codefellowship.models.user.ApplicationUser;

import javax.persistence.*;
import java.sql.Date;
import java.util.Calendar;

@Entity
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long id;

    @ManyToOne
    ApplicationUser applicationUser;

    String body;
    Date createAt;

    public Post() {}

    public Post(ApplicationUser applicationUser, String body) {
        this.applicationUser = applicationUser;
        this.body = body;
        // reference for getting a current timestamp into DB - https://alvinalexander.com/java/java-current-date-example-now/
        this.createAt = new Date(Calendar.getInstance().getTime().getTime());
    }

    public ApplicationUser getApplicationUser() {
        return applicationUser;
    }

    public void setApplicationUser(ApplicationUser applicationUser) {
        this.applicationUser = applicationUser;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public Date getCreateAt() {
        return createAt;
    }

    public void setCreateAt(Date createAt) {
        this.createAt = createAt;
    }
}
