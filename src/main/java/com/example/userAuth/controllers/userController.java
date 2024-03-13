package com.example.userAuth.controllers;

import com.example.userAuth.model.users;
import com.example.userAuth.service.userServices;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@AllArgsConstructor
public class userController {

   @Autowired
    private userServices userServ;
    @PostMapping("/add")
    public ResponseEntity<users> addUsersToDB(@RequestBody users user){return ResponseEntity.ok().body(userServ.addUsers(user));}
    @GetMapping("/get-by-roles")
    public  ResponseEntity<List<users>> getUsersByRoles(@RequestParam("role") String role){return ResponseEntity.ok().body(userServ.findByroles(role));}
    @GetMapping("/getAll")
    public ResponseEntity<List<users>> getAllUsers(){return ResponseEntity.ok().body(userServ.findAllUsers());}
}
