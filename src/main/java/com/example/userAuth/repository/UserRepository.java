package com.example.userAuth.repository;

import com.example.userAuth.model.Users;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface UserRepository extends MongoRepository<Users, String> {
    @Query("{'roles' : '?0'}")
    List<Users> findByRoles(String role);
    @Query("{'email' : ?0}")
    Users findByEmail(String email);
}
