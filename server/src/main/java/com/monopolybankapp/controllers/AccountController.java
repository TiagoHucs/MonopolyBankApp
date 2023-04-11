package com.monopolybankapp.controllers;

import com.monopolybankapp.config.error.NegocioException;
import com.monopolybankapp.services.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;

@RestController
@RequestMapping("rest/account")
public class AccountController {

    @Autowired
    private AccountService accountService;

    @GetMapping("balance")
    public ResponseEntity<BigDecimal> getBalance() throws NegocioException {
        return ResponseEntity.ok(accountService.getBalance());
    }


}
