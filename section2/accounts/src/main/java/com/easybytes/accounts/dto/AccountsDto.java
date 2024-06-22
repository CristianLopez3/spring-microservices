package com.easybytes.accounts.dto;


import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import lombok.Data;


@Data
@Schema(
        name = "Accounts",
        description = "Schema to hold Account information"
)
public class AccountsDto {


    @NotEmpty(message = "Account number cannot be empty")
    @Pattern(regexp = "(^$|[0-9]{10})", message = "Mobile number must be numeric")
    @Schema(
            description = "Mobile number of the customer",
            example = "1234567890"
    )
    private Long accountNumber;


    @NotEmpty(message = "Account type cannot be empty")
    @Schema(
            description = "Account type of the customer",
            example = "Savings"
    )
    private String accountType;


    @NotEmpty(message = "Branch address cannot be empty")
    @Schema(description = "Branch address of the customer")
    private String branchAddress;

}
