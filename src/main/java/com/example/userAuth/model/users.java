package com.example.userAuth.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;
import java.util.Date;

@Document
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class users {
    @Id
    private  String id;
    private  String userName;
    private  String email;
    private  String password;
    @Transient
    private  String confirmPassword;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "Asia/Kolkata")
    private Date createdDateTime = new Date();
    private roles roles;

}
