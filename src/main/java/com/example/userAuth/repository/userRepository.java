package com.example.userAuth.repository;

import com.example.userAuth.model.users;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface userRepository extends MongoRepository<users, String> {
}
