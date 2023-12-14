package com.noman.socialfire.service;

import com.noman.socialfire.models.Users;

import java.util.List;

public interface UserService {
    public Users RegisterUser(Users user);
    public Users findUserById(Integer UserId) throws Exception;
    public Users findUserByEmail(String Email);
    public Users FollowUser(Integer Userid1,Integer Userid2) throws Exception;
    public Users UpdateUser(Users user,Integer UserId) throws Exception;
    public List<Users> SearchUsers(String query);


}
