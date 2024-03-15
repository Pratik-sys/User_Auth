package com.example.userAuth.controllers;

import com.example.userAuth.dto.AddUserDTO;
import com.example.userAuth.dto.UserDTO;
import com.example.userAuth.model.Users;
import com.example.userAuth.service.UserServices;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@AllArgsConstructor
public class UserController {

   @Autowired
    private UserServices userServ;
    @PostMapping("/add")
    public ResponseEntity<UserDTO> addUsersToDB(@RequestBody AddUserDTO addUserDTO){return ResponseEntity.ok().body(userServ.addUsers(addUserDTO));}
    @GetMapping("/get-by-roles")
    public  ResponseEntity<List<UserDTO>> getUsersByRoles(@RequestParam("role") String role){return ResponseEntity.ok().body(userServ.findByRoles(role));}
    @GetMapping("/getAll")
    public ResponseEntity<List<UserDTO>> getAllUsers(){return ResponseEntity.ok().body(userServ.findAllUsers());}
    @GetMapping("/getByEmail")
    public ResponseEntity<UserDTO> getUserByEmail(@RequestParam("email") String email){return ResponseEntity.ok().body(userServ.findByEmail(email));}
    @DeleteMapping("/deleteUser/{id}")
    public ResponseEntity<String> deleteUserById(@PathVariable("id") String id){return  ResponseEntity.ok().body(userServ.deleteById(id));}
}
