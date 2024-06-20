package com.easybytes.accounts.service;

import com.easybytes.accounts.dto.CustomerDto;

public interface AccountsService {

    /**
     * @param customerDto - CustomerDto Object
     */
    void createdAccount(CustomerDto customerDto);



}
