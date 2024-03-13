package com.example.userAuth.controllers;

import com.example.userAuth.model.users;
import com.example.userAuth.service.userServices;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@AllArgsConstructor
public class userController {

   @Autowired
    private userServices userServ;
    @PostMapping("/add")
    public ResponseEntity<users> addUsersToDB(@RequestBody users user){return ResponseEntity.ok().body(userServ.addUsers(user));}
    @GetMapping("/get-by-roles")
    public  ResponseEntity<List<users>> getUsersByRoles(@RequestParam("role") String role){return ResponseEntity.ok().body(userServ.findByRoles(role));}
    @GetMapping("/getAll")
    public ResponseEntity<List<users>> getAllUsers(){return ResponseEntity.ok().body(userServ.findAllUsers());}
    @GetMapping("/getByEmail")
    public ResponseEntity<Optional<users>> getUserByEmail(@RequestParam("email") String email){return ResponseEntity.ok().body(userServ.findByEmail(email));}
}
