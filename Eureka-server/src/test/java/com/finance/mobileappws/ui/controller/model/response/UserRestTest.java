package com.finance.mobileappws.ui.controller.model.response;

import com.finance.mobileappws.model.response.UserRest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("User Rest Test")
public class UserRestTest {

    @Test
    public void testBuilder() {
        String userId = "123";
        String firstName = "John";
        String lastname = "Doe";
        String email = "john.doe@example.com";

        UserRest userRest = new UserRest();
        userRest.setUserId(userId);
        userRest.setFirstName(firstName);
        userRest.setLastname(lastname);
        userRest.setEmail(email);

        assertEquals(userId, userRest.getUserId());
        assertEquals(firstName, userRest.getFirstName());
        assertEquals(lastname, userRest.getLastname());
        assertEquals(email, userRest.getEmail());
    }
}