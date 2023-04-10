package com.MonopolyBankAppServer.services;

import com.MonopolyBankAppServer.Entities.Account;
import com.MonopolyBankAppServer.Entities.User;
import com.MonopolyBankAppServer.repositories.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.UUID;

@Service
public class AccountService {

    @Autowired
    private UserService userService;

    @Autowired
    private AccountRepository accountRepository;

    public BigDecimal getBalance() {
        UUID accountId = userService.getLoggerUser().getAccount().getId();
        return accountRepository.getReferenceById(accountId).getBalance();
    }
}
