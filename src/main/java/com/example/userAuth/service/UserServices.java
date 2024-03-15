package com.example.userAuth.service;

import com.example.userAuth.dto.UserDTO;
import com.example.userAuth.model.Users;
import com.example.userAuth.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class UserServices {
    @Autowired
    private UserRepository userRepo;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private ModelMapper modelMapper;


    public Users addUsers(Users user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userRepo.save(user);
    }

    public List<UserDTO> findByRoles(String role) {
        List<Users> users = userRepo.findByRoles(role);
        return users.stream().map((user) -> modelMapper.map(user, UserDTO.class)).collect(Collectors.toList());
    }

    public List<UserDTO> findAllUsers() {
        List<Users> users = userRepo.findAll();
        return users.stream().map((user) -> modelMapper.map(user, UserDTO.class)).collect(Collectors.toList());
    }

    public UserDTO findByEmail(String email) {
      Users users = userRepo.findByEmail(email);
        return (modelMapper.map(users, UserDTO.class));

    }

}