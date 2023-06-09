package com.monopolybankapp.validators;

import com.monopolybankapp.Entities.User;
import com.monopolybankapp.config.error.NegocioException;
import com.monopolybankapp.services.UserService;
import com.monopolybankapp.util.BigDecimalUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class Validator {

    @Autowired
    private UserService userService;

    public void tranfer(Long accontId, BigDecimal value) throws NegocioException {
        User origin = userService.getLoggerUser();
        User destiny = userService.getUser(accontId);
        if(destiny == null){
            throw new NegocioException("Conta destino inexistente");
        } else if(accontId.equals(origin.getId())){
            throw new NegocioException("Impossivel transferir para mesma conta");
        } else if(BigDecimalUtil.isLessThan(origin.getBalance(),value)){
            throw new NegocioException("Saldo insuficiente");
        }
    }

}
