package com.appdevlopers.api.users.photoappapiusers.data;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "users")
public class UserEntity {


    private static final long serialVersionUID = -2731425678149216053L;


    @Id
    @GeneratedValue
    private long id;


    @Column(nullable = false, length = 50)
    private String firstName;


    @Column(nullable = false, length = 50)
    private String lastName;


    @Column(nullable = false, length = 120, unique = true)
    private String email;


    @Column(nullable = false, unique = true)
    private String userId;


    @Column(nullable = false, unique = true)
    private String encryptedPassword;



}
