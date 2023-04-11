package com.monopolybankapp.services;

import com.monopolybankapp.Entities.Account;
import com.monopolybankapp.Entities.User;
import com.monopolybankapp.config.error.NegocioException;
import com.monopolybankapp.repositories.AccountRepository;
import com.monopolybankapp.util.BigDecimalUtil;
import com.monopolybankapp.validators.AccountValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
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

    @Transactional
    public void tranfer(Long accontId, BigDecimal value) {
        User user = userService.getLoggerUser();

        //get accounts
        Account origin =  user.getAccount();
        Account destiny = accountRepository.getReferenceById(accontId);

        //operations //TODO: criar logica de transferencia e historico
        origin.setBalance(origin.getBalance().subtract(value));
        destiny.setBalance(destiny.getBalance().add(value));

        accountRepository.save(origin);
        accountRepository.save(destiny);
    }

}
