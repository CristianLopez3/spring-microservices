package com.easybytes.accounts.service;

import com.easybytes.accounts.dto.CustomerDto;
import com.easybytes.accounts.repository.AccountsRepository;
import com.easybytes.accounts.repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AccountsServiceImp implements AccountsService{

    private final AccountsRepository accountsRepository;
    private final CustomerRepository customerRepository;

    @Override
    public void createdAccount(CustomerDto customerDto) {

    }
}
