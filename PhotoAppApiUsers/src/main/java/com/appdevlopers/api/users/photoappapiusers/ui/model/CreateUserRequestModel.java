package com.appdevlopers.api.users.photoappapiusers.ui.model;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import org.springframework.web.bind.annotation.GetMapping;

@Getter
@Setter
public class CreateUserRequestModel {

        @NotNull(message = "First name cannot be null")
        @Size(min = 2, message = "First name must not be less than two characters")
        private String firstName;

        @NotNull(message = "Last name cannot be null")
        @Size(min = 2, message = "Last name must not be less than two characters")
        private String lastName;

        @NotNull(message = "Password cannot be null")
        @Size(min = 8, max = 16, message = "Password must be equal or grater than 8 characters and less than 16 characters")
        private String password;

        @NotNull(message = "Email cannot be null")
        @Email
        private String email;

        // getters and setters
}


