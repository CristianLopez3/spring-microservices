package com.easybytes.accounts.controller;

import com.easybytes.accounts.dto.CustomerDto;
import com.easybytes.accounts.dto.ResponseDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static com.easybytes.accounts.constants.AccountsConstants.MESSAGE_201;
import static com.easybytes.accounts.constants.AccountsConstants.STATUS_200;

@RequestMapping(value = "/api/accounts", produces = {MediaType.APPLICATION_JSON_VALUE})
@RestController
public class AccountsController {

    @GetMapping("/hello")
    public String hello() {
        return "Hello from Accounts Service!";
    }

    @PostMapping
    public ResponseEntity<ResponseDto> createAccount(@RequestBody CustomerDto customerDto) {

        var responseDto = new ResponseDto(STATUS_200, MESSAGE_201, customerDto);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(responseDto);
    }

}
