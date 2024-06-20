package com.easybytes.accounts.mapper;

import com.easybytes.accounts.dto.AccountsDto;
import com.easybytes.accounts.entity.Accounts;

public class AccountsMapper {

    public static AccountsDto mapToAccountsDto(Accounts accounts, AccountsDto accountsDto) {
        accountsDto.setAccountNumber(accountsDto.getAccountNumber());
        accountsDto.setAccountType(accountsDto.getAccountType());
        accountsDto.setBranchAddress(accountsDto.getBranchAddress());
        return accountsDto;
    }

    public static Accounts mapToAccounts(AccountsDto accountDto, Accounts accounts) {
        accounts.setAccountNumber(accountDto.getAccountNumber());
        accounts.setAccountType(accountDto.getAccountType());
        accounts.setBranchAddress(accountDto.getBranchAddress());
        return accounts;
    }

}
