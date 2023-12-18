package com.noman.socialfire.repository;

import com.noman.socialfire.models.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PostRepository extends JpaRepository<Post,Integer> {

    @Query("select p from Post p where p.user.id=:UserId")
    List<Post> FindPostByUSerId(Integer UserId);

}
