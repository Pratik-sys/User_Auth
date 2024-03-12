package com.example.userAuth.controllers;

import com.example.userAuth.model.users;
import com.example.userAuth.service.userServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class userController {

   @Autowired
    private userServices userServ;

    @PostMapping("/add")
    public ResponseEntity<users> addUsersToDB(@RequestBody users user){
        return  ResponseEntity.ok().body(userServ.addUsers(user));
    }

}
