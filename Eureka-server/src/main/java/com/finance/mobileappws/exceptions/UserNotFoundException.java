package com.finance.mobileappws.exceptions;

import org.springframework.context.annotation.Bean;


public class UserNotFoundException extends RuntimeException {
    public UserNotFoundException(String message) {
        super(message);
    }
}
