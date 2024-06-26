package com.easybytes.accounts.mapper;

import com.easybytes.accounts.dto.CustomerDto;
import com.easybytes.accounts.entity.Customer;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CustomerMapperTest {

    @Test
    void testMapToCustomerDto() {
        Customer customer = new Customer();
        customer.setName("Mock Name");
        customer.setEmail("mock@mail.com");
        customer.setMobileNumber("1234567890");

        CustomerDto customerDto = new CustomerDto();
        CustomerDto mappedCustomerDto = CustomerMapper.mapToCustomerDto(customer, customerDto);

        assertEquals(customer.getName(), mappedCustomerDto.getName());
        assertEquals(customer.getEmail(), mappedCustomerDto.getEmail());
        assertEquals(customer.getMobileNumber(), mappedCustomerDto.getMobileNumber());
    }

    @Test
    void testMapToCustomer() {
        CustomerDto customerDto = new CustomerDto();
        customerDto.setName("Mock Name");
        customerDto.setEmail("mock@mail.com");
        customerDto.setMobileNumber("1234567890");

        Customer customer = new Customer();
        Customer mappedCustomer = CustomerMapper.mapToCustomer(customerDto, customer);

        assertEquals(customerDto.getName(), mappedCustomer.getName());
        assertEquals(customerDto.getEmail(), mappedCustomer.getEmail());
        assertEquals(customerDto.getMobileNumber(), mappedCustomer.getMobileNumber());
    }
}