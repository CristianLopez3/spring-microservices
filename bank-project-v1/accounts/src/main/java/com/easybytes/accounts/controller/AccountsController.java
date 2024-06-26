package com.easybytes.accounts.controller;

import com.easybytes.accounts.dto.AccountsContactInfoDto;
import com.easybytes.accounts.dto.CustomerDto;
import com.easybytes.accounts.dto.ErrorResponseDto;
import com.easybytes.accounts.dto.ResponseDto;
import com.easybytes.accounts.service.AccountsService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import static com.easybytes.accounts.constants.AccountsConstants.*;

@Tag(
        name = "CRUD REST API for Accounts in EazyBank",
        description = "Endpoints for managing customer accounts"
)
@AllArgsConstructor
@Validated
@RestController
@RequestMapping(value = "/api/accounts", produces = {MediaType.APPLICATION_JSON_VALUE})
public class AccountsController {

    private final AccountsService accountsService;

    private final AccountsContactInfoDto accountsContactInfoDto;

    @Operation(
            summary = "Create a new account REST API",
            description = "Create a new account for a customer"
    )
    @ApiResponse(
            responseCode = "201",
            description = "Account created successfully"
    )
    @PostMapping
    public ResponseEntity<ResponseDto> createAccount(@Valid @RequestBody CustomerDto customerDto) {
        accountsService.createdAccount(customerDto);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(new ResponseDto(STATUS_201, MESSAGE_201));
    }


    @Operation(
            summary = "Fetch account REST API",
            description = "Fetch account details for a customer"
    )
    @ApiResponse(
            responseCode = "200",
            description = "Account fetched successfully"
    )
    @GetMapping("/fetch")
    public ResponseEntity<CustomerDto> fetchAccountDetails(
            @RequestParam
            @Pattern(regexp = "(^$|[0-9]{10})", message = "Mobile number must be numeric") String mobileNumber) {

        CustomerDto customerDto = accountsService.fetchAccount(mobileNumber);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(customerDto);
    }


    @Operation(
            summary = "Update account REST API",
            description = "Update account details for a customer"
    )
    @ApiResponses({
            @ApiResponse(
                    responseCode = "200",
                    description = "Account updated successfully"
            ),
            @ApiResponse(
                    responseCode = "417",
                    description = "Unable to process the request. Please try again later"
            ),
            @ApiResponse(
                    responseCode = "500",
                    description = "Internal server error",
                    content = @Content(
                            schema = @Schema(implementation = ErrorResponseDto.class)
                    )
            )
    })
    @PutMapping
    public ResponseEntity<ResponseDto> updateAccountDetails(@Valid @RequestBody CustomerDto customerDto) {
        boolean isUpdated = accountsService.updateAccount(customerDto);
        return isUpdated
                ? ResponseEntity.status(HttpStatus.OK).body(new ResponseDto(STATUS_200, MESSAGE_200))
                : ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(new ResponseDto(STATUS_417, MESSAGE_417));

    }


    @Operation(
            summary = "Delete account REST API",
            description = "Delete account for a customer"
    )
    @ApiResponses({
            @ApiResponse(
                    responseCode = "200",
                    description = "Account deleted successfully"
            ),
            @ApiResponse(
                    responseCode = "417",
                    description = "Unable to process the request. Please try again later"
            ),
            @ApiResponse(
                    responseCode = "500",
                    description = "Internal server error"
            )
    })
    @DeleteMapping
    public ResponseEntity<ResponseDto> deleteAccount(
            @RequestParam
            @Pattern(regexp = "(^$|[0-9]{10})", message = "Mobile number must be numeric") String mobileNumber) {

        boolean isDeleted = accountsService.deleteAccount(mobileNumber);
        return isDeleted
                ? ResponseEntity.status(HttpStatus.OK).body(new ResponseDto(STATUS_200, MESSAGE_200))
                : ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(new ResponseDto(STATUS_417, MESSAGE_417));
    }


    @GetMapping("/contact-info")
    public ResponseEntity<AccountsContactInfoDto> getContactInfo() {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(accountsContactInfoDto);
    }

}
