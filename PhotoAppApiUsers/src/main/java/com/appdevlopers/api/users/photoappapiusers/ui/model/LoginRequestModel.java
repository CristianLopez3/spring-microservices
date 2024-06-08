package com.appdevlopers.api.users.photoappapiusers.ui.model;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LoginRequestModel {

    @Email(message = "Please provide a valid email")
    @NotBlank
    private String email;

    @NotBlank(message = "Please provide a password")
    private String password;

}
