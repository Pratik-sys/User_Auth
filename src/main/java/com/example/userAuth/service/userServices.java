package com.example.userAuth.service;

import com.example.userAuth.model.users;
import com.example.userAuth.repository.userRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class userServices {
    @Autowired
    private userRepository userRepo;
    @Autowired
    private PasswordEncoder passwordEncoder;

    public users addUsers(users user){
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userRepo.save(user);
    }

    public List<users> findByRoles (String role){return userRepo.findByRoles(role);}
    public  List<users> findAllUsers(){return userRepo.findAll();}
    public Optional<users> findByEmail(String email) {return userRepo.findByEmail(email);}

}
