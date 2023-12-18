package com.noman.socialfire.service;

import com.noman.socialfire.models.Post;

import java.util.List;

public interface PostService {
    Post CreateNewPost(Post post, Integer userId) throws Exception;
    String DeletePost(Integer postId,Integer userId) throws Exception;
    List<Post> FindPostByUserId(Integer userId);
    Post FindPostByPostId(Integer postId) throws Exception;
    List<Post> FindAllPost();
    Post SavedPost(Integer postId,Integer userId) throws Exception;
    Post LikePost(Integer postId,Integer userId) throws Exception;
}
