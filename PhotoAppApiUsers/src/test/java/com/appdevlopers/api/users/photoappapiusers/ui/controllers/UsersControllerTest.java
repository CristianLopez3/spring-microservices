package com.appdevlopers.api.users.photoappapiusers.ui.controllers;

import com.appdevlopers.api.users.photoappapiusers.service.UsersService;
import com.appdevlopers.api.users.photoappapiusers.shared.UserDto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.core.env.Environment;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(MockitoExtension.class)
public class UsersControllerTest {

    @Mock
    private UsersService usersService;

    @Mock
    private Environment env;

    @InjectMocks
    private UsersController usersController;

    private MockMvc mockMvc;

    @BeforeEach
    void setUp() {
        mockMvc = MockMvcBuilders.standaloneSetup(usersController).build();
    }

    @Test
    void testStatus() throws Exception {
        when(env.getProperty(any(String.class))).thenReturn("8089");
        mockMvc.perform(get("/users/status/check"))
                .andExpect(status().isOk());
    }

    @Test
    @DisplayName("Test Create User")
    void testCreateUser() throws Exception {
        when(usersService.createUser(any(UserDto.class))).thenReturn(new UserDto());

        String userJson = """
            {
                "firstName":"John",
                "lastName":"Doe",
                "password":"password",
                "email":"mail@mail.com"
            }
        """;

        mockMvc.perform(post("/users")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(userJson)
                ).andExpect(status().isCreated());
    }
}