package com.monopolybankapp.controllers;

import com.monopolybankapp.Entities.HomeDetails;
import com.monopolybankapp.config.error.NegocioException;
import com.monopolybankapp.services.AccountService;
import com.monopolybankapp.validators.AccountValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;

@RestController
@RequestMapping("rest/account")
public class AccountController {

    @Autowired
    private AccountService accountService;

    @Autowired
    private AccountValidator accountValidator;

    @GetMapping("home")
    public ResponseEntity<HomeDetails> getBalance() throws NegocioException {
        return ResponseEntity.ok(accountService.getHomeDetails());
    }

    @PostMapping("transfer")
    public ResponseEntity<Void> transfer(@RequestBody TransferVO transfer) throws NegocioException {
        accountValidator.tranfer(transfer.getAccountId(),transfer.getValue());
        accountService.tranfer(transfer.getAccountId(),transfer.getValue());
        return ResponseEntity.accepted().build();
    }


}
