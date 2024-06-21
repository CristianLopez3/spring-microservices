package com.easybytes.accounts.controller;

import com.easybytes.accounts.dto.CustomerDto;
import com.easybytes.accounts.dto.ResponseDto;
import com.easybytes.accounts.service.AccountsService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import static com.easybytes.accounts.constants.AccountsConstants.*;

@AllArgsConstructor
@Validated
@RestController
@RequestMapping(value = "/api/accounts", produces = {MediaType.APPLICATION_JSON_VALUE})
public class AccountsController {

    private final AccountsService accountsService;

    @PostMapping
    public ResponseEntity<ResponseDto> createAccount(@Valid @RequestBody CustomerDto customerDto) {
        accountsService.createdAccount(customerDto);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(new ResponseDto(STATUS_201, MESSAGE_201, customerDto));
    }

    @GetMapping("/fetch")
    public ResponseEntity<CustomerDto> fetchAccountDetails(
            @RequestParam
            @Pattern(regexp = "(^$|[0-9]{10})", message = "Mobile number must be numeric") String mobileNumber) {

        CustomerDto customerDto = accountsService.fetchAccount(mobileNumber);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(customerDto);
    }

    @PutMapping
    public ResponseEntity<ResponseDto> updateAccountDetails(@Valid @RequestBody CustomerDto customerDto) {
        boolean isUpdated = accountsService.updateAccount(customerDto);
        return isUpdated
                ? ResponseEntity.status(HttpStatus.OK).body(new ResponseDto(STATUS_200, MESSAGE_200, customerDto))
                : ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new ResponseDto(STATUS_500, MESSAGE_500, customerDto));

    }

    @DeleteMapping
    public ResponseEntity<ResponseDto> deleteAccount(
            @RequestParam
            @Pattern(regexp = "(^$|[0-9]{10})", message = "Mobile number must be numeric") String mobileNumber) {

        boolean isDeleted = accountsService.deleteAccount(mobileNumber);
        return isDeleted
                ? ResponseEntity.status(HttpStatus.OK).body(new ResponseDto(STATUS_200, MESSAGE_200, mobileNumber))
                : ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new ResponseDto(STATUS_500, MESSAGE_500, mobileNumber));
    }

}
