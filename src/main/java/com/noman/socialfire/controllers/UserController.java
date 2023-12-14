package com.noman.socialfire.controllers;

import com.noman.socialfire.models.Users;
import com.noman.socialfire.repository.UserRepository;
import com.noman.socialfire.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
public class UserController {
    @Autowired
    UserRepository userRepository;
    @Autowired
    UserService userService;

    @PostMapping("/users")

    public Users CreateUser(@RequestBody Users user){

        Users saveduser=userService.RegisterUser(user);
        return saveduser;


    }

    @GetMapping("/users")
    public  List<Users> getusers(){
        List <Users> users = userRepository.findAll();
        return  users;

    }
    @GetMapping("/users/{userid}")
    public Users getuserbyid(@PathVariable("userid")Integer id) throws Exception {
        Users user=userService.findUserById(id);
        return user;

    }

    @PutMapping("/users/{userId}")
    public Users updateUser(@RequestBody Users user,@PathVariable Integer userId) throws Exception {

        Users updateduser=userService.UpdateUser(user,userId);
        return updateduser;

    }
    @PutMapping("/users/follow/{UserId1}/{UserId2}")
    public Users FollowUserHandler(@PathVariable Integer UserId1,@PathVariable Integer UserId2) throws Exception {
        Users user=userService.FollowUser(UserId1,UserId2);
        return user;
    }
    @GetMapping("/users/search")

    public List <Users> searchUser(@RequestParam ("query") String query){
        List <Users> users=userService.SearchUsers(query);
        return  users;

    }

}
