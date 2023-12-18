package com.noman.socialfire.controllers;

import com.noman.socialfire.models.Post;
import com.noman.socialfire.response.ApiResponse;
import com.noman.socialfire.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController

public class PostController {
    @Autowired
    PostService postService;
    @PostMapping("/posts/users/{userId}")
    public ResponseEntity<Post> createPost(@RequestBody Post post, @PathVariable Integer userId) throws Exception {
        Post createdpost=postService.CreateNewPost(post,userId);
        return new ResponseEntity<Post>(createdpost, HttpStatus.CREATED);
    }
    @DeleteMapping("posts/{postId}/{userId}")
    public ResponseEntity<ApiResponse> deletepost(@PathVariable Integer postId, @PathVariable Integer userId) throws Exception {
        String Message=postService.DeletePost(postId,userId);
        ApiResponse apiResponse=new ApiResponse(Message,true);
        return new ResponseEntity<ApiResponse>(apiResponse,HttpStatus.OK);

    }
    @GetMapping("/posts/{postId}")
    public ResponseEntity<Post>findPostByIdHandler(@PathVariable Integer postId) throws Exception {
        Post post=postService.FindPostByPostId(postId);
        return new ResponseEntity<Post>(post,HttpStatus.OK);
    }
    @GetMapping("/posts/users/{userId}")
    public ResponseEntity<List<Post>>getPostByUserId(@PathVariable Integer userId){
        List <Post> posts=postService.FindPostByUserId(userId);
        return new ResponseEntity<List<Post>>(posts,HttpStatus.OK);

    }
    @GetMapping("/posts")
    public ResponseEntity<List<Post>> findAllPostHandler(){
        List<Post> posts=postService.FindAllPost();
        return new ResponseEntity<List<Post>>(posts,HttpStatus.OK);
    }

    @PutMapping("/posts/{postId}/users/{userId}")
    public ResponseEntity<Post>SavedHandler(@PathVariable Integer postId,@PathVariable Integer userId) throws Exception {
        Post post=postService.SavedPost(postId,userId);
        return new ResponseEntity<Post>(post,HttpStatus.OK);
    }
    @PutMapping("/posts/like/{postId}/users/{userId}")
    public ResponseEntity<Post>LikedPostHandler(@PathVariable Integer postId,@PathVariable Integer userId) throws Exception {
        Post post=postService.LikePost(postId,userId);
        return new ResponseEntity<Post>(post,HttpStatus.OK);
    }








}
