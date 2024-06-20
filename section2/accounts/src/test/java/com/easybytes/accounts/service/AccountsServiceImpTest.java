package com.easybytes.accounts.service;

import com.easybytes.accounts.dto.CustomerDto;
import com.easybytes.accounts.repository.AccountsRepository;
import com.easybytes.accounts.repository.CustomerRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class AccountsServiceImpTest {

    @Mock
    private AccountsRepository accountsRepository;

    @Mock
    private CustomerRepository customerRepository;

    @InjectMocks
    private AccountsServiceImp accountsServiceImp;

    @Test
    void testCreateAccountDto(){
        CustomerDto customerDto = new CustomerDto();
        customerDto.setEmail("mock@mail.com");
        customerDto.setName("Mock Name");
        customerDto.setMobileNumber("1234567890");

    }


}