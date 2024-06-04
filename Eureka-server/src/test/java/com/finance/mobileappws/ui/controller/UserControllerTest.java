package com.finance.mobileappws.ui.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.finance.mobileappws.model.request.UpdateUserDetails;
import com.finance.mobileappws.model.request.UserDetailsRequestModel;
import com.jayway.jsonpath.JsonPath;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
@DisplayName("User Controller Test")
public class UserControllerTest {

    @Autowired
    private MockMvc mockMvc;

    ObjectMapper objectMapper;

    @BeforeEach
    public void setUp() {
        objectMapper = new ObjectMapper();
    }


    @Test
    @DisplayName("Test Get Users")
    public void testGetUsers() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/users")
                        .param("page", "1")
                        .param("limit", "10")
                        .accept(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_XML))
                .andExpect(status().isOk());
    }

    @Test
    @DisplayName("Test Create User")
    public void testCreateUser() throws Exception {
        UserDetailsRequestModel userDetailsRequestModel = new UserDetailsRequestModel();
        userDetailsRequestModel.setFirstName("John");
        userDetailsRequestModel.setLastName("Doe");
        userDetailsRequestModel.setEmail("mock@email.com");
        userDetailsRequestModel.setPassword("123456");

        String jsonUserDetailsRequestModel = objectMapper.writeValueAsString(userDetailsRequestModel);

        mockMvc.perform(MockMvcRequestBuilders.post("/users")
                        .content(jsonUserDetailsRequestModel)
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }


    @Test
    @DisplayName("Test Update User")
    public void testUpdateUser() throws Exception {
        // Create a new UserDetailsRequestModel object
        UserDetailsRequestModel userDetailsRequestModel = new UserDetailsRequestModel();
        userDetailsRequestModel.setFirstName("John");
        userDetailsRequestModel.setLastName("Doe");
        userDetailsRequestModel.setEmail("mock@email.com");
        userDetailsRequestModel.setPassword("123456");

        // Convert the object to a JSON string
        String jsonUserDetailsRequestModel = objectMapper.writeValueAsString(userDetailsRequestModel);

        // Perform a POST request to create a new user
        MvcResult result = mockMvc.perform(MockMvcRequestBuilders.post("/users")
                        .content(jsonUserDetailsRequestModel)
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andReturn();

        // Extract the userId from the response
        String response = result.getResponse().getContentAsString();
        String userId = JsonPath.parse(response).read("$.userId");

        // Create a new UpdateUserDetails object
        UpdateUserDetails updateUserDetails = new UpdateUserDetails();
        updateUserDetails.setFirstName("UpdatedFirstName");
        updateUserDetails.setLastName("UpdatedLastName");

        // Convert the object to a JSON string
        String jsonUpdateUserDetails = objectMapper.writeValueAsString(updateUserDetails);

        // Perform a PUT request and expect a status of OK
        mockMvc.perform(MockMvcRequestBuilders.put("/users/{userId}", userId)
                        .content(jsonUpdateUserDetails)
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }


    @Test
    @DisplayName("Test Delete User")
    public void testDeleteUser() throws Exception {
        UserDetailsRequestModel userDetailsRequestModel = new UserDetailsRequestModel();
        userDetailsRequestModel.setFirstName("John");
        userDetailsRequestModel.setLastName("Doe");
        userDetailsRequestModel.setEmail("mock@gmail.com");
        userDetailsRequestModel.setPassword("123456");

        String jsonUserDetailsRequest = objectMapper.writeValueAsString(userDetailsRequestModel);
        MvcResult result = mockMvc.perform(MockMvcRequestBuilders.post("/users")
                        .content(jsonUserDetailsRequest)
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andReturn();

        String response = result.getResponse().getContentAsString();
        String userId = JsonPath.parse(response).read("$.userId");


        mockMvc.perform(MockMvcRequestBuilders.delete("/users/{userId}", userId)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }
}