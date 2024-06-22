package com.easybytes.accounts.dto;


import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.*;
import lombok.Data;

@Schema(
        name = "Customer",
        description = "Schema to hold Customer and Account information"
)
@Data
public class CustomerDto {

    @Schema(
            description = "Unique identifier for the customer",
            example = "1"
    )
    @NotEmpty(message = "Name cannot be empty")
    @Size(min = 2, max = 50, message = "Name must be between 2 and 50 characters")
    private String name;


    @Schema(
            description = "Email address of the customer",
            example = "john@email.com"
    )
    @NotEmpty(message = "Email cannot be empty")
    @Email(message = "Email should be valid")
    private String email;


    @Schema(
            description = "Mobile number of the customer",
            example = "1234567890"
    )
    @NotEmpty(message = "Mobile number cannot be empty")
    @Pattern(regexp = "(^$|[0-9]{10})", message = "Mobile number must be numeric and have 10 digits")
    private String mobileNumber;


    @Schema( description = "Account details of the Customer" )
    private AccountsDto accountsDto;

}
