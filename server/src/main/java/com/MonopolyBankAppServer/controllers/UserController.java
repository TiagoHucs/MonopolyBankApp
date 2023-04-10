package com.MonopolyBankAppServer.controllers;

import com.MonopolyBankAppServer.Entities.LoginRequest;
import com.MonopolyBankAppServer.Entities.User;
import com.MonopolyBankAppServer.services.AccountService;
import com.MonopolyBankAppServer.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

@RestController
@RequestMapping("rest/users")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("balance")
    public ResponseEntity<BigDecimal> getBalance(){
        return ResponseEntity.ok(BigDecimal.ZERO);
    }

    @GetMapping("create")
    public ResponseEntity<Void> create(@RequestBody UserCreateVO userVo){
        userService.create(userVo);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }


}