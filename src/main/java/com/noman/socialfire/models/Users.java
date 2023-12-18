package com.noman.socialfire.models;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Users {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private  String FirstName;
    private  String LastName;
    private  String email;
    private  String Password;

    private List<Integer> Followers=new ArrayList<>();
    private List<Integer> Following=new ArrayList<>();

    private String Gender;
    @ManyToMany
    private List<Post>savedpost=new ArrayList();

    public Users(Integer id, String firstName, String lastName, String email, String password, List<Integer> followers, List<Integer> following, String gender, List<Post> savedpost) {
        this.id = id;
        FirstName = firstName;
        LastName = lastName;
        this.email = email;
        Password = password;
        Followers = followers;
        Following = following;
        Gender = gender;
        this.savedpost = savedpost;
    }



    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFirstName() {
        return FirstName;
    }

    public void setFirstName(String firstName) {
        FirstName = firstName;
    }

    public String getLastName() {
        return LastName;
    }

    public void setLastName(String lastName) {
        LastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }

    public List<Integer> getFollowers() {
        return Followers;
    }

    public void setFollowers(List<Integer> followers) {
        Followers = followers;
    }

    public List<Integer> getFollowing() {
        return Following;
    }

    public void setFollowing(List<Integer> following) {
        Following = following;
    }

    public String getGender() {
        return Gender;
    }

    public void setGender(String gender) {
        Gender = gender;
    }


    public List<Post> getSavedpost() {
        return savedpost;
    }

    public void setSavedpost(List<Post> savedpost) {
        this.savedpost = savedpost;
    }

    public Users(){}
}
