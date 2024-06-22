package com.easybytes.accounts.service;

import com.easybytes.accounts.dto.CustomerDto;

public interface AccountsService {

    /**
     * @param customerDto - CustomerDto Object
     */
    void createdAccount(CustomerDto customerDto);

    /**
     * @param mobileNumber - Input Mobile Number
     * @return accounts details based on a given mobileNumber
     */
    CustomerDto fetchAccount(String mobileNumber);


    /**
     * @param customerDto - CustomerDto Object
     * @return boolean indicating if the update of the Account details is successful or not
     */
    boolean updateAccount(CustomerDto customerDto);


    /**
     *
     * @param mobileNumber - receive the mobile number of the Account to be deleted
     * @return boolean indicating if the deletion of the Account is successful or not
     */
    boolean deleteAccount(String mobileNumber);

}
