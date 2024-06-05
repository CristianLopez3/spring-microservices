package com.appdevlopers.api.users.photoappapiusers.service;

import com.appdevlopers.api.users.photoappapiusers.data.UserEntity;
import com.appdevlopers.api.users.photoappapiusers.data.UsersRepository;
import com.appdevlopers.api.users.photoappapiusers.shared.UserDto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import static org.junit.jupiter.api.Assertions.*;
import static reactor.core.publisher.Mono.when;

@ExtendWith(MockitoExtension.class)
class UsersServiceImplTest {

    @Mock
    UsersRepository usersRepository;

    @Mock
    BCryptPasswordEncoder bCryptPasswordEncoder;

    @InjectMocks
    UsersServiceImpl usersService;

    UserDto mockUserDetails;

    @BeforeEach
    void setUp() {
        mockUserDetails = new UserDto();
        mockUserDetails.setFirstName("John");
        mockUserDetails.setLastName("Doe");
        mockUserDetails.setEmail("john.doe@example.com");
        mockUserDetails.setPassword("password123");
        mockUserDetails.setUserId("1234");
        mockUserDetails.setEncryptedPassword("encryptedPassword123");
    }

    @Test
    void testCreateUser(){
    }



}