package com.finance.mobileappws.model.request;

import jakarta.validation.constraints.NotNull;

public class UpdateUserDetails {

    @NotNull
    private String firstName;

    @NotNull
    private String lastName;

    public UpdateUserDetails(){}

    public UpdateUserDetails(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public @NotNull String getFirstName() {
        return firstName;
    }

    public void setFirstName(@NotNull String firstName) {
        this.firstName = firstName;
    }

    public @NotNull String getLastName() {
        return lastName;
    }

    public void setLastName(@NotNull String lastName) {
        this.lastName = lastName;
    }
}
