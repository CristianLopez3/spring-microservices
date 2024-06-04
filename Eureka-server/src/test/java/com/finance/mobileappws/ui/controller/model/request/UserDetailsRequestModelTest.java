package com.finance.mobileappws.ui.controller.model.request;

import com.finance.mobileappws.model.request.UserDetailsRequestModel;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UserDetailsRequestModelTest {

    String FIRSTNAME = "John";
    String LASTNAME = "Doe";
    String EMAIL = "some@email.com";
    String PASSWORD = "123465**";

    UserDetailsRequestModel testClass;

    @BeforeEach
    void setUp() {
        testClass = new UserDetailsRequestModel();
        testClass.setFirstName(FIRSTNAME);
        testClass.setLastName(LASTNAME);
        testClass.setEmail(EMAIL);
        testClass.setPassword(PASSWORD);
    }

    @Test
    void testBuilder() {

        assertEquals(FIRSTNAME, testClass.getFirstName());
        assertEquals(LASTNAME, testClass.getLastName());
        assertEquals(EMAIL, testClass.getEmail());
        assertEquals(PASSWORD, testClass.getPassword());

    }


}