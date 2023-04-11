package com.monopolybankapp.services;

import com.monopolybankapp.Entities.User;
import com.monopolybankapp.config.error.NegocioException;
import com.monopolybankapp.repositories.AccountRepository;
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

    public BigDecimal getBalance() throws NegocioException {
        User user = userService.getLoggerUser();
        if(user.getAccount() == null){
            throw new NegocioException("Usuario sem conta associada");
        }
        return user.getAccount().getBalance();
    }
}
