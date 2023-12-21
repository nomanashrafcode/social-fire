package com.noman.socialfire.service;

import com.noman.socialfire.models.Post;
import com.noman.socialfire.models.Users;
import com.noman.socialfire.repository.PostRepository;
import com.noman.socialfire.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import static java.time.LocalDateTime.*;

@Service
public class PostServiceImplementation implements PostService{
    @Autowired
    PostRepository postRepository;
    @Autowired
    UserService userService;
    @Autowired
    UserRepository userRepository;
    @Override
    public Post CreateNewPost(Post post, Integer userId) throws Exception {
        Users user=userService.findUserById(userId);
        Post newpost= new Post();
        newpost.setCaption(post.getCaption());
        newpost.setImage(post.getImage());
        newpost.setVideo(post.getVideo());
        newpost.setUser(user);
        newpost.setCreatedAt(LocalDateTime.now());
        Post savedpost=postRepository.save(newpost);
        return savedpost;
    }

    @Override
    public String DeletePost(Integer postId, Integer userId) throws Exception {
        Post post=FindPostByPostId(postId);
        Users user=userService.findUserById(userId);
        if (post.getUser().getId()!=user.getId()){
            throw new Exception("You cannot delete this post ");
        }
        postRepository.delete(post);
        return "Post deleted succesfully";
    }

    @Override
    public List<Post> FindPostByUserId(Integer userId) {
        return postRepository.FindPostByUSerId(userId);

    }

    @Override
    public Post FindPostByPostId(Integer postId) throws Exception {
         Optional<Post> optionalPost=postRepository.findById(postId);
         if(optionalPost.isEmpty()){
             throw new Exception("post not found with id "+postId);
         }
        return optionalPost.get();
    }

    @Override
    public List<Post> FindAllPost() {
        return postRepository.findAll();
    }

    @Override
    public Post SavedPost(Integer postId, Integer userId) throws Exception {
        Post post=FindPostByPostId(postId);
        Users user=userService.findUserById(userId);
        if (user.getSavedpost().contains(post)){
            user.getSavedpost().remove(post);
        }
        else user.getSavedpost().add(post);
        userRepository.save(user);
        return post;
    }

    @Override
    public Post LikePost(Integer postId, Integer userId) throws Exception {
        Post post=FindPostByPostId(postId);
        Users user=userService.findUserById(userId);
        if (post.getLiked().contains(user)){
            post.getLiked().remove(user);

        }
        else{
            post.getLiked().add(user);

        }

        return postRepository.save(post);
    }

}
