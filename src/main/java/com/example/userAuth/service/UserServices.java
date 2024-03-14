package com.example.userAuth.service;

import com.example.userAuth.dto.UserDTO;
import com.example.userAuth.model.Users;
import com.example.userAuth.repository.UserRepository;
import lombok.AllArgsConstructor;
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

    public Users addUsers(Users user){
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userRepo.save(user);
    }

    public List<Users> findByRoles (String role){return userRepo.findByRoles(role);}
    public  List<UserDTO> findAllUsers(){
        return userRepo
                .findAll()
                .stream()
                .map(this::convertDataIntoDTO)
                .collect(Collectors.toList());
    }

    private UserDTO convertDataIntoDTO(Users user) {
        UserDTO udto = new UserDTO();
        udto.setId(user.getId());
        udto.setEmail(user.getEmail());
        udto.setUserName(user.getUserName());
        udto.setRoles(user.getRoles());
        return udto;
    }

    public Optional<Users> findByEmail(String email) {return userRepo.findByEmail(email);}


}
