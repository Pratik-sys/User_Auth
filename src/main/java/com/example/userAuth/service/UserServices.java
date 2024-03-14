package com.example.userAuth.service;

import com.example.userAuth.model.Users;
import com.example.userAuth.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class UserServices {
    @Autowired
    private UserRepository userRepo;
    @Autowired
    private PasswordEncoder passwordEncoder;

    public Users addUsers(Users user){
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userRepo.save(user);
    }

    public List<Users> findByRoles (String role){return userRepo.findByRoles(role);}
    public  List<Users> findAllUsers(){return userRepo.findAll();}
    public Optional<Users> findByEmail(String email) {return userRepo.findByEmail(email);}

}
