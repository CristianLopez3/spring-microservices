package com.appdevlopers.api.users.photoappapiusers.service;

import com.appdevlopers.api.users.photoappapiusers.shared.UserDto;
import com.appdevlopers.api.users.photoappapiusers.ui.model.CreateUserRequestModel;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@ExtendWith(MockitoExtension.class)
public class ModelMapperTest {

    ModelMapper modelMapper;

    @BeforeEach
    void setUp() {
        modelMapper = new ModelMapper();
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
    }

    @Test
    @DisplayName("Test CreateUserRequestModel map to UserDto")
    void testCreateUserRequestModelMapToUserDto() {

        CreateUserRequestModel createUserRequestModel = new CreateUserRequestModel();
        createUserRequestModel.setFirstName("John");
        createUserRequestModel.setLastName("Doe");
        createUserRequestModel.setEmail("mail@mail.com");
        createUserRequestModel.setPassword("password");


        UserDto expectedUserDto = new UserDto();
        expectedUserDto.setFirstName("John");
        expectedUserDto.setLastName("Doe");
        expectedUserDto.setEmail("mail@mail.com");
        expectedUserDto.setPassword("password");


        UserDto actualUserDto = modelMapper.map(createUserRequestModel, UserDto.class);
        System.out.println(actualUserDto.getEmail());
        assertThat(actualUserDto.getFirstName()).isEqualTo(expectedUserDto.getFirstName());
        assertThat(actualUserDto.getLastName()).isEqualTo(expectedUserDto.getLastName());
        assertThat(actualUserDto.getPassword()).isEqualTo(expectedUserDto.getPassword());
        assertThat(actualUserDto.getEmail()).isEqualTo(expectedUserDto.getEmail());

    }


}
