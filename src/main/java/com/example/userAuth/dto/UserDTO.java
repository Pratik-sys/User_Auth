package com.example.userAuth.dto;

import com.example.userAuth.model.Roles;
import lombok.Data;

@Data
public class UserDTO {
    private  String id;
    private  String userName;
    private  String email;
    private Roles roles;
}
