package com.easybytes.accounts.service;



import com.easybytes.accounts.dto.CustomerDto;
import com.easybytes.accounts.entity.Accounts;
import com.easybytes.accounts.entity.Customer;
import com.easybytes.accounts.exception.CustomerAlreadyExistsException;
import com.easybytes.accounts.repository.AccountsRepository;
import com.easybytes.accounts.repository.CustomerRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class AccountsServiceImpTest {

    @Mock
    private AccountsRepository accountsRepository;

    @Mock
    private CustomerRepository customerRepository;

    @InjectMocks
    private AccountsServiceImp accountsServiceImp;

    private CustomerDto customerDto;
    private Customer customer;
    private Accounts accounts;

    @BeforeEach
    void setUp() {
        customerDto = new CustomerDto();
        customerDto.setEmail("mock@mail.com");
        customerDto.setName("Mock Name");
        customerDto.setMobileNumber("1234567890");

        customer = new Customer();
        customer.setId(1L);
        customer.setEmail("mock@mail.com");
        customer.setName("Mock Name");
        customer.setMobileNumber("1234567890");

        accounts = new Accounts();
        accounts.setCustomerId(1L);
        accounts.setAccountNumber(1234567890L);
    }

    @Test
    void testCreatedAccount() {
        when(customerRepository.findByMobileNumber(anyString())).thenReturn(Optional.empty());
        when(customerRepository.save(any(Customer.class))).thenReturn(customer);
        when(accountsRepository.save(any(Accounts.class))).thenReturn(accounts);

        assertDoesNotThrow(() -> accountsServiceImp.createdAccount(customerDto));
    }

    @Test
    void testCreatedAccount_CustomerAlreadyExists() {
        when(customerRepository.findByMobileNumber(anyString())).thenReturn(Optional.of(customer));

        assertThrows(CustomerAlreadyExistsException.class, () -> accountsServiceImp.createdAccount(customerDto));
    }

    @Test
    void testFetchAccount() {
        when(customerRepository.findByMobileNumber(anyString())).thenReturn(Optional.of(customer));
        when(accountsRepository.findByCustomerId(anyLong())).thenReturn(Optional.of(accounts));

        CustomerDto fetchedCustomerDto = accountsServiceImp.fetchAccount("1234567890");

        assertNotNull(fetchedCustomerDto);
        assertEquals(customerDto.getEmail(), fetchedCustomerDto.getEmail());
        assertEquals(customerDto.getName(), fetchedCustomerDto.getName());
        assertEquals(customerDto.getMobileNumber(), fetchedCustomerDto.getMobileNumber());
    }


    @Test
    void testDeleteAccount() {
        when(customerRepository.findByMobileNumber(anyString())).thenReturn(Optional.of(customer));

        assertTrue(accountsServiceImp.deleteAccount("1234567890"));
    }
}