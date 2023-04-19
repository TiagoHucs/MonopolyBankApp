package com.monopolybankapp.validators;

import com.monopolybankapp.Entities.User;
import com.monopolybankapp.config.error.NegocioException;
import com.monopolybankapp.repositories.AccountRepository;
import com.monopolybankapp.services.UserService;
import com.monopolybankapp.util.BigDecimalUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class AccountValidator {

    @Autowired
    private UserService userService;

    @Autowired
    private AccountRepository accountRepository;

    public void tranfer(Long accontId, BigDecimal value) throws NegocioException {
        User user = userService.getLoggerUser();
        if(user.getAccount() == null){
            throw new NegocioException("Usuario sem conta associada");
        } else if(accontId.equals(user.getAccount().getId())){
            throw new NegocioException("Impossivel transferir para mesma conta");
        } else if(BigDecimalUtil.isLessThan(user.getAccount().getBalance(),value)){
            throw new NegocioException("Saldo insuficiente");
        } else if(!isAccountValid(accontId)){
            throw new NegocioException("Conta destino inválida");
        }
    }

    private boolean isAccountValid(Long accontId) {
        return accountRepository.getReferenceById(accontId) != null;
    }
}
