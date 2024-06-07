package com.appdevlopers.api.users.photoappapiusers.service;

import com.appdevlopers.api.users.photoappapiusers.data.UserEntity;
import com.appdevlopers.api.users.photoappapiusers.data.UsersRepository;
import com.appdevlopers.api.users.photoappapiusers.shared.UserDto;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class UsersServiceImplTest {

    @Mock
    UsersRepository usersRepository;

    @Mock
    BCryptPasswordEncoder bCryptPasswordEncoder;

    @InjectMocks
    UsersServiceImpl usersService;

    @Test
    void createUser() {
        // Arrange
        UserDto userDetails = new UserDto();
        userDetails.setFirstName("John");
        userDetails.setLastName("Doe");
        userDetails.setEmail("john.doe@example.com");
        userDetails.setPassword("password123");

        UserEntity userEntity = new UserEntity();
        userEntity.setFirstName("John");
        userEntity.setLastName("Doe");
        userEntity.setEmail("john.doe@example.com");
        userEntity.setEncryptedPassword("encryptedPassword123");

        when(bCryptPasswordEncoder.encode(any())).thenReturn("encryptedPassword123");
        when(usersRepository.save(any())).thenReturn(userEntity);

        // Act
        UserDto createdUser = usersService.createUser(userDetails);

        // Assert
        assertThat(userDetails.getFirstName()).isEqualTo(createdUser.getFirstName());
        assertThat(userDetails.getLastName()).isEqualTo(createdUser.getLastName());
        assertEquals(userDetails.getEmail(), createdUser.getEmail());
        assertEquals("encryptedPassword123", createdUser.getEncryptedPassword());
    }
}


