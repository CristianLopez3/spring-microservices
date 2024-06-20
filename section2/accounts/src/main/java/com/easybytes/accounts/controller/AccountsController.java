package com.easybytes.accounts.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/accounts")
@RestController
public class AccountsController {

    @GetMapping("/hello")
    public String hello() {
        return "Hello from Accounts Service!";
    }

}
