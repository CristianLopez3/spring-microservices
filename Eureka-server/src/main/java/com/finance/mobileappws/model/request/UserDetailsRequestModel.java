package com.finance.mobileappws.model.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public class UserDetailsRequestModel {

    @NotNull
    private String firstName;

    @NotNull
    private String lastName;

    @NotNull
    @Email(message = "Email should be valid")
    private String email;

    @NotNull(message = "Password cannot be null")
    @Size(
            min = 8,
            max = 16,
            message = "Password must be equal or greater than 8 characters and less than 16 characters"
    )
    @Pattern(
            regexp = "(?=.*[A-Z])(?=.*[!@#$&*]).*",
            message = "Password must contain at least one uppercase letter and one special character"
    )
    private String password;


    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
