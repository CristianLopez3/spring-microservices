package com.easybytes.accounts.mapper;


import com.easybytes.accounts.dto.AccountsDto;
import com.easybytes.accounts.entity.Accounts;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class AccountsMapperTest {

    @Test
    void testMapToAccountsDto() {
        Accounts accounts = new Accounts();
        accounts.setAccountNumber(1234567890L);
        accounts.setAccountType("SAVINGS");
        accounts.setBranchAddress("Mock Address");

        AccountsDto accountsDto = new AccountsDto();
        AccountsDto mappedAccountsDto = AccountsMapper.mapToAccountsDto(accounts, accountsDto);

        assertEquals(accounts.getAccountNumber(), mappedAccountsDto.getAccountNumber());
        assertEquals(accounts.getAccountType(), mappedAccountsDto.getAccountType());
        assertEquals(accounts.getBranchAddress(), mappedAccountsDto.getBranchAddress());
    }

    @Test
    void testMapToAccounts() {
        AccountsDto accountsDto = new AccountsDto();
        accountsDto.setAccountNumber(1234567890L);
        accountsDto.setAccountType("SAVINGS");
        accountsDto.setBranchAddress("Mock Address");

        Accounts accounts = new Accounts();
        Accounts mappedAccounts = AccountsMapper.mapToAccounts(accountsDto, accounts);

        assertEquals(accountsDto.getAccountNumber(), mappedAccounts.getAccountNumber());
        assertEquals(accountsDto.getAccountType(), mappedAccounts.getAccountType());
        assertEquals(accountsDto.getBranchAddress(), mappedAccounts.getBranchAddress());
    }
}