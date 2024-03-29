package com.example.userAuth.service;

import com.example.userAuth.dto.AddUserDTO;
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


    public UserDTO addUsers(AddUserDTO addUserDTO) {
        Users user  = modelMapper.map(addUserDTO , Users.class);
        user.setPassword(passwordEncoder.encode(addUserDTO.getPassword()));
        Users savedUser = userRepo.save(user);
        return modelMapper.map(savedUser, UserDTO.class);
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
    public String deleteById(String id){
        Optional<Users> users = userRepo.findById(id);
        if (users.isPresent()){
            userRepo.deleteById(id);
            return ("User with id :" + id + "is deleted");
        }
        else {
            return ("Something went wrong");
        }
    }
}