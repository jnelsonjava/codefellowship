package com.jnelsonjava.codefellowship.models.user;

import com.jnelsonjava.codefellowship.models.post.Post;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.sql.Date;
import java.util.*;

@Entity
public class ApplicationUser implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long id;

    @Column(unique = true)
    String username;
    private String password;

    @OneToMany(mappedBy = "applicationUser", cascade = CascadeType.ALL)
    List<Post> posts = new ArrayList<>();

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "follows",
            joinColumns = { @JoinColumn(name = "follower")},
            inverseJoinColumns = {@JoinColumn(name = "following")}
    )
    Set<ApplicationUser> following = new HashSet<>();

    @ManyToMany(mappedBy = "following")
    Set<ApplicationUser> followers = new HashSet<>();

    String firstName = null;
    String lastName = null;
    Date dateOfBirth = null;
    String bio = null;
    @Column(unique = true)
    String email = null;
//    Using https://placeholder.com/ for temporary profile image
    String profileImgUrl = "https://via.placeholder.com/150";

    public ApplicationUser() {}

    public ApplicationUser(String username, String password, String email) {
        this.username = username;
        this.password = password;
        this.email = email;
    }

    @Override
    public String toString() {
        return "ApplicationUser{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", email='" + email + '\'' +
                '}';
    }

    public long getId() {
        return id;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getFullName() {
        return firstName + " " + lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    public String getEmail() {
        return email;
    }

    public String getProfileImgUrl() {
        return profileImgUrl;
    }

    public void setProfileImgUrl(String profileImgUrl) {
        this.profileImgUrl = profileImgUrl;
    }

    public List<Post> getPosts() {
        return posts;
    }

    public Set<ApplicationUser> getFollowing() {
        return following;
    }

    public Set<ApplicationUser> getFollowers() {
        return followers;
    }

    public void follow(ApplicationUser userToFollow) {
        following.add(userToFollow);
    }

    public void getFollower(ApplicationUser follower) {
        followers.add(follower);
    }

    public void removeFollower(ApplicationUser follower) {
        followers.remove(follower);
    }

    public void removeFollow(ApplicationUser userToUnfollow) {
        following.remove(userToUnfollow);
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
