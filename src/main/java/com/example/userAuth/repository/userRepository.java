package com.example.userAuth.repository;

import com.example.userAuth.model.users;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;

@Repository
public interface userRepository extends MongoRepository<users, String> {
    @Query("{'roles' : '?0'}")
    List<users> findByRoles(String role);
    @Query("{'email' : ?0}")
    Optional<users> findByEmail(String email);
}
