package com.hotelbooking.hotelbooking.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hotelbooking.hotelbooking.Entity.Account;
import com.hotelbooking.hotelbooking.Repository.AccountRepo;

@Service
public class AccountService {
    @Autowired
    private AccountRepo accountRepo;

    public Account getAccountById(String accountId) {
        Account account = accountRepo.findById(accountId).get();
        return account == null ? null : account;
    }

}