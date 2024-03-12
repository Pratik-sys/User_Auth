package com.example.userAuth.service;

import com.example.userAuth.model.users;
import com.example.userAuth.repository.userRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class userServices {
    @Autowired
    private userRepository userRepo;
    public users addUsers(users user){return userRepo.save(user);}

}
