package com.MonopolyBankAppServer.controllers;

import com.MonopolyBankAppServer.services.AccountService;
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
    public ResponseEntity<BigDecimal> getBalance(){
        return ResponseEntity.ok(accountService.getBalance());
    }


}
