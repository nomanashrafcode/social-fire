package com.noman.socialfire.repository;

import com.noman.socialfire.models.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface UserRepository extends JpaRepository<Users,Integer> {
    public Users findByEmail(String Email);
    @Query("Select u from Users u where u.FirstName LIKE%:query% OR u.LastName LIKE%:query% OR u.email LIKE%:query%")
    public List <Users> searchUser(@Param("query")String query);
}
