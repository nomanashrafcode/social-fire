package com.noman.socialfire.service;

import com.noman.socialfire.models.Users;
import com.noman.socialfire.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImplementation implements UserService{
    @Autowired
    UserRepository userRepository;

    @Override
    public Users RegisterUser(Users user) {
        Users newuser=new Users();
        newuser.setEmail(user.getEmail());
        newuser.setFirstName(user.getFirstName());
        newuser.setLastName(user.getLastName());
        newuser.setPassword(user.getPassword());
        newuser.setId(user.getId());
        Users saveduser=userRepository.save(newuser);
        return saveduser;
    }

    @Override
    public Users findUserById(Integer UserId) throws Exception {
        Optional<Users> user=userRepository.findById(UserId);
        if (user.isPresent()){
            return user.get();
        }
        throw new Exception("user does not exist with id "+UserId);
    }

    @Override
    public Users findUserByEmail(String Email) {
        Users user=userRepository.findByEmail(Email);
        return user;
    }

    @Override
    public Users FollowUser(Integer Userid1, Integer Userid2) throws Exception {
        Users user1=findUserById(Userid1);
        Users user2=findUserById(Userid2);
        user2.getFollowers().add(user1.getId());
        user1.getFollowing().add(user2.getId());
        userRepository.save(user1);
        userRepository.save(user2);

        return user1;
    }

    @Override
    public Users UpdateUser(Users user,Integer UserId) throws Exception {
        Optional<Users> user1= userRepository.findById(UserId);
        if (user1.isEmpty()){
            throw new Exception("User not found with id"+UserId);
        }
        Users olduser =user1.get();
        if (user.getFirstName()!=null){
            olduser.setFirstName(user.getFirstName());
        }
        if (user.getLastName()!=null){
            olduser.setLastName(user.getLastName());
        }
        if(user.getEmail()!=null){
            olduser.setEmail(user.getEmail());
        }
        Users updateduser=userRepository.save(olduser);
        return updateduser;
    }

    @Override
    public List<Users> SearchUsers(String query) {

        return userRepository.searchUser(query);
    }
}
